FROM java:8
ARG JAR_FILE=target/java-web-app*.jar
RUN mkdir /configuration
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","/app.jar","--spring.config.additional-location=file:/configuration/"]