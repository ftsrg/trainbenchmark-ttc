"""
@author: Zsolt Kovari

The module is responsible for providing valid Configuration objects.
"""
import sys
import os
import json
import logging

import util


class Loader():
    def __init__(self):
        self.config_path = "../config/config.json"

    def load(self):
        """
        Loads a config.json file and run a validation process.
        If the configurations seem valid, returns a list with
        Configuration objects.
        """
        util.set_working_directory()
        try:
            with open(self.config_path, mode="r") as file:
                config_string = file.read()
            decoder = json.JSONDecoder(object_pairs_hook=checking_hook)
            config_json = decoder.decode(config_string)
        except IOError:
            msg = "The file does not exist or cannot read:" + \
                  (os.path.split(self.config_path))[1]
            logging.error(msg)
            raise IOError(msg)
        except ValueError as value_error:
            msg = (os.path.split(self.config_path))[1] + " file is not valid"
            logging.error(msg)
            logging.error(value_error)
            raise IOError(msg)
        except KeyError as k_error:
            msg = "Duplicate key specified."
            logging.error(msg)
            logging.error(k_error)
            logging.error("Modify: " + (os.path.split(self.config_path))[1])
            raise IOError(msg)

        util.check_validation(config_json)

        config = Configuration()
        sizes = util.get_power_of_two(config_json["MinSize"],
                                      config_json["MaxSize"])
        config.tools = config_json["Tools"]
        config.queries = config_json["Queries"]
        config.change_sets = config_json["ChangeSets"]
        config.sizes = sizes
        config.iterations = config_json["IterationCount"]
        config.runs = config_json["Runs"]
        config.vmargs = config_json["JVM"]["vmargs"]

        return config


class Configuration:
    """Represents the configurations.
    """

    def __init__(self):
        self.change_sets = None
        self.tools = None
        self.sizes = None
        self.queries = None
        self.vmargs = None
        self.runs = None
        self.iterations = None


def checking_hook(pairs):
    result = dict()
    for key, value in pairs:
        if key in result:
            raise KeyError("Duplicate key specified: %s" % key)
        result[key] = value
    return result
