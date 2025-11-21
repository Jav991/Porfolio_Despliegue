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
Una vez instalado Apache, vamos a crear nuestro primer sitio web. Para ello, necesitamos crear un directorio donde alojaremos los archivos del sitio y un archivo HTML que será la página principal.
Abrimos la terminal y ejecutamos los siguientes comandos:
```bash
sudo mkdir /var/www/gci/
cd /var/www/gci/
nano index.html
```

![Configuración Apache](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/Configuraci%C3%B3nApache1.png)

Una vez dentro del editor nano, escribimos el siguiente contenido HTML
![Configuración Apache](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/ConfiguracionApache2.png)

Una vez creado y guardado el archivo `index.html`, ya tenemos nuestra página web lista en el directorio `/var/www/gci`.  
Sin embargo, Apache aún no sabe que debe servir ese contenido cuando alguien acceda a nuestro sitio.  
Para ello, necesitamos confi  gurar un archivo *VirtualHost* que le indique a Apache cómo responder a las peticiones dirigidas a nuestro dominio.

  ### 3. Configuración del archivo VirtualHost
  
  Apache permite gestionar múltiples sitios web en el mismo servidor mediante archivos llamados *VirtualHost*. Cada uno define cómo debe comportarse el servidor al recibir peticiones para un dominio específico.
  Nos dirigimos a la carpeta de configuración de Apache para crear un nuevo archivo de configuración:
  
  ```bash
  cd /etc/apache2/sites-available/
  sudo cp 000-default.conf gci.conf
  sudo nano gci.conf  
  ```
  ![Configuración Apache 1](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/ConfiguracionApache4.png)
  
---

### 4. Activación del archivo VirtualHost

Una vez que hemos creado y configurado el archivo `gci.conf`, necesitamos activarlo para que Apache lo reconozca como un sitio válido.
Primero, activamos el sitio con el siguiente comando:

```bash
sudo a2ensite gci.conf
```
y si todo ha salido bien debe aparecer:

![Activacion Web](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/ActivacionSitioWeb.png)

---

### 5. Comprobación en el navegador

Una vez activado el sitio y recargado Apache, es momento de comprobar que todo funciona correctamente.

Abrimos un navegador web y accedemos a la dirección que hemos configurado en el archivo `gci.conf`.  
En este caso, usamos el dominio `gci.example.com`. Si estás trabajando en local y no tienes configurado el dominio, puedes usar la IP del servidor o `localhost` si estás en la misma máquina.

Si todo está bien, deberías ver la página que creamos en el archivo `index.html`:

![Acctivaación Web](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/ActivacionSitioWeb2.png)

✅ ¡Listo! Tu servidor Apache está funcionando y sirviendo tu sitio web desde Ubuntu.

---




