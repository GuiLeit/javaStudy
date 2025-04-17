## Java Study Project

A simple Java project demonstrating object-oriented programming concepts with a clothing store example.

## Project Structure

- `src`: Source code files
- `lib`: Dependencies
- `bin`: Compiled output files
- `Dockerfile`: Docker container configuration
- `docker-compose.yml`: Docker Compose configuration

## Running with Docker

### Prerequisites
- Docker
- Docker Compose

### Build and Run
1. Build the Docker image:
```bash
docker-compose build
```

2. Run the application:
```bash
docker-compose up
```

3. Stop the application:
```bash
docker-compose down
```

### Development
- The source code is mounted as a volume, so changes will be reflected immediately
- Rebuild the application when changing source files:
```bash
docker-compose up --build
```

## Running Locally

### Prerequisites
- Java JDK 17 or higher
- VS Code with Java extensions

### Steps
1. Compile the project:
```bash
javac -d bin src/App.java src/Models/*.java
```

2. Run the application:
```bash
java -cp bin App
```
