# Stage 1: Build
FROM openjdk:19-jdk AS build
WORKDIR /app

COPY pom.xml .
COPY src src
COPY mvnw .
COPY .mvn .mvn

RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

# Stage 2: Runtime
FROM openjdk:19-jdk
WORKDIR /app
VOLUME /tmp

# Copy built jar
COPY --from=build /app/target/MS-Usuarios-HW-0.0.1-SNAPSHOT.jar app.jar

# Copy wallet folder only
COPY src/main/resources/wallet /app/wallet

# Expose port and start application
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]


