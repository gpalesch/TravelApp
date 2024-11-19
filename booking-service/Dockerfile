FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/booking-service-0.0.1-SNAPSHOT.jar booking-service-0.0.1-SNAPSHOT.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "booking-service-0.0.1-SNAPSHOT.jar"]
