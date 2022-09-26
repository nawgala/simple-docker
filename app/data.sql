CREATE DATABASE IF NOT EXISTS `MYSQL_DATABASE`;
USE `MYSQL_DATABASE`;
create user IF NOT EXISTS 'user'@'%' identified by 'password';
grant all on *.* to 'user'@'%';