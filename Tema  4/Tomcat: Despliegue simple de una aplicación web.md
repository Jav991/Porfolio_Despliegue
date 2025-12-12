![Portada](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/TomcatT%C3%ADtulo3.png)

## Introducción a la práctica: Despliegue simple en Tomcat

Esta práctica se centra en comprender y documentar el despliegue básico de una aplicación web Java en Tomcat sobre Ubuntu. El objetivo principal es ver cómo un archivo WAR pasa de ser un simple fichero en el sistema de archivos a convertirse en una aplicación accesible desde el navegador mediante un contexto como `/miapp`. 

A lo largo de la práctica se descargará o generará un WAR sencillo (por ejemplo, un Hello World en JSP), se copiará en la carpeta `webapps` del servidor Tomcat, se observará cómo el servidor detecta y despliega automáticamente la aplicación y, por último, se accederá a ella desde el navegador para obtener una captura de evidencia del despliegue correcto.

## Despliegue simple de una aplicación web en Tomcat

### Preparación del archivo WAR

Para realizar el despliegue se ha utilizado un archivo WAR de ejemplo llamado `hello.war`, que contiene una aplicación web Java muy sencilla (tipo *Hello World* en JSP). Este archivo se ha guardado inicialmente en el directorio personal del usuario (`/home/javier`).

### Copia del WAR a la carpeta `webapps`
Tomcat detecta y despliega automáticamente las aplicaciones que se colocan en su directorio de aplicaciones web. En la instalación de Tomcat 10 sobre Ubuntu utilizada en esta práctica, la ruta es:

### Comprobación del directorio `webapps`
Antes de copiar el archivo WAR, se ha comprobado el contenido del directorio de aplicaciones de Tomcat. En esta instalación de Tomcat 10 sobre Ubuntu, la ruta utilizada es `/var/lib/tomcat10/webapps`, por lo que en la terminal se ha ejecutado el siguiente comando:

```bash
  ls -l /var/lib/tomcat10/webapps
```
#### Salida esperada:
![Wepapps](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/tomcatWebapps.png)

### Copia y despliegue del archivo WAR en `webapps`

Una vez obtenido el archivo `hello.war` en el directorio personal del usuario (`/home/javier`), se procede a desplegarlo manualmente copiándolo a la carpeta de aplicaciones de Tomcat, situada en `/var/lib/tomcat10/webapps` en esta instalación de Ubuntu.

Para ello se utilizan los siguientes comandos:
```bash
  sudo cp ~/hello.war /var/lib/tomcat10/webapps/
```
Una vez echo nos movemos al directorio:
```bash
  cd  /var/lib/tomcat10/webapps/
```
y el resultado del comando será similar al siguiente:

![directorio](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/directorioWebapps.png)



  
