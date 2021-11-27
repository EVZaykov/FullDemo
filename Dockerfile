FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

# Workspace
WORKDIR .

# ADD .jar under target from host
# into this image
ADD target/selenium-docker.jar			selenium-docker.jar
ADD target/selenium-docker-tests.jar	selenium-docker-tests.jar
ADD target/libs							libs
ADD target/test-classes					test-classes

# ADD suite fiels
#ADD testngFirst.xml							testngFirst.xml
#ADD testngSecond.xml						testngSecond.xml

ADD healthcheck.sh                      healthcheck.sh
# BROWSER
# HUB_HOST
# MODULE

ENTRYPOINT sh healthcheck.sh
#java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE