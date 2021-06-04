FROM openjdk:8-alpine
EXPOSE 9090
COPY /target/app-service.jar app-service.jar
ENTRYPOINT ["java","-jar","/app-service.jar"]

