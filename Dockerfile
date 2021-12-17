# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
# copy WAR into image
COPY /target/spring-boot-backend-1.0-SNAPSHOT.jar /usr/app/
EXPOSE 8080
# run application with this command line
CMD ["/usr/bin/java", "-jar", "-Dserver.port=8080","-Dspring.profiles.active=default", "/usr/app/spring-boot-backend-1.0-SNAPSHOT.jar"]
