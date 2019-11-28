FROM openjdk:8
VOLUME /tmp
ADD target/booking-1.0.0.jar booking.jar
EXPOSE 8060
ENTRYPOINT ["java", "-jar", "/booking.jar"]