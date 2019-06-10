#!/usr/bin/env bash

sudo fuser -k -n tcp 8082
sudo fuser -k -n tcp 8081
java -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8082 learn.jar --server.port=8081
