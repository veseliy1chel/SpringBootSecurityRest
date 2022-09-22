
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
* This is simple spring-boot RESTfull app with authorization and registration, save session by jwt tokens.
* Testing via `postman`
* In first registartion use username `admin` for default creating `admin_role`(we have 2 methods for registration user,or admin)
* All table in db is empty,because we up db in docker,so table init when it start`s
* role admin can add only from method `registerAdmin()`,done so for safety reasons,but I can change DTO for add role from request
* App haven't gui,all tests in `postman`
* APP DOESN'T WORKING WITHOUT DOCKER (db in docker)
* Screenshots of testing in postman added to resources/Screen

## Technologies
Project is created with:
* Java: 11.0
* Spring-Boot version: 2.51
* auth0 version: 4.0.0
* image postgres for postgresql db: latest

## Setup
To run this project(WARNING db up in docker-compose,so without docker app doesn`t work.
For update jar file of app we have instruction)
 ### install it locally using cmd:
1. `docker build -t security-rest-docker.jar .`
2. `docker compose up`
3. If want to stop,using: `docker compose down`
 ### for update jar file of app:
1. cmd in folder SpringBootSecurityRest: `./mvnw clear install -DskipTests`
2. in folder target copy  `SpringSecurityApp-0.0.1-SNAPSHOT.jar` and paste with overwriting in root folder

