FROM openjdk:17
COPY ./target/core-service-0.0.1-SNAPSHOT.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "core-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8085