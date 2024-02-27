# bankTest

proyecto que contiene la logica para login y crud 

#Levantar proyecto

1. tener version de java 17 instalada
2. mvn spring-boot:run -Dspring-boot.run.profiles=dev

#Url swagger UI
http://localhost:8080/banktest/swagger-ui.html#/

------------------------------------------------------------------------------------------

#Pruebas Apis


#1. se debe consultar la api:

 - http://localhost:8080/banktest/api/v1/user?user=david
	para este caso la api ya esta con usuario a modo de prueba

 - lo que nos entregara la api como respuesta sera el usuario y el token generado por JWT para poder acceder a las demas api de la aplicacion
 	
 	Respuesta
 	
	{
	    "username": "david",
	    "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiZGF2aWQiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNzA5MDA1MzU1LCJleHAiOjE3MDkwMDU5NTV9.IYkGge35rgB2GFkbVZftSr2qREB1saV1mn4wgvDzsWUWgAyUOBB8FmyqRNijrr3np8hgwJO21fCxprukFIcH2Q"
	}
 	
#2. Accediendo a las APis del crud

 - luego con el token ya generado, podemos realizar las operaciones de la aplicación, siempre agregando como header el token en la variable "x-auth-token", ya que nos dara permisos de acceso a las demas funcionalidades.	

![Imagen de prueba](https://github.com/dadboy/bankTest/blob/master/src/main/resources/CreateAPi.png)



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





