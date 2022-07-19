
# Class Manager Api

This repo contains the Java Springboot Api for the React + Java 
instruction for careerdevs ch 15.

## Run Locally

to run locally 
1. download (or clone) the repo.
2. Install MySql
3. Open MySql and create the classroom database
4. create a user with full access to the database (see sql scripts for help)
5. update the application.properties file with the user and password you set 
6. load the project in intellij
7. go to: `src/main/java/ch15.classroom.demo/DemoApplication`
8. click on the green play button on line 9 (my need to let the app load a bit first).
9. confirm the application works by using postman to check the following GET routes:

* `http://localhost:8080/api/schools/`
* `http://localhost:8080/api/teachers`
* `http://localhost:8080/api/students/teacher/1`

### sql scripts
```
CREATE DATABASE classroom;
CREATE USER "classManager"@"%" identified by "schoolrules";
GRANT ALL ON classroom.* to "classManager"@"%";
```

## React requirements
1. install nodejs (nodejs.org) LTS
2. check that the follow commands do not give `command not found` errors
```shell
node --version
npm --version
npx --version
```
