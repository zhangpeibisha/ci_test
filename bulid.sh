#!/usr/bin/env bash

sudo fuser -k -n tcp 8081
docker stop ci_test_container
docker rm ci_test_container
docker rmi ceshi/ci_ceshi
mv ./target/learn.jar .
docker build -t ceshi/ci_ceshi .
docker run -d -p 8081:8081 --name ci_test_container ceshi/ci_ceshi /bin/sh  -c "java -jar /usr/local/web/learn.jar --server.port=8081"

