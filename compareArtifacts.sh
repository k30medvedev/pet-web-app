#!/bin/sh
MAVEN=target/java-web-app.jar
GRADLE=build/libs/java-web-app.jar

ls -l --block-size=M $MAVEN  | awk '{print $9, $5}'
ls -l --block-size=M $GRADLE  | awk '{print $9, $5}'