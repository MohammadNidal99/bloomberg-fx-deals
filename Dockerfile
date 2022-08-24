FROM openjdk:11-jdk

ARG JAR_FILE=target/bloomberg-fx-deals-1.0-SNAPSHOT-jar-with-dependencies.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
ENV spring.profiles.active "local"