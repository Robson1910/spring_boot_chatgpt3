#
# Build stage
#
FROM maven:3.8.7-eclipse-temurin-17-alpine AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:17-alpine
COPY --from=build /target/spring_boot_chatgpt3-0.0.1-SNAPSHOT.jar spring_boot_chatgpt3.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","/spring_boot_chatgpt3.jar"]