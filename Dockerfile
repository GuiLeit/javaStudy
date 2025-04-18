FROM openjdk:17-jdk-slim

WORKDIR /app

# Create necessary directories
RUN mkdir -p src lib bin

COPY src ./src
COPY lib ./lib

RUN javac -d ./bin src/App.java src/Models/*.java src/Controllers/*.java

CMD ["java", "-cp", "bin", "App"]