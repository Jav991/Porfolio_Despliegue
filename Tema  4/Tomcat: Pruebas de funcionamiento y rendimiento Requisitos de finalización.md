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

### Pruebas con curl en ejecución paralela

Además de las pruebas realizadas con ApacheBench, ejecuto una prueba de carga sencilla utilizando el comando **curl** con ejecución en paralelo, con el objetivo de simular múltiples peticiones HTTP simultáneas a la aplicación desplegada en **Apache Tomcat**.

El comando utilizado es el siguiente:

```bash
curl --parallel --parallel-immediate http://localhost:8080/{1..50}
```
![Tomcat_Pruebas2](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/tomcat_pruebas/Tomcat_Pruebas2.png)

Este comando envía 50 peticiones HTTP de forma concurrente al servidor. La opción --parallel permite ejecutar varias solicitudes al mismo tiempo, mientras que --parallel-immediate fuerza el inicio inmediato de todas las peticiones sin esperar a que finalicen las anteriores.

Durante la ejecución de la prueba se puede observar cómo el servidor gestiona múltiples solicitudes concurrentes, apreciándose un ligero incremento en el tiempo de respuesta a medida que aumenta la carga. No obstante, el servidor responde correctamente a todas las peticiones, sin producirse errores visibles durante la prueba.

Esta prueba permite verificar de forma rápida el correcto funcionamiento del servidor bajo carga, complementando los resultados obtenidos con otras herramientas de pruebas de rendimiento.




