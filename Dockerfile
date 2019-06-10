FROM hub.c.163.com/housan993/centos7_jdk8

MAINTAINER zhangpei zhangpe0312@qq.com

RUN mkdir -p /usr/local/web

COPY ./target/learn.jar /usr/local/web/learn.jar
COPY ./bulid.sh /usr/local/web/bulid.sh

EXPOSE 8081

RUN cd /usr/local/web

CMD["bash","bulid.sh"]
