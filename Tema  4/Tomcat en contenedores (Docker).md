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
![Tomcat_Contenedor_1](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/Tomacat_Contenedores/Tomcat_Contenedor_1.png)

El comando se ejecuta correctamente y Docker descarga la imagen oficial de Tomcat desde Docker Hub.  
En la salida se observa cómo se descargan las distintas capas de la imagen y, finalmente, el mensaje *“Status: Downloaded newer image for tomcat:latest”*, lo que confirma que la imagen se ha descargado y está disponible en el sistema para su uso.

## 2. Montaje de una aplicación en `/usr/local/tomcat/webapps`
En este apartado despliego una aplicación web sencilla en Tomcat utilizando Docker, montándola directamente en el directorio `webapps`, que es donde Tomcat carga automáticamente las aplicaciones.

### 2.1 Creación de la aplicación de prueba

Primero creo un directorio en el sistema anfitrión que contendrá la aplicación web:

```bash
  mkdir ~/tomcat-app
```
Dentro de este directorio creo un archivo index.jsp para comprobar que el despliegue funciona correctamente:

![Tomcat_Contenedor_2](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/Tomacat_Contenedores/Tomcat_Contenedor_2.png)

Este archivo sirve como aplicación de prueba para verificar que Tomcat carga correctamente el contenido montado desde el host.

### 2.2 Ejecución del contenedor Tomcat

Una vez creada la aplicación de prueba, ejecuto el contenedor de Tomcat montando el directorio local en `/usr/local/tomcat/webapps`. De este modo, Tomcat cargará automáticamente la aplicación al iniciarse.

Para ello utilizo el siguiente comando:

```bash
docker run -d \
  --name tomcat-app \
  -p 8080:8080 \
  -v ~/tomcat-app:/usr/local/tomcat/webapps/ROOT \
  tomcat:latest
```

![Tomcat_Contenedor_3](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/Tomacat_Contenedores/Tomcat_Contenedor_3.png)
Como se observa en la captura, el contenedor de Tomcat se ha iniciado correctamente, ya que Docker devuelve el identificador del contenedor tras ejecutar el comando. Esto indica que el servidor se encuentra en ejecución en segundo plano.

El puerto 8080 del contenedor se ha mapeado al puerto 8081 del sistema anfitrión, permitiendo el acceso a la aplicación web desde el navegador. Además, el directorio local se ha montado correctamente en la ruta `/usr/local/tomcat/webapps/ROOT`, lo que permite que Tomcat cargue automáticamente la aplicación al iniciarse.


## 3. Diferencias entre Tomcat nativo y Tomcat en contenedor

El uso de **Apache Tomcat instalado de forma nativa** y **Apache Tomcat ejecutándose dentro de un contenedor Docker** presenta varias diferencias importantes en cuanto a instalación, configuración y despliegue.

### Tomcat nativo

En una instalación nativa, Tomcat se instala directamente sobre el sistema operativo. Esto implica configurar manualmente dependencias como Java, ajustar rutas, usuarios y permisos, así como modificar archivos de configuración del sistema.

Este enfoque ofrece un mayor control sobre el servidor y su integración con el sistema, pero también puede generar problemas de compatibilidad entre entornos y dificulta la portabilidad de la aplicación.

**Características principales:**
- Instalación directa en el sistema operativo.
- Configuración manual de Java y variables de entorno.
- Mayor dependencia del sistema anfitrión.
- Menor portabilidad entre equipos.

### Tomcat en contenedor (Docker)

En el caso de Tomcat en contenedor, el servidor se ejecuta dentro de una imagen Docker que ya incluye todo lo necesario para funcionar. Esto permite desplegar Tomcat de forma rápida y consistente en cualquier sistema que tenga Docker instalado.

Además, el uso de contenedores facilita el aislamiento de la aplicación, evitando conflictos con otras versiones de software y simplificando el proceso de despliegue.

**Características principales:**
- No requiere instalación directa de Tomcat ni Java en el sistema.
- Despliegue rápido y reproducible.
- Aislamiento del entorno de ejecución.
- Mayor portabilidad entre distintos sistemas.

### Comparación general

| Tomcat nativo | Tomcat en contenedor |
|--------------|---------------------|
| Instalación manual | Instalación mediante imagen Docker |
| Dependiente del sistema | Independiente del sistema |
| Menor portabilidad | Alta portabilidad |
| Configuración más compleja | Configuración más sencilla |
| Mayor control directo | Mayor facilidad de despliegue |

En conclusión, mientras que **Tomcat nativo** es adecuado para entornos donde se requiere un control exhaustivo del sistema, **Tomcat en contenedor** resulta más práctico para entornos de pruebas, desarrollo y despliegues rápidos, aportando flexibilidad y facilidad de mantenimiento.


## 4. Despliegue en la nube (opcional)

De forma opcional, la aplicación desplegada en **Apache Tomcat** podría ejecutarse en un entorno de nube utilizando servicios de infraestructura como **AWS EC2**, **Azure Virtual Machine** o **Google Compute Engine**.

En este tipo de entornos, el proceso de despliegue sería similar al realizado en local, creando una máquina virtual con un sistema operativo Linux y configurando en ella Docker o Tomcat de forma nativa. Una vez preparada la instancia, se podría desplegar la aplicación utilizando un contenedor Docker de Tomcat o mediante una instalación tradicional del servidor.

El uso de la nube permitiría acceder a la aplicación desde Internet, mejorar la escalabilidad del sistema y facilitar la gestión de recursos, ya que estos servicios permiten aumentar o reducir la capacidad de la máquina en función de la carga.

Aunque en esta práctica el despliegue se ha realizado en un entorno local, el uso de plataformas cloud supondría una extensión natural del trabajo realizado, aplicando los mismos conceptos de contenedores y configuración de servidores en un entorno de producción real.

