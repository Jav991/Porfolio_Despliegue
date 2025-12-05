![Portada](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/PortadaConfiuraci%C3%B3n.png)

# Tomcat — Componentes, Estructura y Funcionamiento Interno
**Autor:** Javier Gómez-Comino Comino  
## **Asignatura:** Despliegue de Aplicaciones Web  
## **Fecha:** 5 diciembre 2025  

---

<h1 style="font-size:32px; font-weight:bold; margin-bottom:0.3em;">Introducción a la instalación de Apache Tomcat en Ubuntu</h1> 
<p style="font-size:16px; margin:0;">La instalación de <b>Apache Tomcat</b> en Ubuntu es un proceso sencillo y bien estructurado, diseñado para integrar este servidor de aplicaciones Java dentro del sistema operativo de forma estable y segura.  
Para comenzar, es necesario preparar el entorno instalando un <b>JDK</b>, ya que Tomcat depende de la Java Virtual Machine para ejecutar servlets y páginas JSP.  
Una vez configurado Java, Tomcat puede instalarse directamente desde los <b>repositorios oficiales de Ubuntu</b>, lo que garantiza una versión compatible y una estructura de directorios estándar.  
La instalación mediante `apt` también añade un <b>servicio systemd</b>, permitiendo iniciar, detener y habilitar Tomcat para que arranque automáticamente junto al sistema.  
Tras completar el proceso, el servidor queda listo para desplegar aplicaciones web, administrar recursos y funcionar como un contenedor ligero y eficiente dentro del ecosistema Linux.</p>

## Instalación de Apache Tomcat en Ubuntu 24.10
Para automatizar la instalación de Apache Tomcat en Ubuntu 24.10, puede utilizarse el siguiente script Bash:

```bash
# Actualizar repositorios
sudo apt update

# Instalar Java (requerido por Tomcat)
sudo apt install -y default-jdk

# Instalar Tomcat 10 y herramientas administrativas
sudo apt install -y tomcat10 tomcat10-admin tomcat10-common

# Habilitar y arrancar el servicio
sudo systemctl enable tomcat10
sudo systemctl start tomcat10

# Mostrar estado del servicio
sudo systemctl status tomcat10

```
## Comprobar el estado del servicio Tomcat

Tras instalar Tomcat, es posible verificar que el servidor está activo utilizando el siguiente comando Bash:

```bash
sudo systemctl status tomcat10
```
![estado](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/estadoTomcat.png)
