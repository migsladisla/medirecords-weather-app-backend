# Getting Started with MediRecords Weather Spring Boot App

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/downloads/#java11)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.medirecords.weather.WeatherApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## 3rd party API integration

I used [WeatherAPI](https://www.weatherapi.com/api-explorer.aspx#forecast)'s free weather forecast API. I created REST endpoints in Spring that acts as the middleware to fetch data. I used [OkHttpClient](https://javadoc.io/static/com.squareup.okhttp3/okhttp/3.14.9/okhttp3/OkHttpClient.html) for sending HTTP requests.
