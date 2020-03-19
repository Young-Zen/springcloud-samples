FROM openjdk:8-jdk-alpine

ARG JAR_FILE
COPY docker/start.sh /
COPY target/${JAR_FILE} /eureka-server.jar

ENTRYPOINT ["sh", "start.sh", "eureka-server.jar"]