![Portada_Tomcat](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/tomcat_pruebas/tomcat_pruebas.png)

## Introducción
En esta práctica realizo pruebas de funcionamiento y rendimiento sobre una aplicación desplegada en el servidor **Apache Tomcat**, con el objetivo de evaluar su comportamiento bajo carga y analizar su capacidad de respuesta ante múltiples solicitudes concurrentes.

Para ello, utilizo distintas herramientas de pruebas de carga como **ApacheBench**, **Apache JMeter** y el comando **curl** con ejecución en paralelo, que permiten simular el acceso simultáneo de varios usuarios a la aplicación. A partir de los resultados obtenidos, analizo métricas como el tiempo de respuesta, el número de peticiones por segundo y la posible aparición de errores.

Posteriormente, realizo ajustes en la configuración del servidor Tomcat, concretamente en el archivo `server.xml`, modificando parámetros relacionados con la gestión de hilos, conexiones y tiempos de espera. Finalmente, comparo los resultados obtenidos antes y después de la optimización para comprobar la mejora en el rendimiento del sistema.

## 1. Uso de herramientas de pruebas de carga

Para realizar las pruebas de funcionamiento y rendimiento he utilizado distintas herramientas de pruebas de carga, con el objetivo de simular el acceso simultáneo de varios usuarios a la aplicación desplegada en **Apache Tomcat** y analizar cómo responde el servidor ante diferentes niveles de carga.

En primer lugar, he utilizado **ApacheBench (ab)**, una herramienta de línea de comandos incluida en Apache HTTP Server. Esta herramienta permite enviar un número concreto de peticiones HTTP a una URL determinada, indicando también cuántas de ellas se realizan de forma concurrente. ApacheBench es especialmente útil para obtener una visión rápida del rendimiento del servidor, ya que proporciona métricas básicas como el número de peticiones procesadas por segundo, el tiempo medio de respuesta y el número de solicitudes fallidas.

También he empleado **Apache JMeter**, una herramienta más completa y potente orientada a la realización de pruebas de carga y estrés. JMeter permite configurar pruebas de forma gráfica mediante la creación de grupos de hilos, que representan usuarios concurrentes accediendo a la aplicación. Gracias a esta herramienta es posible simular escenarios más realistas y obtener estadísticas detalladas, como el tiempo de respuesta medio y máximo, el throughput y el porcentaje de errores durante la ejecución de las pruebas.

Por último, he utilizado el comando **curl** con ejecución en paralelo, que permite realizar múltiples peticiones HTTP simultáneas desde la línea de comandos. Aunque se trata de una herramienta más sencilla que las anteriores, resulta útil para comprobar de forma rápida el funcionamiento del servidor bajo carga y verificar que responde correctamente ante varias solicitudes concurrentes sin necesidad de una configuración compleja.

El uso conjunto de estas herramientas permite analizar el rendimiento de la aplicación desde distintos enfoques, obteniendo una visión general y detallada del comportamiento del servidor Apache Tomcat bajo carga.

## 2. Ejecución de pruebas de carga sobre la aplicación

Una vez seleccionadas las herramientas de pruebas de carga, procedo a ejecutar distintas pruebas sobre la aplicación desplegada en **Apache Tomcat**, con el objetivo de analizar su comportamiento bajo carga y evaluar su capacidad de respuesta ante múltiples solicitudes concurrentes.

### Pruebas con ApacheBench

Para realizar las pruebas iniciales utilizo **ApacheBench**, ejecutando un número determinado de peticiones HTTP sobre la URL de la aplicación y variando el nivel de concurrencia. El comando utilizado es el siguiente:

```bash
ab -n 1000 -c 50 http://localhost:8080/mi-aplicacion/
```

En esta prueba se envían 1000 peticiones al servidor, de las cuales 50 se realizan de forma simultánea. A partir de los resultados obtenidos, se analizan métricas como el número de peticiones por segundo, el tiempo medio de respuesta y la existencia de posibles errores durante la ejecución.

