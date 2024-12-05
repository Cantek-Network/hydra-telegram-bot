# Use an official Maven image with JDK 17
FROM maven:3.6.3-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and the source code into the container
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package

# Use a minimal base image to run the Java application
FROM openjdk:17-alpine

# Set the working directory inside the container
WORKDIR /app

RUN apk add --no-cache bash

# Copy the packaged JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Command to run the Java application
ENTRYPOINT ["java", "-jar", "app.jar"]