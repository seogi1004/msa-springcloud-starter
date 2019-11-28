FROM openjdk:8
VOLUME /tmp
ADD target/search-1.0.0.jar search.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/search.jar"]