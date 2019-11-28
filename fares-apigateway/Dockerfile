FROM openjdk:8
VOLUME /tmp
ADD target/fares-apigateway-1.0.0.jar fares-apigateway.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "/fares-apigateway.jar"]