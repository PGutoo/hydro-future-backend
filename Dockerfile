# Usar uma imagem base do Java
FROM openjdk:11

# Copiar o arquivo pom.xml para o diretório de trabalho
COPY pom.xml .

# Baixar as dependências do Maven
RUN mvn dependency:go-offline

# Copiar o código fonte para o diretório de trabalho
COPY src ./src

# Compilar e empacotar o projeto
RUN mvn package -DskipTests

# Copiar o arquivo JAR para a imagem
COPY target/hydrofuture.jar app.jar

# Definir o comando de execução
CMD ["java", "-jar", "app.jar"]
