#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )/.."

rm -r diagrams/*
cd hu.bme.mit.trainbenchmark.ttc.reporting/
Rscript generate_diagrams.R
