FROM apache/apisix:3.1.0-debian@sha256:9485b3af3a4cba5ab71152444719fbc48efe85355eceabed8ae312b0596bd93f
USER root
RUN sed -i s/deb.debian.org/mirrors.aliyun.com/g /etc/apt/sources.list && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone
RUN apt-get update && \
apt-get -y install telnet && \
apt-get -y install curl && \
apt-get -y install net-tools && \
apt-get -y install inetutils-ping
RUN apt-get -y install openjdk-11-jre-headless

# docker build -t deploy.deepexi.com/dce-pub/apisix:3.1.0-arm64 .
# docker push deploy.deepexi.com/dce-pub/apisix:3.1.0-arm64 .
#RUN apt-get -y install openjdk-11-jre-headless
# RUN apt-get -y install default-jdk

# docker build -t deploy.deepexi.com/dce-pub/apisix:3.1.0-debian-openjdk-11-jdk-arm64 .
# docker push  deploy.deepexi.com/dce-pub/apisix:3.1.0-debian-openjdk-11-jdk-arm64

# docker buildx build . -t deploy.deepexi.com/dag-dev/apisix-dashboard:2.13.1-arm --platform  linux/arm64