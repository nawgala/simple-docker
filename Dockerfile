# syntax=docker/dockerfile:1

FROM adoptopenjdk/openjdk11:alpine-slim
RUN addgroup -S spring && adduser -S spring -G spring


COPY target/simple-docker-0.0.1-SNAPSHOT-bin/simple-docker-0.0.1-SNAPSHOT /app
#RUN ls -l /app
#RUN chmod 500 /app/logs/*
RUN chown spring:spring -R /app
USER spring:spring
WORKDIR /app/bin

CMD ["sh", "simple-docker", "console"]

EXPOSE 8080

