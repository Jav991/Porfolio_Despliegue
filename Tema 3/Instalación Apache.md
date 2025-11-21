# DESARROLLO DE APLICACIONES WEB
### Despliegue de Aplicaciones Web

![Portada](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/Apache.png)

---

### U.T. 2 **Práctica 1: Apache**

**Curso:** 2ºDAW  
**Autor:** Javier Gómez Comino  
**Fecha:** 21/11/2025  

---

## INDICE

1. Descargar Apache  
2. Creación de nuestro sitio web  
3. Configuración del archivo VirtualHost  
4. Activación del archivo VirtualHost  
5. Comprobación en el navegador  

---

## INTRODUCCIÓN

En esta práctica vamos a instalar y configurar el servidor Apache.

### ¿Qué es Apache?

El servidor web Apache, también conocido como Apache HTTP Server, es un software desarrollado por la Apache Software Foundation.  
Es de código abierto, lo que permite estudiar, modificar y mejorar su funcionamiento.

### ¿Para qué sirve Apache?

Apache se utiliza principalmente para alojar sitios web en internet. Sus funciones principales incluyen:

- Alojar sitios web  
- Gestión de conexiones  
- Soporte para módulos  
- Configuración flexible  

---

## DESARROLLO

### 1. Descargar Apache

Actualizamos los paquetes y luego instalamos Apache:

```bash
sudo apt update
sudo apt install apache2
```

### 2. Creación de nuestro sitio web

Creamos el directorio del sitio y el archivo HTML:
```bash
sudo mkdir /var/www/gci/
cd /var/www/gci/
nano index.html
```
Una vez dentro del editor nano, escribimos el siguiente contenido HTML
![Configuración Apache](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/ConfiguracionApache2.png)


### 3. Configuración del archivo VirtualHost

Apache permite gestionar múltiples sitios web en el mismo servidor mediante archivos llamados *VirtualHost*. Cada uno define cómo debe comportarse el servidor al recibir peticiones para un dominio específico.
Nos dirigimos a la carpeta de configuración de Apache para crear un nuevo archivo de configuración:

![Configuración Apache](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/Configuraci%C3%B3nApache1.png)

```bash
cd /etc/apache2/sites-available/
sudo cp 000-default.conf gci.conf
sudo nano gci.conf
```
![Configuración Apache](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/ConfiguracionApache2.png)

