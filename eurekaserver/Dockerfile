FROM openjdk:8
VOLUME /tmp
ADD target/eurekaserver-1.0.0.jar eurekaserver.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/eurekaserver.jar"]