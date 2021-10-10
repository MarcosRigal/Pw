 Esta es la práctica 1 de:
    -Antonio Moruno Gracia
    -David Pérez Dueñas
    -Marcos Rivera Gavilán

Para ejecutar los ficheros compilados basta con abrir una terminal
y ejecutar los siguientes comandos:

    -E1: java -jar E1.jar
    -E2: java -jar E2.jar

En ambos caso el programa empezará a ejecutarse. Intentará cargar la información
del sistema desde los ficheros users.txt spectacles.txt reviews.txt y sesions.txt
pero al ser la primera ejecución no los encontrará así que los generará en blanco
(si se usan los ficheros que se adjuntan se cargará dicha información).

La estructura de los ficheros es:

    -users.txt:
        identificador del siguiente usuario que se cree
        userId/nombre/rol/apellidos/nick/correo/contraseña
    
    -reviews.txt:
        identificador de la próxima review que se cree
        reviewId/userId/spectacleId/title/score/review/likes/dislikes/ids de los usuarios que han votado
    
    -sesions.txt:
        identificador de la siguiente sesión que se cree
        spectacleId/sesionId/placesleft/date

    -spectacles.txt:
        identificador del siguiente espectáculo que se cree
        spectacleId/title/type/description/places

Si seleccionamos la opción registrar, nos registrará automáticamente como espectadores.
Si queremos crear un administrador debemos hacerlo a traves de las opciones de gestión
de usuarios del administrador. Si no existe ningún administrador en el sistema este 
deberá crearse a mano en el fichero users.txt