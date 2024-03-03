FROM eclipse-temurin:17
LABEL author=stalynAlvarado
COPY target/Pregunta3-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
