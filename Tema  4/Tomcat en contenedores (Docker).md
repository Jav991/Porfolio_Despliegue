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
