FROM openjdk:13-alpine AS TEMP_BUILD_IMAGE
ENV APP_HOME=/app
WORKDIR $APP_HOME
COPY build.gradle settings.gradle gradlew $APP_HOME/
COPY gradle $APP_HOME/gradle
RUN ./gradlew --no-daemon dependencies
COPY . .
RUN ./gradlew --no-daemon build fatJar

FROM openjdk:13-alpine
ENV ARTIFACT_NAME=LogGenerator-full-1.0.jar
ENV APP_HOME=/app

WORKDIR $APP_HOME
COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/$ARTIFACT_NAME .

CMD java -jar $ARTIFACT_NAME ${PORT}
