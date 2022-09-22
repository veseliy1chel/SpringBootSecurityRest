FROM openjdk:11
ADD SpringSecurityApp-0.0.1-SNAPSHOT.jar SpringSecurityApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","SpringSecurityApp-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080