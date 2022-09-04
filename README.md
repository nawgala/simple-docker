## Environment

openjdk version "11.0.2"
mysql 8


## Build 
mvn clean  install -Dmaven.test.skip=true

## Build image
Build  the docker image and tag it as 'simple-docker-app'

`docker build -t simple-docker-app .`

## Run 
Run the docker image , simple-docker-app


`docker run -dp 8080:8080 simple-docker-app:latest`
## Stop image

docker stop `container id`


## Prepare Mysql
### Start Mysql 
start latest version of mysql , map container port 3306 into host port 3306 , use password as password for root user and name the docker container as  simple-app-d
we need to create network.Docker's built-in DNS does not apply on the default bridge network -- it has to be a custom/user-created network for Docker to provide DNS resolution of containers. 

`docker run --name simple-app-db --network mysql-net -e MYSQL_ROOT_PASSWORD=password -p  3306:3306 -d mysql:latest`


### Connect to MySQL from the MySQL command line client


`docker run --network mysql-net -it --rm mysql mysql -hsimple-app-db -uroot -p`

### create DB

`create database customer_data;`
`create user 'user'@'%' identified by 'password';`
`grant all on *.* to 'user'@'%';`