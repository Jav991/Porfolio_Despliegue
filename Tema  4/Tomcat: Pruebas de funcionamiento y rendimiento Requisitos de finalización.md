![Portada_Tomcat](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/tomcat_pruebas/tomcat_pruebas.png)

## Introducción
En esta práctica realizo pruebas de funcionamiento y rendimiento sobre una aplicación desplegada en el servidor **Apache Tomcat**, con el objetivo de evaluar su comportamiento bajo carga y analizar su capacidad de respuesta ante múltiples solicitudes concurrentes.

Para ello, utilizo distintas herramientas de pruebas de carga como **ApacheBench**, **Apache JMeter** y el comando **curl** con ejecución en paralelo, que permiten simular el acceso simultáneo de varios usuarios a la aplicación. A partir de los resultados obtenidos, analizo métricas como el tiempo de respuesta, el número de peticiones por segundo y la posible aparición de errores.

Posteriormente, realizo ajustes en la configuración del servidor Tomcat, concretamente en el archivo `server.xml`, modificando parámetros relacionados con la gestión de hilos, conexiones y tiempos de espera. Finalmente, comparo los resultados obtenidos antes y después de la optimización para comprobar la mejora en el rendimiento del sistema.

## 1. Uso de herramientas de pruebas de carga

Para realizar las pruebas de funcionamiento y rendimiento he utilizado distintas herramientas de pruebas de carga, con el objetivo de simular el acceso simultáneo de varios usuarios a la aplicación desplegada en **Apache Tomcat**.

En primer lugar, he utilizado **ApacheBench (ab)**, una herramienta de línea de comandos incluida en Apache HTTP Server, que permite enviar un número determinado de peticiones HTTP al servidor y obtener resultados básicos sobre su rendimiento, como el número de peticiones por segundo y el tiempo medio de respuesta.

Además, he empleado **Apache JMeter**, una herramienta más completa que permite configurar pruebas de carga de forma gráfica. Mediante la creación de grupos de hilos, es posible simular usuarios concurrentes y analizar de forma más detallada el comportamiento de la aplicación, obteniendo métricas como el tiempo de respuesta, el throughput y el porcentaje de errores.

Por último, he utilizado el comando **curl** con ejecución en paralelo para realizar múltiples peticiones simultáneas al servidor desde la línea de comandos. Esta herramienta resulta útil para comprobar de manera rápida el funcionamiento del servidor bajo carga sin necesidad de configuraciones complejas.

El uso conjunto de estas herramientas permite obtener una visión general del rendimiento de la aplicación en diferentes escenarios de carga.
