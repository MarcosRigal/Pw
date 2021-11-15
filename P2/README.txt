Esta es la práctica 2 de:
    -Antonio Moruno Gracia
    -David Pérez Dueñas
    -Marcos Rivera Gavilán

IMPORTANTE: Para que la conexión a la base de datos pueda realizarse es 
            imprescindible que se encuentre dentro de la red de la 
            Universidad de Córdoba. Si no se encuentra físicamente
            aquí, Puede configurar una vpn:
            http://www.uco.es/servicios/informatica/conexion-externa-con-openvpn
            
Para acceder a la base de datos sin el programa conectesé aqui:

    http://oraclepr.uco.es/abd/phpMyAdmin/
    
    Usuario: i92rigam
    Password: PW2122WP

Para reestablecer la base de datos puede utilizar y cargar el script:

    bbdd.sql
    
Para ejecutar el fichero compilado del ejercicio 1 basta con abrir una terminal
en el mismo directorio y ejecutar los siguientes comandos:

    java -jar E1.jar
    
El programa empezará a ejecutarse. Intentará conectar con la base de datos, y cuando lo consiga,
comenzará la ejecución.

Si seleccionamos la opción registrar, nos registrará automáticamente como espectadores.
Si queremos crear un administrador debemos hacerlo a traves de las opciones de gestión
de usuarios del administrador.

El administrador por defecto es:

    Usuario: i92rigam@uco.es
    Password: 1234

Para ejecutar el ejercicio 2 debemos de descargar Apache Tomcat Standalone en el siguiente enlace:

    https://archive.apache.org/dist/tomcat/tomcat-8/v8.5.24/bin/apache-tomcat-8.5.24.tar.gz
    
Una vez descargado, lo descomprimimos y guardamos el archivo JSPMVC.war en la carpeta webapps.

Lo siguiente es que nos movamos a la carpeta bin y ejecutemos el script startup.sh.

Cuando se ejecute abrimos el navegador y visitamos el siguiente enlace: 

    http://localhost:8080/JSPMVC/index.jsp
    
Y ahí tendremos nuestra aplicación funcionando.

Para parar el servidor, devemos ejecutar el comando:

    pkill -9 -f tomcat
