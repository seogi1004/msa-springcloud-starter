FROM openjdk:8
VOLUME /tmp
ADD target/fares-1.0.0.jar fares.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/fares.jar"]