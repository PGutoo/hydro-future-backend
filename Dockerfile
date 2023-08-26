# Use a Java base image
FROM openjdk:11

# Copy the pom.xml file to the working directory
COPY pom.xml .

# Download Maven dependencies
# Error: The error message "image build failedundefined" suggests that the Maven command is not recognized.
# To fix this, we need to install Maven in the Docker image.
# Install Maven
RUN apt-get update && apt-get install -y maven

# Copy the source code to the working directory
COPY src ./src

# Compile and package the project
RUN mvn package -DskipTests

# Copy the JAR file to the image
COPY target/hydrofuture.jar app.jar

# Set the execution command
CMD ["java", "-jar", "app.jar"]
