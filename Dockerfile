FROM java:8
ARG JAR_FILE=target/java-0.0.1-SNAPSHOT*.jar
RUN mkdir /configuration
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","/app.jar","--spring.config.additional-location=file:/configuration/"]