#!/bin/bash

set -xeo pipefail

if [ -z $2 ]; then
    rm -rf BOOT-INF;
    rm -rf META-INF;
    rm -rf org;
    cd ../..;
    mvn clean package;
    cd docker/manual;
fi
projectName=order-server;
jar -xf ../../target/${projectName}.jar;
if [ $# -ge 1 ]; then
    docker build -t baiduyun.com/${projectName}:$1 .;
fi