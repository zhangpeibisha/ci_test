FROM hub.c.163.com/housan993/centos7_jdk8

MAINTAINER zhangpei zhangpe0312@qq.com

RUN mkdir -p /usr/local/web

COPY ./target/learn.jar /usr/local/web/learn.jar
COPY ./start.sh /usr/local/web/start.sh

EXPOSE 8081

RUN cd /usr/local/web

CMD["bash","start.sh"]
