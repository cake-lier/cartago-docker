FROM eclipse-temurin:25-jre

ENV ENV_NAME=main
ENV ROOT_NAME=mas
ENV PORT=20100

RUN mkdir /opt/app
COPY build/libs/main.jar /opt/app/
EXPOSE $PORT
CMD java -jar /opt/app/main.jar --env-name=$ENV_NAME --root-name=$ROOT_NAME --port=$PORT
