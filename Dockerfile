FROM eclipse-temurin:21.0.1_12-jre

RUN mkdir /opt/app
COPY build/libs/main.jar /opt/app/
CMD ["java", "-jar", "/opt/app/main.jar"]
