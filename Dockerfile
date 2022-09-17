FROM maven:3.8-jdk-11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} studentapp-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/studentapp-0.0.1.jar"]