FROM eclipse-temurin:17
ADD /build/libs/DataStorage-0.0.1-SNAPSHOT.jar backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]