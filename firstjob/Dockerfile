# Use a base image that has Java installed
FROM openjdk:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the host to the container
COPY target/firstjob-0.0.1-SNAPSHOT.jar /app/firstjob.jar

# Specify the command to run the application
ENTRYPOINT ["java", "-jar", "firstjob.jar"]
