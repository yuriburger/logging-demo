FROM openjdk:8-jre-alpine
VOLUME /tmp
COPY /target/logging-demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
