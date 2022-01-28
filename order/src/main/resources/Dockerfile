FROM openjdk:8-jdk-alpine
COPY target/docker-order-service-0.0.1-SNAPSHOT.jar orderservice.jar
ENTRYPOINT ["java","-jar","/orderservice.jar"]