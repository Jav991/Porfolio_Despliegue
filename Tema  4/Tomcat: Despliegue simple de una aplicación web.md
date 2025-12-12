![Portada](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/TomcatT%C3%ADtulo3.png)

## Introducción a la práctica: Despliegue simple en Tomcat

Esta práctica se centra en comprender y documentar el despliegue básico de una aplicación web Java en Tomcat sobre Ubuntu. El objetivo principal es ver cómo un archivo WAR pasa de ser un simple fichero en el sistema de archivos a convertirse en una aplicación accesible desde el navegador mediante un contexto como `/miapp`. 

A lo largo de la práctica se descargará o generará un WAR sencillo (por ejemplo, un Hello World en JSP), se copiará en la carpeta `webapps` del servidor Tomcat, se observará cómo el servidor detecta y despliega automáticamente la aplicación y, por último, se accederá a ella desde el navegador para obtener una captura de evidencia del despliegue correcto.

## Despliegue simple de una aplicación web en Tomcat

### Preparación del archivo WAR

Para realizar el despliegue se ha utilizado un archivo WAR de ejemplo llamado `hello.war`, que contiene una aplicación web Java muy sencilla (tipo *Hello World* en JSP). Este archivo se ha guardado inicialmente en el directorio personal del usuario (`/home/javier`).

### Copia del WAR a la carpeta `webapps`

Tomcat detecta y despliega automáticamente las aplicaciones que se colocan en su directorio de aplicaciones web. En la instalación de Tomcat 10 sobre Ubuntu utilizada en esta práctica, la ruta es:


