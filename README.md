# 📏 Micrometer Try-Out 📐

## About
Consists of a sample project using a Spring Webflux service that exposes data with Micrometer and Spring Actuator. It also contains a **docker-compose** 🐋 file that deploys two other containers - a Prometheus server and a Grafana server -, so we can collect the service data and use it to generate dashboards and graphs.

## Deploying and testing the application
1. Build the application image using the Gradle wrapper:
```sh
./gradlew docker --no-daemon
```
2. Use docker-compose 🐋 to run the application and the Grafana and Prometheus servers:
```sh
docker-compose up
```
3. Access `http://localhost:3000` in your browser and log in to the Grafana console
4. Create a new Prometheus datasource using the following URL: `http://prometheus:9090`
5. Create a new dashboard and new panels using the Prometheus datasource to visualize the data exposed by the Spring Webflux application