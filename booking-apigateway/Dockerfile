FROM openjdk:8
VOLUME /tmp
ADD target/booking-apigateway-1.0.0.jar booking-apigateway.jar
EXPOSE 8065
ENTRYPOINT ["java", "-jar", "/booking-apigateway.jar"]