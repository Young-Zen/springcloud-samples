FROM openjdk:8-jre

ARG JAR_FILE
COPY target/${JAR_FILE} /eureka-server.jar
COPY docker/start.sh /

ENTRYPOINT ["sh", "start.sh", "eureka-server.jar"]