# alpine is just a linux operative system.
FROM openjdk:17-alpine

#Create user  to run the app as (instead of root)
RUN addgroup -S app && adduser -S app -G app

#Use user "app", its best practise to not run the image as root user.
USER app

#Copy the jar file into the docker image
COPY target/*.jar app.jar

#RUN the Jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]