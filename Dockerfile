FROM maven:3.8.3-openjdk-17 as builder
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package
FROM openjdk:17.0-jdk-slim
COPY --from=builder /usr/src/app/target/Metric-to-IEC-converter-0.0.1-SNAPSHOT.jar /usr/app/Metric-to-IEC-converter-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/usr/app/Metric-to-IEC-converter-0.0.1-SNAPSHOT.jar"]