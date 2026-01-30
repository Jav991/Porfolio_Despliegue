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
