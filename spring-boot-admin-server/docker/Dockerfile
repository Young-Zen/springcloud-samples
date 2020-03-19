FROM openjdk:8-jre

ARG JAR_FILE
COPY docker/start.sh /
COPY target/${JAR_FILE} /spring-boot-admin-server.jar

ENTRYPOINT ["sh", "start.sh", "spring-boot-admin-server.jar"]