FROM java:8
ARG JAR_FILE=target/java-web-app*.jar
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]