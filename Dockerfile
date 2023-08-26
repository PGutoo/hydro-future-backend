
# FROM directive specifies the base image for building the
# docker image, in this case, openjdk:20-jdk-slim
FROM openjdk:11-jdk-slim

# ARG directive defines a variable that users can pass at build-time
# to the builder with the docker build command using the --build-arg <varname>=<> flagvalue. 
# Here, it defines JAR_FILE as a variable and assigns the value target/*.jar to it.
ARG JAR_FILE=target/*.jar

# COPY directive copies files or directories from the source to the destination path in the Docker image.
# It copies the JAR_FILE from host machine to the destination path /app.jar in the Docker image.
COPY ${JAR_FILE} app.jar

# RUN directive executes a command inside the Docker image during the build process.
# Here, it creates an empty file named /app.jar using the bash command touch.
RUN bash -c "touch /app.jar"

# ENTRYPOINT directive allows you to configure a container that will run as an executable.
# It specifies the command that should be executed when the Docker container starts.
# In this case, it runs the java command with the specified arguments to start the application.
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
