FROM maven:3.6.3-jdk-14 as builder
COPY pom.xml /app/
COPY src/ /app/src/
RUN ["mvn","-f=/app/pom.xml","clean","install"]

FROM openjdk:14-jdk as dev
EXPOSE 8080
EXPOSE 8000
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000
COPY --from=builder ./app/target/restapi-0.0.1-SNAPSHOT.jar restapi.jar
ENTRYPOINT ["java", "-jar", "restapi.jar"]

FROM openjdk:14-jdk as prod
EXPOSE 8080
COPY --from=builder ./app/target/restapi-0.0.1-SNAPSHOT.jar restapi.jar
ENTRYPOINT ["java", "-jar", "restapi.jar"]
