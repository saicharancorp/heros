
## Run Spring Boot application
```
mvn spring-boot:run
```
https://github.com/rahul-ghadge/spring-boot-h2-crud

curl --location --request POST 'http://localhost:8080/heroes' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic dXNlcm5hbWU6cGFzc3dvcmQ=' \
--data-raw '   {
       "name": "Tony",
       "superName": "Iron Man",
       "profession": "Business",
       "age": 50,
       "canFly": true
   }'

Basic Auth : username , password

curl --location --request POST 'http://localhost:8080/employees' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic dXNlcm5hbWU6cGFzc3dvcmQ=' \
--data-raw '{
   "first_name":"first_name",
   "last_name":"last_name",
   "no_of_childrens":2,
   "spouse":true
}'

curl --location --request POST 'http://localhost:8080/student' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic dXNlcm5hbWU6cGFzc3dvcmQ=' \
--data-raw '{
    "id":11,
    "name":"student",
    "age":"28",
    "email":"test@gmail.com"
}'

https://github.com/bezkoder/spring-boot-h2-database-crud

curl --location --request POST 'http://localhost:8080/api/tutorials' 
--header 'Accept: application/json' 
--header 'Content-Type: application/json' 
--header 'Authorization: Basic dXNlcm5hbWU6cGFzc3dvcmQ=' 
--data-raw '{ "title": "test", "description": "test", "published": true }'


curl --location --request POST 'http://localhost:8080/addUser' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic dXNlcm5hbWU6cGFzc3dvcmQ=' \
--data-raw '{
    "name":"test",
    "address":"test",
    "marks":100
}'
