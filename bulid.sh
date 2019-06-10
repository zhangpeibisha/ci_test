#!/usr/bin/env bash

sudo fuser -k -n tcp 8081
docker stop ceshi/ci_ceshi
mv ./target/learn.jar .
docker build -t ceshi/ci_ceshi .
docker run -d -p 8081:8081 ceshi/ci_ceshi /bin/sh  -c "java -jar /usr/local/web/learn.jar --server.port=8081"

