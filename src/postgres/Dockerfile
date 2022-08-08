FROM gradle:jdk-alpine
WORKDIR /app
COPY . /app
RUN cd /app && gradle build -x test
CMD ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","/app/build/libs/postgres-0.0.1.jar"]
