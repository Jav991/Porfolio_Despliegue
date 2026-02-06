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

## 3. Integración con servidor web

Para mejorar el rendimiento y la gestión de las peticiones, integro Apache Tomcat con un servidor web externo, como **Apache HTTP Server**. Esta integración permite utilizar el servidor web como capa frontal, encargándose de recibir las solicitudes de los clientes, mientras que Tomcat procesa la lógica de las aplicaciones web.

Este tipo de arquitectura es habitual en entornos profesionales, ya que permite separar claramente el servidor web del servidor de aplicaciones, mejorando la escalabilidad y el control del sistema.

### 3.1 Funcionamiento de la integración

El servidor web actúa como intermediario entre el cliente y Tomcat. Las peticiones HTTP entran primero por el servidor web, que decide si debe servir contenido estático directamente o redirigir la solicitud a Tomcat para su procesamiento.

De esta forma, Tomcat se centra exclusivamente en la ejecución de servlets y aplicaciones Java, mientras que el servidor web gestiona las conexiones entrantes.

### 3.2 Ventajas de la integración

La integración de Tomcat con un servidor web aporta múltiples beneficios:

- Mejora del rendimiento general del sistema.
- Gestión más eficiente de las conexiones concurrentes.
- Posibilidad de aplicar políticas de seguridad adicionales.
- Mayor flexibilidad en la configuración del entorno.

### 3.3 Uso en entornos reales

Esta combinación es especialmente útil en entornos de producción, donde se requiere un mayor control sobre el tráfico web y una arquitectura más robusta. Gracias a esta integración, es posible adaptar el sistema a distintos escenarios sin modificar las aplicaciones desplegadas en Tomcat.


## 4. Seguridad aplicada

La seguridad es un aspecto clave en la administración de un servidor Apache Tomcat, ya que este actúa como punto de acceso a las aplicaciones web desplegadas. Durante el desarrollo de esta práctica he tenido en cuenta diferentes medidas de seguridad orientadas a proteger tanto el servidor como las aplicaciones, reduciendo riesgos y posibles accesos no autorizados.

### 4.1 Gestión de usuarios y roles

Tomcat incorpora un sistema de autenticación y autorización basado en usuarios y roles, que permite controlar el acceso a las herramientas de administración del servidor. Mediante esta configuración es posible definir qué usuarios pueden acceder a la consola de administración y qué acciones están autorizados a realizar.

Esta gestión por roles facilita la separación de responsabilidades, permitiendo que solo los usuarios necesarios tengan acceso a funciones críticas del servidor, lo que mejora notablemente la seguridad del sistema.

### 4.2 Protección de la consola de administración

Las aplicaciones de administración incluidas en Tomcat son especialmente sensibles, ya que permiten gestionar aplicaciones, usuarios y configuraciones del servidor. Por este motivo, es fundamental restringir su acceso y evitar que estén expuestas innecesariamente.

Limitar el acceso a estas herramientas contribuye a prevenir ataques y usos indebidos del servidor, especialmente en entornos donde Tomcat está accesible desde redes externas.

### 4.3 Uso de conexiones seguras (HTTPS)

El uso de HTTPS permite cifrar la comunicación entre el cliente y el servidor, protegiendo los datos que se transmiten durante las peticiones. Esto resulta especialmente importante cuando las aplicaciones manejan información sensible o credenciales de usuario.

Mediante el uso de certificados digitales, Tomcat puede garantizar que la comunicación sea segura, evitando posibles ataques de interceptación y aumentando la confianza de los usuarios en las aplicaciones desplegadas.

### 4.4 Restricción de aplicaciones y servicios innecesarios

Tomcat incluye por defecto aplicaciones de ejemplo y funcionalidades que no siempre son necesarias. Mantener activados únicamente los servicios imprescindibles reduce la superficie de ataque del servidor y minimiza el riesgo de explotación de vulnerabilidades.

Eliminar o deshabilitar aplicaciones que no se utilizan es una buena práctica de seguridad que ayuda a mantener el sistema más controlado y estable.

### 4.5 Control y revisión de registros

