FROM openjdk:17-jdk-slim
EXPOSE 8761:8761
ADD /target/eurekademo-0.0.1-SNAPSHOT.jar eurekademo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","eurekademo-0.0.1-SNAPSHOT.jar"]
