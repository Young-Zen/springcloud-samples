#!/bin/bash
cd ../..;
mvn clean package;
cd docker/manual;
jar -xf ../../target/spring-boot-admin-server.jar;