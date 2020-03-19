#!/bin/bash
cd ../..;
mvn clean package;
cd docker/manual;
jar -xf ../../target/eureka-server.jar;