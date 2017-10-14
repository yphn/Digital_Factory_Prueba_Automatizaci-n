@tag
Feature: Ver detalles del perfil


Background: El usuario esta logueado
Given selecciono el navegador 
And accedo a la pantalla del login
When ingreso correo electronico as "" #Colocar el correo electronico valido
And ingreso contrasena as "" #Colocar contraseña valida
Then login exitoso

@tag1
Scenario: Hago la busqueda de un contacto y veo su perfil
Given ingreso un contacto as "" #Colocar nombre del contacto a buscar
When selecciono el contacto
Then puedo ver el perfil del contacto
