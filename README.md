# weatherapp
1. Build uber jar: mvn install

2. Build docker image : docker build -t weatherapp:v1 .

3. Run : docker run -p 8080:8080 weatherapp:v1

4. Visit application: http://localhost:8080
