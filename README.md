# The TTC 2015 Train Benchmark Case

[![Build Status](https://travis-ci.org/FTSRG/trainbenchmark-ttc.svg?branch=master)](https://travis-ci.org/FTSRG/trainbenchmark-ttc)

**Note.** Although closely related, this repository is not to be confused with the `trainbenchmark` repository which is a benchmark framework for comparing various database management tools, including triplestores, relational databases and graph databases.

[Case description](https://www.sharelatex.com/github/repos/FTSRG/trainbenchmark-ttc-paper/builds/latest/output.pdf) (preliminary version)

## Prerequisites

* 64-bit operating system (Ubuntu-based Linux systems are recommended)
* [Oracle JDK 7+](https://github.com/FTSRG/cheat-sheets/wiki/Linux#oracle-jdk-7)
* [Maven 3.0+](https://github.com/FTSRG/cheat-sheets/wiki/Linux#maven-3)

## Platform dependencies

1. Install Maven 3 and make sure it is on your path (`mvn --version`).
1. Make sure you have Python 3 installed.

## Using the framework

The `scripts` directory contains the `run.py` script which is used for the following purposes:
* `run.py -b` -- builds the projects
* `run.py -b -s` -- builds the projects without testing
* `run.py -g` -- generates the instance models
* `run.py -m` -- runs the benchmark
* `run.py -v` -- visualizes the results of the latest benchmark

The `config` directory contains the configuration for the scripts:
* `config.json` -- configuration for the model generation and the benchmark
* `reporting.json` -- configuration for the visualization

### Generating instance models

Set the `maxSize` variable to the desired value and run the `generate.sh` script. With enough memory (`-Xmx2G` or more), the models from size `1` to size `512` are generated in about 5 minutes.

### Running the benchmark

The script runs the benchmark for the given number of runs, for the specified tools, queries and sizes.

The benchmark results are stored in a TSV (tab-separated values) file. The header for the TSV file is stored in the `output/header.tsv` file. 

## Reporting and Visualization

Make sure you read the `README.md` file in the `reporting` directory and install all the requirements for R.

## Importing to Eclipse

It is recommended to start with an Eclipse distribution tailored to developing EMF-based applications, e.g. Eclipse Modeling.

If you'd like to try the EMF-IncQuery implementation, it is recommended to use Eclipse Luna. There are two ways to resolve the dependencies:

1. **Maven dependencies** (`pom.xml` files). This requires the m2e Eclipse plugin (this is included in Eclipse for Java developers but is not included in Modeling distribution). The m2e plugin can be installed from the the update site of your release (Kepler/Luna).
2. **Plug-in dependencies** (`MANIFEST.MF` files).
  * Use the Orbit update site for your release (<http://download.eclipse.org/tools/orbit/downloads/>) to install the **Apache Commons CLI 1.2.0** plug-in.
  * If you wish to run the EMF-IncQuery implementation, install EMF-IncQuery from <http://download.eclipse.org/incquery/updates/release>.

In general, we recommend to stick to your proven build solution, else you may spend a lot of time tinkering with the build. In theory, you can build Eclipse plug-ins with the Tycho Maven plug-in, however, it has a steep learning curve and is tricky to debug. For reference, see <https://github.com/FTSRG/cheat-sheets/wiki/Maven-and-Eclipse>.

## Implementing the benchmark for a new tool

To implement a tool, it is recommended to start from an existing implementation. Please implement your own  [benchmark logic](https://github.com/FTSRG/trainbenchmark-ttc/blob/master/hu.bme.mit.trainbenchmark.ttc.benchmark.java/src/main/java/hu/bme/mit/trainbenchmark/ttc/benchmark/java/JavaBenchmarkLogic.java) and [benchmark case factory](https://github.com/FTSRG/trainbenchmark-ttc/blob/master/hu.bme.mit.trainbenchmark.ttc.benchmark.java/src/main/java/hu/bme/mit/trainbenchmark/ttc/benchmark/java/benchmarkcases/JavaBenchmarkCaseFactory.java) which instantiates the classes for each query defined in the benchmark.
