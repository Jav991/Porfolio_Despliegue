# DESARROLLO DE APLICACIONES WEB
### Despliegue de Aplicaciones Web

![Portada](/attachments/H33Xf79RuMBx4p5huRNF8.png)
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
