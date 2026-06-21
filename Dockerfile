FROM eclipse-temurin:21 as build
WORKDIR /app
copy . .
run ./gradlew build --no-daemon

FROM eclipse-temurin:21

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
