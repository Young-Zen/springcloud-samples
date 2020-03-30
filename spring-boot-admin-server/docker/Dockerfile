FROM openjdk:8-jdk-alpine

RUN addgroup -g 1000 app \
    && adduser -H -u 1000 -G app -s /bin/sh -D app

USER app

COPY --chown=app:app docker/start.sh /
ARG JAR_FILE
COPY --chown=app:app target/${JAR_FILE} /spring-boot-admin-server.jar

ENTRYPOINT ["sh", "start.sh", "spring-boot-admin-server.jar"]