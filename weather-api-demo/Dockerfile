From Java:8
EXPOSE 8099
ADD target/weather-api-demo.jar weather-api-demo.jar
ENTRYPOINT ["java", "-jar", "-Xmx512M", "weather-api-demo.jar", "--server.port=8099"]
