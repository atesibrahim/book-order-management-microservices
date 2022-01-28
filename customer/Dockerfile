FROM openjdk:8-jdk-alpine
COPY target/customer-service-0.0.1.jar customer-service-docker.jar
ENTRYPOINT ["java","-jar","/customer-service-docker.jar"]