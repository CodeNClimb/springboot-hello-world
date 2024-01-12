FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

COPY src ./src
COPY pom.xml ./

CMD ["mvn", "clean", "compile"]
