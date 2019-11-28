FROM openjdk:8
VOLUME /tmp
ADD target/checkin-apigateway-1.0.0.jar checkin-apigateway.jar
EXPOSE 8075
ENTRYPOINT ["java", "-jar", "/checkin-apigateway.jar"]