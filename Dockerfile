FROM maven:3.9.6-amazoncorretto-21 as build

WORKDIR /app

COPY . /app

RUN mvn clean package -DskipTests

FROM amazoncorretto:21-alpine-jdk

WORKDIR /app

COPY --from=build /app/target/authorization-authentication-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/app.jar"]
