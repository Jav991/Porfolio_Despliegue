![Portada_Tomcat_Contenedor](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/Tomacat_Contenedores/Tomcat_Contenedor.png)
## Introducción

En esta práctica trabajo con **Apache Tomcat** utilizando contenedores **Docker**, con el objetivo de desplegar y ejecutar una aplicación web de forma aislada, portable y reproducible. El uso de contenedores permite simplificar el proceso de despliegue y evitar problemas derivados de diferencias en la configuración del sistema operativo o del entorno de ejecución.

Para ello, utilizo una imagen oficial de Tomcat disponible en Docker Hub, que proporciona una instalación preconfigurada del servidor. A partir de esta imagen, se ejecuta un contenedor que permite acceder a la aplicación web a través del navegador, comprobando su correcto funcionamiento.

---

## 1. Descarga de la imagen oficial de Tomcat

En primer lugar, se descarga la imagen oficial de Apache Tomcat desde Docker Hub utilizando el siguiente comando:

```bash
docker pull tomcat:latest
```
![Tomcat_Contenedor_1](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/Tomacat_Contenedores/Tomcat_Contenedor_1.png)

El comando se ejecuta correctamente y Docker descarga la imagen oficial de Tomcat desde Docker Hub.  
En la salida se observa cómo se descargan las distintas capas de la imagen y, finalmente, el mensaje *“Status: Downloaded newer image for tomcat:latest”*, lo que confirma que la imagen se ha descargado y está disponible en el sistema para su uso.

## 2. Montaje de una aplicación en `/usr/local/tomcat/webapps`
En este apartado despliego una aplicación web sencilla en Tomcat utilizando Docker, montándola directamente en el directorio `webapps`, que es donde Tomcat carga automáticamente las aplicaciones.

### 2.1 Creación de la aplicación de prueba

Primero creo un directorio en el sistema anfitrión que contendrá la aplicación web:

```bash
  mkdir ~/tomcat-app
```
Dentro de este directorio creo un archivo index.jsp para comprobar que el despliegue funciona correctamente:

![Tomcat_Contenedor_2](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/Tomacat_Contenedores/Tomcat_Contenedor_2.png)

Este archivo sirve como aplicación de prueba para verificar que Tomcat carga correctamente el contenido montado desde el host.

### 2.2 Ejecución del contenedor Tomcat

Una vez creada la aplicación de prueba, ejecuto el contenedor de Tomcat montando el directorio local en `/usr/local/tomcat/webapps`. De este modo, Tomcat cargará automáticamente la aplicación al iniciarse.

Para ello utilizo el siguiente comando:

```bash
docker run -d \
  --name tomcat-app \
  -p 8080:8080 \
  -v ~/tomcat-app:/usr/local/tomcat/webapps/ROOT \
  tomcat:latest
```

![Tomcat_Contenedor_3](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/Tomacat_Contenedores/Tomcat_Contenedor_3.png)

