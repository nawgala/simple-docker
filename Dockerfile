# syntax=docker/dockerfile:1

FROM adoptopenjdk/openjdk11:alpine-slim
#RUN addgroup -S sampath && adduser -S sampath -G sampath


COPY target/simple-docker-0.0.1-SNAPSHOT-bin/simple-docker-0.0.1-SNAPSHOT /app
#RUN ls -l /app
#RUN chmod 500 /app/logs/*
#RUN chown sampath:sampath -R /app
#RUN ls -l /app
#USER sampath:sampath
WORKDIR /app/bin
CMD ["sh", "simple-docker", "console"]

EXPOSE 8080

