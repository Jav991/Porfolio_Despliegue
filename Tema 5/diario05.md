# Diario de prácticas — FileZilla Server

## Práctica 1: Introducción y arquitectura de FTP

En esta primera práctica he trabajado la parte teórica relacionada con los protocolos de transferencia de archivos. 

He estudiado las diferencias entre **FTP, FTPS y SFTP**, comprendiendo especialmente:

- Que FTP no cifra la información.
- Que FTPS añade cifrado mediante SSL/TLS.
- Que SFTP funciona sobre SSH y es más seguro y sencillo de configurar.

También he analizado la **arquitectura cliente-servidor** del protocolo FTP, entendiendo que:

- Existe una conexión de control (puerto 21).
- Existe una conexión de datos independiente.
- Hay diferencias entre modo activo y modo pasivo.
- El modo pasivo es el más utilizado actualmente por su compatibilidad con firewalls.

Esta práctica me ha servido para comprender cómo funciona internamente un servidor FTP antes de instalarlo.

---

## Práctica 2: Instalación y configuración de FileZilla Server

En la segunda práctica he realizado la instalación de **FileZilla Server** en el sistema.

He llevado a cabo los siguientes pasos:

- Descarga del instalador desde la página oficial.
- Instalación del paquete `.deb`.
- Configuración de contraseña de administrador.
- Configuración del inicio automático como servicio del sistema.
- Verificación de que el servicio estaba activo (`active (running)`).

También he comprobado:

- Que el servidor escucha en el puerto 21.
- Que la consola de administración funciona en el puerto 14148.
- Que puedo acceder desde el navegador a `http://localhost:14148`.

Finalmente, he verificado el correcto funcionamiento del servicio realizando pruebas de conexión desde consola y desde un cliente FTP.

---

## Conclusión

En estas dos prácticas he pasado de entender la teoría del protocolo FTP a instalar y configurar un servidor funcional.

He aprendido cómo funciona la arquitectura de FTP y cómo desplegar un servicio real en un sistema Linux, dejándolo configurado para que arranque automáticamente.
