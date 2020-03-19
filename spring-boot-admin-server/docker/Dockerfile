FROM openjdk:8-jdk-alpine

ARG JAR_FILE
COPY docker/start.sh /
COPY target/${JAR_FILE} /spring-boot-admin-server.jar

ENTRYPOINT ["sh", "start.sh", "spring-boot-admin-server.jar"]