FROM adoptopenjdk/openjdk11
ADD build/libs/kubik.jar /kubik.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/kubik.jar"]