FROM openjdk:8-jre

ARG JAR_FILE
COPY docker/start.sh /
COPY target/${JAR_FILE} /eureka-server.jar

ENTRYPOINT ["sh", "start.sh", "eureka-server.jar"]