![Portada](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/Toncat_Portada.png)

# Tomcat — Componentes, Estructura y Funcionamiento Interno
**Autor:** Javier Gómez-Comino Comino  
**Asignatura:** Despliegue de Aplicaciones Web  
**Fecha:** 5 diciembre 2025  

---

# 1. Catalina
Catalina es el contenedor de servlets de Apache Tomcat y constituye el núcleo del servidor. Gestiona la ejecución de servlets, la lógica interna de las aplicaciones web, la seguridad, sesiones, contextos y el ciclo de vida de cada aplicación. Recibe las peticiones procesadas por Coyote y las ejecuta según la configuración del contenedor. Sus librerías se encuentran en `lib/`, y su configuración principal está en `conf/server.xml`, además de `web.xml` y `context.xml` en cada aplicación.

![Diagrama de Catalina](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/toncatCatalina.png)

---

# 2. Coyote
Coyote es el conector HTTP/AJP de Tomcat y actúa como punto de entrada del servidor. Escucha peticiones en los puertos configurados (por defecto 8080), acepta conexiones TCP y traduce las solicitudes en estructuras internas que Catalina pueda procesar. Sin este componente, Tomcat no podría comunicarse con el exterior. Sus librerías residen en `lib/` y su configuración se define dentro de `conf/server.xml` mediante `<Connector>`.

![Diagrama de Coyote](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/toncatCatalina.png)

---

# 3. Jasper
Jasper es el motor JSP de Tomcat. Convierte las páginas `.jsp` en servlets Java que Catalina puede ejecutar y recompila automáticamente los JSP cuando detecta cambios. Las clases de Jasper se ubican en `lib/`, y su trabajo genera archivos temporales dentro de `work/` y `temp/`. Permite integrar la ejecución dinámica de contenido mediante Java en las aplicaciones desplegadas.

![Diagrama de Jasper](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/toncatJasper.png)
---

# 4. Manager y Host Manager
Los componentes **Manager** y **Host Manager** son aplicaciones administrativas ubicadas en `webapps/manager` y `webapps/host-manager`.  
- **Manager** permite administrar aplicaciones web: desplegar directamente WAR, detener, iniciar o recargar aplicaciones, y consultar el estado del servidor.  
- **Host Manager** permite gestionar hosts virtuales sin reiniciar Tomcat.  
Para acceder a ambas herramientas, es necesario definir usuarios y roles autorizados en `conf/tomcat-users.xml`.

---

# 5. Estructura básica de directorios de Tomcat


**Descripción rápida:**
- **bin/** → scripts de arranque y apagado.  
- **conf/** → configuración principal del servidor.  
- **lib/** → JAR internos de Tomcat (Catalina, Coyote, Jasper).  
- **logs/** → registros del servidor.  
- **webapps/** → aplicaciones desplegadas.  
- **temp/** → datos temporales.  

---

# 6. Fuentes utilizadas

- Documentación oficial de Apache Tomcat  
  https://tomcat.apache.org/tomcat-10.1-doc/

- Información de Catalina, arquitectura y contenedores  
  https://www.oreilly.com/library/view/professional-apache-tomcat/9780471753612/ch01.html

- Coyote HTTP Connector  
  https://tomcat.apache.org/tomcat-10.1-doc/connectors.html

- Jasper JSP Engine  
  https://en.wikipedia.org/wiki/Apache_Tomcat

- Tomcat Manager  
  https://tomcat.apache.org/tomcat-10.1-doc/manager-howto.html

- Tomcat Host Manager  
  https://tomcat.apache.org/tomcat-10.1-doc/host-manager-howto.html

- Directorios y arquitectura interna  
  https://personal.ntu.edu.sg/ehchua/programming/howto/Tomcat_More.html

- Estructura del servidor Tomcat  
  https://training-course-material.com/training/Apache_Tomcat_and_Java_EE_Administration_US
