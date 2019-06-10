#!/usr/bin/env bash

sudo fuser -k -n tcp 8081
mv ./target/learn.jar .
docker build -t ceshi/ci_ceshi .
docker run -d -p 8081:8081 ceshi/ci_ceshi
