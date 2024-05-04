# Use the official OpenJDK base image for JDK 17
FROM adoptopenjdk/openjdk17:alpine-jre

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/basket-0.0.1-SNAPSHOT.jar /app/basket-0.0.1-SNAPSHOT.jar

# Expose the port the application runs on
EXPOSE 8080

# Run the JAR file when the container starts
CMD ["java", "-jar", "basket-0.0.1-SNAPSHOT.jar"]