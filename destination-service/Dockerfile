FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/destination-service-0.0.1-SNAPSHOT.jar destination-service-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "destination-service-0.0.1-SNAPSHOT.jar"]
