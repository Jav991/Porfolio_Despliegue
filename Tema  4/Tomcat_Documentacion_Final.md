![Portada](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/tomcat_Documentacion_Final/Tomcat_Documentacion_Final.png)

## 1. Arquitectura básica de Apache Tomcat

Apache Tomcat es un servidor de aplicaciones ligero que utilizo para desplegar y ejecutar aplicaciones web desarrolladas con **Java Servlet** y **JSP**. Su arquitectura es sencilla y modular, lo que facilita tanto su comprensión como su administración.

### 1.1 Componentes principales

La arquitectura de Tomcat se basa en varios componentes fundamentales:

- **Conector (Connector)**  
  Es el componente encargado de recibir las peticiones de los clientes. Normalmente trabaja mediante el protocolo HTTP y escucha en el puerto 8080.

- **Servicio (Service)**  
  Un servicio agrupa uno o varios conectores junto con un motor. Su función es conectar las peticiones entrantes con el motor que las procesa.

- **Motor (Engine)**  
  El motor es el encargado de procesar las peticiones y dirigirlas al host virtual correspondiente según la configuración.

- **Host**  
  Representa un host virtual, similar a un dominio. Cada host puede contener varias aplicaciones web.

- **Contexto (Context)**  
  El contexto corresponde a una aplicación web concreta. Cada aplicación suele estar asociada a un directorio o a un archivo WAR dentro del directorio `webapps`.

### 1.2 Flujo de funcionamiento

El funcionamiento básico de Tomcat sigue los siguientes pasos:

1. El cliente realiza una petición HTTP desde el navegador.
2. El conector recibe la petición en el puerto configurado.
3. El motor analiza la solicitud y la dirige al host correspondiente.
4. El contexto procesa la petición utilizando servlets o JSP.
5. Tomcat genera la respuesta y la envía de vuelta al cliente.

### 1.3 Estructura de directorios

Tomcat organiza sus archivos y aplicaciones en distintos directorios, entre los que destacan:

- `bin/`: contiene los scripts para iniciar y detener el servidor.
- `conf/`: incluye los archivos de configuración principales.
- `logs/`: almacena los registros de actividad y errores.
- `webapps/`: contiene las aplicaciones web desplegadas.
- `lib/`: librerías compartidas.
- `temp/` y `work/`: directorios utilizados para archivos temporales y compilación de JSP.

### 1.4 Ventajas de la arquitectura de Tomcat

Entre las principales ventajas de la arquitectura de Tomcat destaco:

- Diseño modular y flexible.
- Fácil integración con otros servidores web como Apache o Nginx.
- Bajo consumo de recursos.
- Adecuado tanto para entornos de desarrollo como de producción.


## 2. Configuración del servidor

La configuración del servidor Apache Tomcat se realiza principalmente mediante archivos XML ubicados en el directorio `conf/`. A través de estos archivos es posible definir el comportamiento del servidor, los puertos de escucha, la seguridad y la gestión de las aplicaciones web.

### 2.1 Archivos de configuración principales

Los archivos más importantes que he utilizado y analizado durante la configuración del servidor son:

- **server.xml**  
  Permite configurar aspectos internos del servidor, como los conectores, puertos y protocolos. En este archivo se definen, por ejemplo, los puertos HTTP y HTTPS.

- **web.xml**  
  Archivo de configuración global para todas las aplicaciones web. Define parámetros por defecto, como servlets, filtros o páginas de error.

- **context.xml**  
  Se utiliza para definir recursos específicos de una aplicación, como conexiones a bases de datos (DataSource).

- **tomcat-users.xml**  
  Contiene los usuarios y roles necesarios para acceder a la consola de administración de Tomcat.

### 2.2 Configuración de puertos y conectores

Por defecto, Tomcat escucha las peticiones HTTP en el puerto **8080**. Esta configuración se define dentro del archivo `server.xml` mediante un conector. También es posible habilitar HTTPS configurando un conector seguro con un certificado SSL.

Gracias a esta configuración, el servidor puede adaptarse fácilmente a distintos entornos y necesidades, tanto en desarrollo como en producción.

### 2.3 Gestión de aplicaciones

Las aplicaciones web se despliegan en el directorio `webapps/`. Tomcat permite desplegar aplicaciones de dos formas:

- Copiando directamente el directorio de la aplicación.
- Utilizando archivos WAR, que Tomcat despliega automáticamente al iniciarse.

Esta flexibilidad simplifica el proceso de despliegue y actualización de aplicaciones.

### 2.4 Ventajas de la configuración de Tomcat

La configuración del servidor Tomcat destaca por:

- Su simplicidad y claridad.
- El uso de archivos XML fáciles de modificar.
- La posibilidad de personalizar el comportamiento del servidor sin recompilar aplicaciones.


