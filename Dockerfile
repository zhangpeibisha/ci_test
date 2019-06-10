FROM hub.c.163.com/housan993/centos7_jdk8

MAINTAINER zhangpei

RUN mkdir -p /usr/local/web

COPY ./learn.jar  /usr/local/web/learn.jar



