# syntax=docker/dockerfile:1

FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring
COPY ./target/simple-docker-0.0.1-SNAPSHOT.jar simple-docker-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/simple-docker-0.0.1-SNAPSHOT.jar"]



