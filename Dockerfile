FROM openjdk:jre-alpine
# if we want to install via apt
COPY build/libs/SubjectService-0.0.1-SNAPSHOT.jar /tmp
WORKDIR /tmp
CMD ["java", "-jar", "SentenceService-0.0.1-SNAPSHOT.jar"]