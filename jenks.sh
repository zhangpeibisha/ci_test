#!/usr/bin/env bash

sudo fuser -k -n tcp 9999
nohup java -jar jenkins.war --ajp13Port=-1 --httpPort=9999&


# 测试push事件121212
