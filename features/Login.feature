@tag
Feature: Login en la aplicaci�n

@tag1
Scenario: Ingreso con un usuario valido a la aplicacion
Given selecciono el navegador 
And accedo a la pantalla del login
When ingreso correo electronico as "" #Colocar el correo electronico valido
And ingreso contrasena as "" #Colocar contrase�a valida
Then login exitoso

@tag2
Scenario: Ingreso con un usuario no registrado en la aplicaci�n
Given selecciono el navegador 
And accedo a la pantalla del login
When ingreso correo electronico as "yess.09.10@ejemplo.com"
And ingreso contrasena as "12345678"
Then login fallido