## Environment

openjdk version "11.0.2"
mysql 8


## Build 
mvn clean  install -Dmaven.test.skip=true

## Build image
docker build -t simple-docker .

## Run 
* `docker run -dp 8080:8080 simple-docker:latest`
## Stop image

docker stop `container id`