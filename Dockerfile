FROM maven:3.9.9-amazoncorretto-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install

FROM openjdk:17-jdk-slim
WORKDIR /minesweeper
COPY --from=build /app/target/minesweeper-1.0.jar minesweeper.jar
CMD ["java", "-jar", "minesweeper.jar"]