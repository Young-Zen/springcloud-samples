FROM openjdk:8-jre

ARG JAR_FILE
COPY target/${JAR_FILE} /spring-boot-admin-server.jar
COPY docker/start.sh /

ENTRYPOINT ["sh", "start.sh", "spring-boot-admin-server.jar"]