FROM alpine AS build

RUN apk update
RUN apk add openjdk17 -y
COPY . .

RUN apk add maven -y
RUN mvn clean install

FROM openjdk:22-slim

EXPOSE 8080

COPY --from=build /target/ArbitrationCostComparator-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]