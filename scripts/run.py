#!/usr/bin/env python3
"""
@author: Zsolt Kovari

"""
import argparse
import logging
import subprocess
import sys
import os
import shutil

import util
import logger
from loader import Loader


def build(skip_tests):
    """Builds the project.
    """
    util.set_working_directory("../")
    if skip_tests:
        subprocess.call("mvn clean install -DskipTests", shell=True)
    else:
        subprocess.call("mvn clean install", shell=True)
    util.set_working_directory()


def generate(conf):
    """Generates the models.
    """
    target = util.get_generator_jar()
    for size in conf.sizes:
        subprocess.call(["java", conf.vmargs, "-jar", target,
                         "-size", str(size)])


def benchmark(conf):
    """Runs measurements.
    """
    header = "../results/header.tsv"
    result_file = "../results/results.tsv"
    if os.path.exists(result_file):
        os.remove(result_file)
    shutil.copy(header, result_file)
    for change_set in conf.change_sets:
        for run_index in range(1, conf.runs+1):
            for tool in conf.tools:
                for size in conf.sizes:
                    for query in conf.queries:
                        target = util.get_tool_jar(tool)
                        print("Benchmark: ", tool, " ", change_set, " ",
                              query, " Size:", size, " Run:", run_index)
                        output = subprocess.check_output(
                            ["java", conf.vmargs,
                             "-jar", target,
                             "-runIndex", str(run_index),
                             "-size", str(size),
                             "-query", query,
                             "-changeSet", change_set,
                             "-iterationCount", str(conf.iterations)])
                        with open(result_file, "ab") as file:
                            file.write(output)
    pass


if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument("-b", "--build",
                        help="build the project",
                        action="store_true")
    parser.add_argument("-g", "--generate",
                        help="generate models",
                        action="store_true")
    parser.add_argument("-m", "--measure",
                        help="run the benchmark",
                        action="store_true")
    parser.add_argument("-s", "--skip-tests",
                        help="skip JUNIT tests",
                        action="store_true")
    parser.add_argument("-v", "--visualize",
                        help="create visualizations",
                        action="store_true")
    parser.add_argument("-r", "--results",
                        help="extract results",
                        action="store_true")
    args = parser.parse_args()


    util.set_working_directory()
    logger.init()
    loader = Loader()
    config = loader.load()

    if args.build:
        build(args.skip_tests)
    if args.generate:
        generate(config)
    if args.measure:
        benchmark(config)
    if args.visualize:
        util.set_working_directory("../hu.bme.mit.trainbenchmark.ttc.reporting")
        subprocess.call(["Rscript", "generate_diagrams.R"])
    if args.results:
        util.set_working_directory("../hu.bme.mit.trainbenchmark.ttc.reporting")
        subprocess.call(["Rscript", "report_references.R"])

    # if there are no args, we execute a test sequence
    no_args = all(val==False for val in vars(args).values())
    if no_args:
        build(True)
        generate(config)
        build(False)
        benchmark(config)
        util.set_working_directory("../hu.bme.mit.trainbenchmark.ttc.reporting")
        subprocess.call(["Rscript", "report_references.R"])
