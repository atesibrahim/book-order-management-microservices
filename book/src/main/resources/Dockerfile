FROM openjdk:8-jdk-alpine
COPY target/docker-book-service-0.0.1-SNAPSHOT.jar bookservice.jar
ENTRYPOINT ["java","-jar","/bookservice.jar"]