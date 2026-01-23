![Tomcat_portada](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/tomcat_herramientas/Tomcat_Portada.png)

## Introducción
Apache Tomcat dispone de diversas herramientas de administración que permiten gestionar de forma eficiente las aplicaciones y la configuración del servidor. Entre estas herramientas destacan Manager y Host Manager, las cuales proporcionan interfaces web para la administración de aplicaciones y hosts virtuales respectivamente.
En esta práctica se accederá a ambas interfaces de administración y analizaremos sus principales funcionalidades, como el despliegue, recarga y parada de aplicaciones web, así como la creación y gestión de hosts virtuales.
## 1. Acceso a las interfaces Manager y Host Manager

Para poder administrar Apache Tomcat mediante sus herramientas web, es necesario acceder a las interfaces **Manager** y **Host Manager**, las cuales permiten gestionar aplicaciones y hosts virtuales respectivamente.

### Acceso a Manager App

La interfaz **Manager App** permite realizar tareas como el despliegue, recarga, parada y eliminación de aplicaciones web.

Para acceder a ella, se utiliza la siguiente URL desde un navegador:
http://localhost:8080/manager/html
A continuación se muestra la ventana de autenticación para acceder a la interfaz Manager App mediante HTTPS.
![Acceso_Manager_1](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/tomcat_herramientas/Acceso_Maneger_1.png)

Tras la autenticación, accedemos correctamente a la interfaz del Tomcat Web Application Manager, desde la cual es posible gestionar las aplicaciones desplegadas en el servidor.
![Acceso_Manager_2](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/tomcat_herramientas/Interfaz_Manager_2.png)

## 2. Funciones principales de Manager y Host Manager

Las herramientas **Manager** y **Host Manager** de Apache Tomcat permiten administrar aplicaciones web y hosts virtuales de forma centralizada a través de una interfaz web segura.

### 2.1 Despliegue de aplicaciones

El **Manager** permite desplegar aplicaciones web de distintas formas:
- Subiendo archivos `.war` directamente desde la interfaz web.
- Desplegando aplicaciones ya existentes en el sistema de archivos del servidor.
- Indicando una URL desde la que Tomcat descargará el archivo `.war`.

Una vez desplegada, la aplicación queda accesible mediante su contexto correspondiente.

### 2.2 Recarga de aplicaciones

La función de **recarga (reload)** permite reiniciar una aplicación web sin necesidad de reiniciar todo el servidor Tomcat.  
Esto es útil tras realizar cambios en la configuración o en el código de la aplicación, minimizando el impacto en el resto de servicios.

### 2.3 Parada y arranque de aplicaciones

Desde el Manager es posible:
- **Detener (stop)** una aplicación web, dejándola temporalmente fuera de servicio.
- **Iniciar (start)** nuevamente la aplicación cuando sea necesario.

Estas acciones permiten realizar tareas de mantenimiento o resolución de problemas sin afectar al servidor completo.

### 2.4 Creación de hosts virtuales

El **Host Manager** permite la gestión de hosts virtuales en Tomcat, entre sus funciones se incluyen:
- Crear nuevos hosts virtuales asociados a distintos nombres de dominio.
- Definir directorios base independientes para cada host.
- Activar o desactivar hosts según las necesidades del servidor.

Gracias a los hosts virtuales, un único servidor Tomcat puede alojar múltiples sitios web de forma organizada y aislada.

## 3. Ficha descriptiva de las herramientas

### Tomcat Manager

**Descripción:**  
Tomcat Manager es una herramienta web que permite administrar las aplicaciones desplegadas en el servidor Tomcat. A través de esta interfaz se pueden realizar tareas básicas de gestión sin necesidad de acceder directamente al sistema de archivos del servidor.

**Funciones principales:**  
- Desplegar nuevas aplicaciones web (archivos `.war`).  
- Iniciar, detener y recargar aplicaciones en ejecución.  
- Eliminar aplicaciones desplegadas.  
- Visualizar información sobre el estado de las aplicaciones y las sesiones activas.

**Uso principal:**  
Se utiliza principalmente para la gestión y mantenimiento de aplicaciones web durante su desarrollo o administración, facilitando el control del ciclo de vida de las aplicaciones.

---

### Host Manager

**Descripción:**  
Host Manager es una herramienta de administración incluida en Tomcat que permite gestionar los hosts virtuales del servidor. Su función principal es facilitar la creación y administración de distintos dominios o sitios web dentro de un mismo servidor Tomcat.

**Funciones principales:**  
- Crear y eliminar hosts virtuales.  
- Iniciar y detener hosts configurados.  
- Gestionar la estructura de los distintos dominios alojados en el servidor.

**Uso principal:**  
Se emplea cuando es necesario alojar varias aplicaciones o dominios en un mismo servidor Tomcat, permitiendo una mejor organización y administración de los entornos.




