FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/booksharingapp.jar /booksharingapp/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/booksharingapp/app.jar"]
