FROM openjdk:16-jdk-alpine
MAINTAINER Esraa Salem
COPY target/ecommerce-0.0.1-SNAPSHOT.jar ecommerce-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ecommerce-0.0.1-SNAPSHOT.jar"]