![Prueba_ApacheBench](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/tomcat_pruebas/Tomcat_prueba1.png)
![Prueba_ApacheBench](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/tomcat_pruebas/Tomcat_prueba1_2.png)

### Pruebas de carga con curl (--parallel)

Además de las pruebas realizadas con ApacheBench, ejecuto una prueba de carga sencilla utilizando el comando **curl** con ejecución en paralelo, con el objetivo de simular múltiples peticiones HTTP simultáneas a la aplicación desplegada en **Apache Tomcat**.

El comando utilizado es el siguiente:

```bash
curl --parallel --parallel-immediate http://localhost:8080/{1..50}
```
![Tomcat_Pruebas2](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/tomcat_pruebas/Tomcat_Pruebas2.png)

La ejecución del comando `curl --parallel --parallel-immediate` devuelve correctamente la página por defecto de Apache Tomcat, lo que confirma que el servidor se encuentra en funcionamiento y es capaz de responder a múltiples peticiones concurrentes sin producir errores.

La respuesta obtenida muestra el contenido HTML correspondiente a la página principal de Tomcat, indicando que todas las solicitudes han sido atendidas correctamente durante la prueba.

## 3. Registro de resultados y ajustes en `server.xml`

Tras la ejecución de las pruebas de carga, registro los resultados obtenidos con cada herramienta, prestando especial atención a métricas como el tiempo de respuesta, el número de peticiones atendidas por segundo y la aparición de posibles errores durante las pruebas.

A partir de este análisis, realizo ajustes en la configuración del servidor **Apache Tomcat** para mejorar su rendimiento. Estos cambios se llevan a cabo en el archivo de configuración `server.xml`, donde modifico principalmente parámetros relacionados con:

- **Gestión de hilos**, ajustando el número máximo de hilos disponibles para atender peticiones concurrentes.
- **Conexiones**, configurando el número máximo de conexiones simultáneas permitidas.
- **Tiempos de espera**, optimizando los valores de timeout para evitar bloqueos innecesarios y mejorar la eficiencia del servidor.

![Configuración_Tomcat_Pruebas](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/tomcat_pruebas/Tomcat_Prueba3.png)

Después de aplicar estos cambios, reinicio el servidor Tomcat para que la nueva configuración tenga efecto y repito las pruebas de carga, con el objetivo de comprobar si los ajustes realizados producen una mejora en el rendimiento general de la aplicación.

## 4. Comparación del rendimiento antes y después de la optimización

Una vez realizadas las pruebas de carga iniciales con la configuración por defecto de Apache Tomcat, se procedió a optimizar el conector HTTP del puerto 8080 modificando distintos parámetros en el archivo `server.xml`.

Antes de la optimización, el servidor utilizaba una configuración básica sin ajustes específicos para la gestión de hilos ni para el control del número máximo de conexiones concurrentes. Bajo carga, el tiempo de respuesta aumentaba progresivamente a medida que se incrementaba el número de peticiones simultáneas, aunque el servidor seguía respondiendo correctamente.

Tras aplicar los ajustes de rendimiento, aumentando el número máximo de hilos, definiendo un número mínimo de hilos en espera y ampliando el número de conexiones aceptadas, se repitieron las pruebas de carga utilizando las mismas herramientas y parámetros.

Los resultados obtenidos muestran una mejora en el comportamiento del servidor, especialmente en escenarios con múltiples solicitudes concurrentes. El tiempo de respuesta se mantuvo más estable y el servidor fue capaz de gestionar un mayor volumen de peticiones sin errores, lo que indica una mejor utilización de los recursos disponibles.

En conclusión, la optimización del conector HTTP permitió mejorar el rendimiento general del servidor Apache Tomcat, demostrando la importancia de ajustar correctamente su configuración para entornos con carga concurrente.


