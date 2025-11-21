# DESARROLLO DE APLICACIONES WEB
### Despliegue de Aplicaciones Web

![Portada](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/CertificadosUbuntu.png)

---

### U.T. 2 **Práctica 1: Apache**

**Curso:** 2ºDAW  
**Autor:** Javier Gómez Comino  
**Fecha:** 21/11/2025  

---

## Índice

1. Introducción  
2. Investigación  
   2.1. Funcionamiento del protocolo HTTPS y su importancia  
   2.2. Tipos de certificados SSL/TLS  
   2.3. Módulos necesarios en Apache2 para habilitar HTTPS  
3. Ejecución técnica  
   3.1. Instalación y verificación de Apache2  
   3.2. Activación de módulos SSL y headers  
   3.3. Generación de certificado SSL/TLS  
       - Opción A: Certificado autofirmado  
       - Opción B: Certificado Let’s Encrypt con Certbot  
   3.4. Configuración del VirtualHost en el puerto 443  
   3.5. Redirección HTTP → HTTPS (opcional)  
   3.6. Recarga de Apache y validación del acceso seguro  
4. Verificación funcional  
   4.1. Comprobación en navegador  
   4.2. Comprobación con curl  
5. Conclusiones  
   5.1. Resultados obtenidos  
   5.2. Dificultades encontradas  
   5.3. Valoración final

---

## 1. Introducción

En esta práctica se aborda la implementación del protocolo HTTPS en un servidor web Apache2 ejecutándose sobre Ubuntu.  
El objetivo principal es garantizar una conexión segura entre el cliente y el servidor mediante el uso de certificados SSL/TLS.  
Para ello, se realizará una investigación teórica sobre el funcionamiento de HTTPS, los tipos de certificados disponibles y los módulos necesarios en Apache.  
Posteriormente, se llevará a cabo la configuración técnica completa, incluyendo la generación de certificados, la activación de módulos, la configuración del VirtualHost y la validación del acceso seguro al sitio web.

---

### 2.1 Funcionamiento del protocolo HTTPS y su importancia

HTTPS (Hypertext Transfer Protocol Secure) es la versión segura del protocolo HTTP.  
Su funcionamiento se basa en encapsular la comunicación entre el navegador del usuario y el servidor web dentro de una capa de seguridad llamada TLS (Transport Layer Security). Esta capa permite tres funciones clave:

- Cifrado de datos: Toda la información transmitida entre cliente y servidor viaja codificada, lo que impide que terceros puedan leerla o interceptarla fácilmente.
- Autenticación del servidor: El navegador verifica que el servidor al que se conecta es legítimo, gracias al certificado digital que este presenta.
- Integridad de la información: Se garantiza que los datos no han sido modificados durante el tránsito.

Estas características hacen que HTTPS sea esencial para proteger credenciales, datos personales, formularios, pagos y cualquier tipo de información sensible.  
Además, su uso mejora la confianza del usuario, evita ataques de intermediario (MITM) y es un requisito básico para cumplir con normativas de protección de datos.

Hoy en día, los navegadores modernos marcan como “no seguro” cualquier sitio que no utilice HTTPS, lo que puede afectar negativamente la reputación y el posicionamiento SEO de una web.

**Fuente consultada:**  
[RedesZone – Qué es HTTPS y cómo protege tu navegación](https://www.redeszone.net/tutoriales/internet/que-es-https-seguridad/)

---

---

### 2.2 Tipos de certificados SSL/TLS

Los certificados SSL/TLS son fundamentales para establecer conexiones seguras entre el servidor y el cliente.  
Existen principalmente dos tipos de certificados que se diferencian por su nivel de confianza y el proceso de emisión:

- **Certificados autofirmados:**  
  - Generados por el propio administrador del servidor sin intervención de una Autoridad de Certificación (CA).  
  - Proporcionan cifrado básico, pero no cuentan con validación externa.  
  - Los navegadores suelen mostrar advertencias al acceder a sitios con este tipo de certificados.  
  - Son útiles en entornos de prueba, desarrollo o redes internas, pero no recomendados para sitios públicos.

- **Certificados emitidos por una CA confiable:**  
  - Emitidos por una Autoridad de Certificación reconocida e incluida en los almacenes de confianza de sistemas y navegadores.  
  - Garantizan la autenticidad del servidor y eliminan advertencias en los navegadores.  
  - Pueden ser gratuitos (ej. Let’s Encrypt) o de pago, dependiendo del nivel de validación y soporte.  
  - Son imprescindibles para sitios en producción, comercio electrónico y cualquier servicio público que requiera confianza del usuario.

En conclusión, **los certificados autofirmados** son adecuados para pruebas internas, mientras que **los certificados de CA confiable** son la opción recomendada para entornos de producción y sitios accesibles públicamente.

**Fuente consultada:**  
[SSL.com – Vulnerabilidades de certificados autofirmados](https://www.ssl.com/es/art%C3%ADculo/ssl-tls-certificados-autofirmados/)  
[Kinsta – Tipos de Certificados SSL: ¿Cuál es el más adecuado para tu sitio?](https://kinsta.com/es/blog/tipos-de-certificados-ssl/)

---



