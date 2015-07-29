#!/bin/bash

pushd ..

git clone https://github.com/tsdh/ttc15-train-benchmark-funnyqt.git
cd ttc15-train-benchmark-funnyqt

git pull
# download lein and build the project
wget https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein
chmod +x lein
./lein install

popd
