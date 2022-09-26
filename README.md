## Environment

* openjdk version "11.0.2"
* MySql 8
* Maven 3.5+




## Prepare Mysql
### Start Mysql 
start latest version of mysql , map container port `3306` into host port `3306` , use password as `password` for root user and name the docker container as  `simple-app-db`
we need to create network.Docker's built-in DNS does not apply on the default bridge network -- it has to be a custom/user-created network for Docker to provide DNS resolution of containers. 

create network
`docker network create mysql-net`

`docker run --name  simple-app-db --rm --network mysql-net -v mysql-data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=customer_data -p  3306:3306 -it mysql:latest`


### Connect to MySQL from the MySQL command line client


`docker run --network mysql-net -it --rm mysql mysql -hsimple-app-db -uroot -p`

### create DB

`create database customer_data;
 create user 'user'@'%' identified by 'password';
 grant all on *.* to 'user'@'%';`


### Create table

`CREATE TABLE customer (
  id int(11) NOT NULL AUTO_INCREMENT,
  firstName varchar(45) NOT NULL,
  lastName varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;`
## Build 
`mvn clean  install -Dmaven.test.skip=true -Pdocker`

## Build image
Build  the docker image and tag it as `simple-docker-app`

`docker build -t simple-docker-app .`

## How to Run 
Run the docker image , simple-docker-app


`docker run  -dp 8080:8080 --network mysql-net   simple-docker-app:latest`

attached and interactive mode

`docker run  -tip 8080:8080 --network mysql-net   simple-docker-app:latest`


## Stop image

docker stop `container id`


### How to run without creating Network

you can start application even without creating network. You have add a `--link` option with `docker run` command. This add a entry into the /etc/hosts with the `ip` and `name` of container it try to connect to. This is deprecated methor. So, it can be removed this support in the future


##### Start db

`docker run --name simple-app-db -e MYSQL_ROOT_PASSWORD=password -p  3306:3306 -d mysql:latest` 


##### Connecting DB

`docker run -it --link simple-app-db:simple-app-db --rm mysql mysql -hsimple-app-db -uroot -p` 


##### Preparing DB

`create user 'user'@'%' identified by 'password';`

`grant all on *.* to 'user'@'%';`


#### Run application

`docker build -t simple-docker-app .`

`docker run -tip 8080:8080 --link simple-app-db:simple-app-db simple-docker-app:latest`



##Application run with compose

Part of docker-compose’s default behavior these days is to automatically create a network for the containers to run on, and it gives each container a hostname identical to its container name


  By default Compose sets up a single network for your app. Each container for a service joins the default network and is both reachable by other containers on that network, and discoverable by them at a hostname identical to the container name.
    https://docs.docker.com/compose/networking/

* build the application with profile, `docker`

`mvn clean  install -Dmaven.test.skip=true -Pdocker`

* build the image

`docker build -t simple-docker-app .`

* run docker compose

`cd app`

`docker-compose up`

* verify end point `http://localhost:8080/customer/create` with   `POST' with body 

    
    Content-Type:application/json
    {"firstName": "sampath", "lastName": "Nawgala"}
    
  