#Builder to the environment to Functional Programming Principles in Scala

FROM ubuntu:trusty
MAINTAINER Jose Carlos Baquero <jbaquerot@gmail.com>
RUN apt-get update

RUN apt-get install -y wget
RUN apt-get install -y git
RUN apt-get install -y openjdk-7-jdk


RUN wget -O /opt/sbt.tgz http://scalasbt.artifactoryonline.com/scalasbt/sbt-native-packages/org/scala-sbt/sbt/0.12.4/sbt.tgz
WORKDIR /opt
RUN tar xvf sbt.tgz
RUN bash -c 'echo "export PATH=/opt/sbt/bin:$PATH" >> ~/.bashrc'
#RUN bash -c 'export PATH = /opt/sbt/bin:$PATH'
RUN sbt -h