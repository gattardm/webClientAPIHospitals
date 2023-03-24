FROM openjdk:8
EXPOSE 8282
ADD target/webclienthospitals.jar webclienthospitals.jar
ENTRYPOINT ["java","-jar","/webclienthospitals.jar"]