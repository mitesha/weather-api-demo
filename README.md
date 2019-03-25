# weather-api-demo
Weather Api demo app

Two APIs has been created
1. Current Weather Report
2. Forecast Weather Report

Unit Test cases using Junit, code coverage screenshot attached.

For code quality sonarqube used, screenshot attached for same as well.

Swagger added for dynamic documentation. http://localhost:8081/swagger-ui.html

For Code quality
  run: 
  mvn sonar:sonar -Dsonar.host.url=http://localhost:9000
  
  
For Code coverage
  run: 
  'mvn clean test'   
  'mvn jacoco:report'
       
       
       
Note: Sonar qube will also have code coverage
       
