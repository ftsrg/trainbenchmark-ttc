#!/bin/bash

cd "$( cd "$( dirname "$0" )" && pwd )"

# first build without tests, generate the models and build again with tests
./run.py --build --skip-tests && \
  ./run.py --generate && \
  ./run.py --build && \
  ./run.py --measure
