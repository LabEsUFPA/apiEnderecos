FROM eclipse-temurin:19.0.2_7-jre-jammy
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=prod","/app.jar"]