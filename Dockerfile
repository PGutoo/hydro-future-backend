# Use a imagem base do OpenJDK 11
FROM openjdk:11-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR da aplicação para o diretório /app no container
COPY target/my-application.jar app.jar

# Define o comando a ser executado quando o container for iniciado
CMD ["java", "-jar", "app.jar"]
