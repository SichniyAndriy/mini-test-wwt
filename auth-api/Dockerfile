FROM gradle:jdk21-graal-jammy AS build
LABEL "authors"="Sichniy Andriy"
WORKDIR /app
COPY build.gradle ./
COPY src ./src
RUN gradle clean build -x test

FROM eclipse-temurin:21-jre-alpine
WORKDIR ./app
COPY --from=build /app/build/libs/*.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "auth-api.jar"]
