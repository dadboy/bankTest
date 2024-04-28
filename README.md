# bankTest

proyecto que contiene la logica para login y crud 

#Levantar proyecto

1. tener version de java 17 instalada
2. mvn spring-boot:run -Dspring-boot.run.profiles=dev

#Url swagger UI
http://localhost:8080/banktest/swagger-ui.html#/

------------------------------------------------------------------------------------------

#Pruebas Apis


#1. se debe consultar la api "api/v1/login":

 - http://localhost:8080/banktest/api/v1/user?user=david
	para este caso la api ya esta con usuario a modo de prueba

 - lo que nos entregara la api como respuesta, sera el usuario y el token generado por JWT para poder acceder a las demas api de la aplicacion
 	
 	Response
 	
	{
	    "username": "david",
	    "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiZGF2aWQiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNzA5MDA1MzU1LCJleHAiOjE3MDkwMDU5NTV9.IYkGge35rgB2GFkbVZftSr2qREB1saV1mn4wgvDzsWUWgAyUOBB8FmyqRNijrr3np8hgwJO21fCxprukFIcH2Q"
	}
 	
#2. Accediendo a las APis del crud

 - luego con el token ya generado, podemos realizar las operaciones de la aplicación, siempre agregando como header el token en la variable "x-auth-token", ya que nos dara permisos de acceso a las demas funcionalidades.	

Ejemplo

![Imagen de prueba](https://github.com/dadboy/bankTest/blob/main/src/main/resources/CreateAPi.png)



#3. Las demas apis se prueban de la misma manera, con el token generado por JWT, tendremos acceso y revisando la documentacion swagger para realizar las pruebas











