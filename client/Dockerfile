FROM openjdk:8
VOLUME /tmp
ADD target/client-1.0.0.jar checkin.jar
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "/client.jar"]