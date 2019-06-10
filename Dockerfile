FROM hub.c.163.com/housan993/centos7_jdk8

MAINTAINER zhangpei

RUN mkdir -p /usr/local/web

COPY ./learn.jar  /usr/local/web/learn.jar
COPY ./bulid.sh  /usr/local/web/bulid.sh
COPY ./start.sh  /usr/local/web/start.sh

RUN chmod 777  /usr/local/web/start.sh

CMD bash /usr/local/web/start.sh