El análisis de los registros del servidor es una herramienta fundamental para detectar posibles problemas de seguridad. A través de los logs es posible identificar accesos no autorizados, errores recurrentes o comportamientos anómalos en el servidor.

Una revisión periódica de estos registros permite anticiparse a posibles incidencias y mejorar la respuesta ante problemas de seguridad.

### 4.6 Actualizaciones y mantenimiento del servidor

Mantener Tomcat actualizado es una de las medidas más importantes para garantizar la seguridad del sistema. Las actualizaciones corrigen vulnerabilidades detectadas y mejoran la estabilidad del servidor.

Además, un mantenimiento regular de la configuración y de las aplicaciones desplegadas contribuye a reducir riesgos y a mantener un entorno más seguro y fiable.

### 4.7 Importancia de la seguridad en entornos reales

Todas estas medidas adquieren una mayor relevancia en entornos de producción, donde el servidor puede estar expuesto a Internet. Una correcta configuración de la seguridad en Tomcat es fundamental para garantizar la disponibilidad, integridad y confidencialidad de las aplicaciones web.

La aplicación de buenas prácticas de seguridad no solo protege el servidor, sino que también mejora la calidad y fiabilidad del servicio ofrecido.

## 5. Pruebas de rendimiento

Las pruebas de rendimiento son fundamentales para evaluar el comportamiento del servidor Apache Tomcat cuando recibe múltiples solicitudes de forma simultánea. Durante esta práctica he realizado distintas pruebas con el objetivo de comprobar la capacidad de respuesta del servidor y analizar cómo se comporta bajo diferentes niveles de carga.

Estas pruebas permiten detectar posibles cuellos de botella, evaluar la estabilidad del sistema y comprobar si la configuración del servidor es adecuada para soportar un número elevado de usuarios concurrentes.

### 5.1 Objetivo de las pruebas

El principal objetivo de las pruebas de rendimiento ha sido analizar:

- El tiempo de respuesta del servidor ante múltiples peticiones.
- La estabilidad del sistema bajo carga.
- La aparición de posibles errores durante la ejecución.
- La influencia de la configuración del servidor en el rendimiento general.

De esta forma, es posible evaluar si Tomcat responde correctamente en situaciones similares a un entorno real.

### 5.2 Metodología utilizada

Para realizar las pruebas se ha simulado el acceso concurrente de varios usuarios a la aplicación desplegada en Tomcat. Durante la ejecución de las pruebas se ha observado cómo el servidor gestiona las solicitudes entrantes y cómo varían los tiempos de respuesta a medida que aumenta la carga.

Las pruebas se han llevado a cabo tanto antes como después de realizar ajustes en la configuración del servidor, lo que permite comparar resultados y comprobar si se ha producido una mejora en el rendimiento.

### 5.3 Resultados obtenidos

Los resultados obtenidos muestran que, bajo cargas moderadas, el servidor responde de forma estable y sin errores. A medida que aumenta el número de solicitudes simultáneas, se aprecia un incremento progresivo en el tiempo de respuesta, lo cual es un comportamiento esperado.

Tras realizar ajustes en la configuración del servidor, el rendimiento mejora, permitiendo gestionar un mayor número de peticiones concurrentes de forma más eficiente y reduciendo los tiempos de espera.

### 5.4 Análisis del comportamiento del servidor

El análisis de los resultados permite comprobar que Apache Tomcat es capaz de adaptarse correctamente a escenarios de carga variable. Una configuración adecuada del servidor influye directamente en su capacidad para gestionar solicitudes concurrentes sin degradar el servicio.

Estas pruebas también ponen de manifiesto la importancia de realizar ajustes específicos según el entorno en el que se vaya a desplegar la aplicación, ya que una configuración por defecto puede no ser suficiente en escenarios más exigentes.

### 5.5 Conclusión de las pruebas de rendimiento

Las pruebas de rendimiento realizadas confirman que Apache Tomcat ofrece un comportamiento estable y predecible bajo carga, siempre que esté correctamente configurado. Este tipo de pruebas resulta esencial para garantizar un buen funcionamiento del servidor en entornos de producción y para anticiparse a posibles problemas de rendimiento.

