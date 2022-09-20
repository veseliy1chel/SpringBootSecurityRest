
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
This is simple spring-boot RESTfull app with authorization and save session by jwt tokens.
Testing via postman


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
1. Go to folder Docker: cd \src\main\Docker
2. docker build -t security-rest-docker.jar .
3. docker compose up
4. If want to stop,using: docker compose down
 ### for update jar file of app:
1. cmd in folder SpringBootSecurityRest: ./mvnw clear install -DskipTests
2. in folder target copy  SpringSecurityApp-0.0.1-SNAPSHOT.jar and paste with overwriting in Docker folder

