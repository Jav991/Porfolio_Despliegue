# Diario técnico — Tema 4: Apache Tomcat

## Introducción

Durante el desarrollo del Tema 4 he trabajado con Apache Tomcat como servidor de aplicaciones Java, abordando su instalación, configuración interna, ajuste de parámetros de rendimiento y despliegue tanto en entorno nativo como contenerizado.  

Mi objetivo principal ha sido comprender su arquitectura, funcionamiento interno y posibilidades de optimización en un entorno de pruebas controlado.

---

## Instalación y verificación del servicio

Realicé la instalación de Tomcat en un entorno Linux, verificando previamente la correcta disponibilidad de la máquina virtual Java (JVM), requisito indispensable para su funcionamiento.

Una vez desplegado el servicio, comprobé:

- El arranque correcto del servicio.
- La escucha en el puerto 8080.
- El acceso a la aplicación por defecto mediante navegador.
- La generación de logs en el directorio correspondiente.

Esta fase me permitió validar el entorno base antes de realizar modificaciones estructurales.

---

## Análisis de la arquitectura interna

Llevé a cabo un estudio de los principales componentes de configuración:

- `server.xml`: definición de conectores y parámetros de red.
- `web.xml`: configuración global de aplicaciones.
- `context.xml`: parámetros específicos de contexto.
- `tomcat-users.xml`: gestión de usuarios y roles.

Asimismo, analicé la estructura de directorios (`conf`, `webapps`, `logs`, `lib`, `bin`), entendiendo el proceso de despliegue automático de aplicaciones WAR y directorios expandidos.

También comprobé el mecanismo de carga dinámica de aplicaciones sin necesidad de reinicio completo del servicio.

---

## Evaluación de rendimiento y concurrencia

Realicé pruebas de carga controladas para observar el comportamiento del servidor bajo múltiples peticiones simultáneas.

Centré mi análisis en:

- La capacidad de gestión de hilos (threads).
- El tiempo medio de respuesta.
- La estabilidad bajo concurrencia moderada.
- El comportamiento del conector HTTP (NIO).

Posteriormente ajusté parámetros del conector tales como:

- `maxThreads`
- `minSpareThreads`
- `acceptCount`
- `maxConnections`

Tras los ajustes, observé una mejora en la estabilidad del servicio bajo una carga equivalente, lo que confirmó la importancia de una correcta parametrización en entornos productivos.

---

## Despliegue en entorno contenerizado

Procedí a ejecutar Tomcat dentro de un contenedor Docker con el fin de comparar su comportamiento respecto a la instalación nativa.

Durante este proceso gestioné incidencias relacionadas con:

- Conflictos de puertos.
- Contenedores previamente creados.
- Estado del sistema de archivos.

Una vez resueltos los problemas, verifiqué que el contenedor ofrecía un comportamiento funcional equivalente al entorno nativo, destacando la ventaja de portabilidad y aislamiento que aporta la contenerización.

---

## Seguridad y buenas prácticas

Revisé aspectos básicos de seguridad:

- Restricción de accesos a la consola administrativa.
- Revisión de usuarios y roles.
- Eliminación de aplicaciones de ejemplo innecesarias.
- Revisión de permisos de archivos y directorios.

Concluí que, en un entorno real, sería recomendable complementar la configuración con:

- Uso de HTTPS.
- Integración tras un proxy inverso.
- Monitorización de métricas JVM.
- Políticas de firewall adecuadas.

---

## Conclusiones técnicas

Considero que Apache Tomcat es un servidor de aplicaciones robusto, modular y altamente configurable.  

Las pruebas realizadas me permitieron comprobar que:

- La configuración por defecto es válida para entornos de desarrollo.
- La optimización del conector HTTP es clave para mejorar el rendimiento.
- La contenerización facilita la reproducibilidad del despliegue.
- La documentación y el control de cambios son esenciales para mantener la estabilidad.

En conjunto, esta práctica me ha permitido consolidar conocimientos sobre arquitectura cliente-servidor, gestión de hilos, configuración avanzada y despliegue en entornos modernos.

---

# Fin del diario técnico
