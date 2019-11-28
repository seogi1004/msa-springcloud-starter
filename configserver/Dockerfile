FROM openjdk:8
VOLUME /tmp
ADD target/configserver-1.0.0.jar configserver.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "/configserver.jar"]