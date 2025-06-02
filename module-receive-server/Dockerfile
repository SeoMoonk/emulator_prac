FROM openjdk:21-jdk-alpine
ARG JAR_FILE=build/libs/module-receive-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/app.jar"]