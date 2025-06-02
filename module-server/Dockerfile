FROM openjdk:21-jdk-alpine
ARG JAR_FILE=build/libs/module-server-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/app.jar"]