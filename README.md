# icbs-mobil-back-api-rest-login

proyecto que contiene la logica para login api rest


pasos para realizar pruebas


#1. se debe consultar la api http://localhost:8080/banktest/api/v1/user?user=david&password=asdasd

esta api genera el token de acceso para poder acceder a las siguientes apis de usuario

#2. Creacion de usuario POST http://localhost:8080/banktest/api/v1/users/

ejecucion por medio de CURL

curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' --header 'x-auth-token: Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiZGF2aWQiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNzA4OTc2MjYwLCJleHAiOjE3MDg5NzY4NjB9.2XxpR-j6ga_DZuzKAZ-uePoDtPcH7rqGRnva37Ee-0nAfvpowdTjkpH7X7HMze88jEC7ZiMUDT5b1jrbYL4JGw' -d '{ 
   "email": "pruebad%40asdasd.com",    "name": "string",    "password": "david123A",    "phones": [      {        "citycode": "string",        "contrycode": "string",        "number": "string"      }    ]  }' 'http://localhost:8080/banktest/api/v1/users/'
 
Respuesta

{
  "id": "3a02baa7-0aee-4161-b373-8f92816e89e4",
  "created": "2024-02-26T16:39:50.336178672",
  "modified": "2024-02-26T16:39:50.336197675",
  "laslogin": "2024-02-26T16:39:50.336205605",
  "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiZGF2aWQiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNzA4OTc2MjYwLCJleHAiOjE3MDg5NzY4NjB9.2XxpR-j6ga_DZuzKAZ-uePoDtPcH7rqGRnva37Ee-0nAfvpowdTjkpH7X7HMze88jEC7ZiMUDT5b1jrbYL4JGw",
  "isActive": "true"
}






#Url swagger UI
http://localhost:8080/banktest/swagger-ui.html#/

