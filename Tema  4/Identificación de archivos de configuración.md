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


## Identificación De Archivos Tomcat

- **`conf/server.xml`**  
  Archivo principal de configuración del servidor Tomcat; define conectores, puertos, motores, hosts y la arquitectura general de la instancia. [web:4][web:11][web:37]

- **`conf/web.xml`**  
  Descriptor de despliegue global por defecto que establece parámetros, servlets y mapeos que se aplican a todas las aplicaciones del servidor. [web:4][web:24][web:27]

- **`conf/tomcat-users.xml`**  
  Fichero donde se definen usuarios y roles usados por los *realms* de Tomcat para autenticación y autorización básicas. [web:11][web:28][web:30][web:36]

- **`conf/context.xml`**  
  Configuración de contexto global; define ajustes por defecto de los *Context* (aplicaciones web), como recursos JNDI y opciones de despliegue. [web:19][web:31][web:34]


# Archivos de configuración principales de Apache Tomcat

En Apache Tomcat existen varios archivos de configuración clave ubicados en el directorio de configuración (por ejemplo `/etc/tomcat10` cuando se instala como paquete en Ubuntu). Estos ficheros permiten definir cómo escucha el servidor, cómo se despliegan las aplicaciones, qué usuarios tienen acceso y qué parámetros se aplican a los distintos contextos web. [web:2][web:4][web:39]

  - **`server.xml`**  
    Define la arquitectura interna del servidor Tomcat y cómo escucha peticiones (puertos, conectores, servicios, `Engine`, `Host`, etc.). [web:4][web:11][web:51]  
    En él se configuran conectores HTTP/HTTPS, tiempo de espera, *thread pools*, *realms* de seguridad, clústeres y *valves* de registro o control de acceso. [web:4][web:11][web:51]

  - **`web.xml`**  
    Es el descriptor de despliegue global por defecto que se aplica a todas las aplicaciones a menos que éstas lo sobrescriban con su propio `WEB-INF/web.xml`. [web:2][web:9][web:29]  
    Permite configurar servlets y sus mapeos, filtros, *listeners*, páginas de error, parámetros de contexto y reglas de seguridad (roles, restricciones de URL). [web:29][web:53]

  - **`tomcat-users.xml`**  
    Define la base de usuarios y roles usada por Tomcat para autenticación sencilla


- **Para listar los directorios**:
    ```bash
      ls -l server.xml web.xml tomcat-users.xml context.xml
    ```
    ls -l server.xml web.xml tomcat-users.xml context.xml
![Directorios](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/ToncatDirectorios.png)


En Apache Tomcat existen varios archivos de configuración clave ubicados en el directorio de configuración (por ejemplo `/etc/tomcat10` cuando se instala como paquete en Ubuntu). Estos ficheros permiten definir cómo escucha el servidor, cómo se despliegan las aplicaciones, qué usuarios tienen acceso y qué parámetros se aplican a los distintos contextos web.

- **`server.xml`**  
  Define la arquitectura interna del servidor Tomcat y cómo escucha peticiones (puertos, conectores, servicios, `Engine`, `Host`, etc.).  
  En él se configuran conectores HTTP/HTTPS, tiempo de espera, *thread pools*, *realms* de seguridad, clústeres y *valves* de registro o control de acceso.

- **`web.xml`**  
  Es el descriptor de despliegue global por defecto que se aplica a todas las aplicaciones a menos que éstas lo sobrescriban con su propio `WEB-INF/web.xml`.  
  Permite configurar servlets y sus mapeos, filtros, *listeners*, páginas de error, parámetros de contexto y reglas de seguridad (roles, restricciones de URL).

- **`tomcat-users.xml`**  
  Define la base de usuarios y roles usada por Tomcat para autenticación sencilla, especialmente para las aplicaciones administrativas como Manager y Host Manager.  
  En este archivo se crean roles (por ejemplo `manager-gui`, `manager-script`) y se asignan a usuarios con usuario/contraseña para controlar quién accede a los recursos protegidos.

- **`context.xml`**  
  Es la configuración de contexto por defecto que se hereda en todas las aplicaciones desplegadas, salvo que éstas definan su propio `META-INF/context.xml`.  
  Aquí se pueden configurar recursos JNDI (datasources JDBC, colas JMS), opciones de recarga, gestión de sesiones, rutas a recursos estáticos y *valves* específicas por aplicación.

