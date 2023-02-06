FROM apache/apisix:3.1.0-debian
USER root
RUN apt-get update
RUN apt-get -y install telnet
RUN apt-get -y install curl
RUN apt-get -y install net-tools
RUN apt-get -y install inetutils-ping
RUN apt-get -y install openjdk-11-jre-headless

# docker build -t deploy.deepexi.com/dag-dev/apisix:3.1.0-debian-openjdk-11-jdk .
# docker push  deploy.deepexi.com/dag-dev/apisix:3.1.0-debian-openjdk-11-jdk
