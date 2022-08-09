#FROM gradle:4.7.0-jdk8-alpine AS build




#COPY --chown=gradle:gradle src /home/gradle/src
#WORKDIR /home/gradle/src
#RUN gradle build --no-daemon

FROM openjdk:11-slim

MAINTAINER Nadir Jabbarli

WORKDIR /app

COPY  ./build/libs/student-service-0.0.1.jar /app/student-service.jar

ENTRYPOINT ["java", "-jar", "student-service.jar"]
