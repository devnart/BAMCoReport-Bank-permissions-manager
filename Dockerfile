FROM openjdk:11
EXPOSE 8080
ADD target/bamco.jar bamco.jar
ENTRYPOINT ["java","-jar","/bamco.jar"]