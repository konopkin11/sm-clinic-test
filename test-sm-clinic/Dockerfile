#FROM gradle:7.2-jdk17 AS build
#ADD . .
#RUN ["./gradlew", "build", "-x", "test"]
FROM amazoncorretto:17-alpine
ADD . .
RUN ["./gradlew", "build", "-x", "test"]
EXPOSE 8080
#COPY --from=build build/libs/test-sm-clinic-0.0.1-SNAPSHOT.jar test-sm-clinic-0.0.1-SNAPSHOT.jar
#ADD build/libs/test-sm-clinic-0.0.1-SNAPSHOT.jar test-sm-clinic-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","build/libs/test-sm-clinic-0.0.1-SNAPSHOT.jar"]