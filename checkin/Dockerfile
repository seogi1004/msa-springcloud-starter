FROM openjdk:8
VOLUME /tmp
ADD target/checkin-1.0.0.jar checkin.jar
EXPOSE 8070
ENTRYPOINT ["java", "-jar", "/checkin.jar"]