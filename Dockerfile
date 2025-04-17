FROM openjdk:17-jdk-slim

WORKDIR /app

COPY src ./src
COPY lib ./lib

RUN javac -d ./bin src/App.java src/Models/*.java

CMD ["java", "-cp", "bin", "App"]