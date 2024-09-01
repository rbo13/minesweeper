# Minesweeper

This implementation is built with Java and packaged using Maven.

- **Java**: OpenJDK 22.0.1
- **Maven**: Version 3.9.9
- **JUnit/Mockito**: Version 5
- **Docker**: For containerization (optional)

## Prerequisites

Ensure the following tools are installed on your system:

- **Git**: For cloning the repository.
- **Java/OpenJDK**: This project uses OpenJDK Runtime Environment Temurin-22.0.1+8 (build 22.0.1+8).
- **Maven**: For building and managing dependencies.

## Optional Requirements

- **Docker**: To run the application in a containerized environment.


## Project Setup
This project was generated using Maven with the following command:
```shell
mvn archetype:generate -DgroupId=rbo13.github.minesweeper -DartifactId=minesweeper -DarchetypeArtifactId=maven-archetype-simple -DarchetypeVersion=1.5 -DinteractiveMode=false
```

## Getting Started
### Clone the Repository
To get started, clone the repository and navigate to the project directory:
```shell
git clone https://github.com/rbo13/minesweeper.git
cd minesweeper
```

### Running Tests
To run tests, use Maven:
```shell
mvn clean test
```

If Maven is not installed, use the provided Maven wrapper:
```shell
./mvnw clean test

# if an error occurred that says permission denied: ./mvnw
chmod +x ./mvnw
```
or, if on Windows:
```shell
.\mvnw.cmd clean test
```

### Building and Running the Application
The application is packaged as a JAR file. Below are instructions for running it on different operating systems.

#### Windows
1. Build the application:
```shell
mvn clean install
```
2. Run the JAR file:
```shell
java -jar .\target\minesweeper-1.0.jar
```

#### MacOS or Linux (via WSL2):
1. Build the application:
```shell
mvn clean install
```
2. Run the JAR file:
```shell
java -jar target/minesweeper-1.0.jar
```

# Using Docker:

### Building the app
```docker
docker build -t minesweeper .
```

### Running the app
```docker
docker run -it minesweeper:latest
```

## Design Decisions

For more information about the design decisions of this project, please refer to the [design.md](docs/design.md) document.
