![Portada](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/Tomcat_IntegracionWeb/Tomcat_Integracion_Servidor_Portada.jpg)

## Introducción a la práctica: Despliegue simple en Tomcat
En entornos reales de producción, no es habitual exponer directamente el puerto de Tomcat (8080 por defecto) a internet. En su lugar, se coloca un servidor web robusto como **Apache HTTP Server** delante de Tomcat actuando como **reverse proxy** (proxy inverso).

Esta arquitectura ofrece múltiples ventajas:
- Apache maneja conexiones HTTPS/SSL de forma eficiente (certificados, cifrado).
- Mejora la seguridad al ocultar la estructura interna de Tomcat.
- Permite servir contenido estático (imágenes, CSS, JS) directamente desde Apache.
- Facilita el balanceo de carga y alta disponibilidad si hay varios nodos Tomcat.

Existen dos formas principales de integrar ambos:
1. Usando el protocolo **AJP/1.3** (Apache JServ Protocol) mediante el módulo `mod_proxy_ajp` o `mod_jk` → más eficiente y binario.
2. Usando **HTTP proxy** simple mediante `mod_proxy` y `mod_proxy_http` → más sencillo pero menos optimizado.

En esta práctica se instalará Apache en una máquina virtual Ubuntu (si no está ya instalado), se configurará uno de estos conectores como reverse proxy hacia Tomcat, y se comprobará que una aplicación web Java desplegada en Tomcat responde correctamente a través del puerto estándar de Apache (80/443), demostrando la integración completa.

## 1.Configuración de Apache como reverse proxy hacia Tomcat
Una vez confirmado que Apache HTTP Server está instalado y en ejecución (`sudo systemctl status apache2` muestra `active (running)`), procedemos a configurar Apache como **proxy inverso** (reverse proxy) para que gestione las peticiones entrantes y las redirija a Tomcat mediante el protocolo **AJP/1.3**.
Activamos los módulos requeridos para el proxy AJP:
```bash
  sudo a2enmod proxy
  sudo a2enmod proxy_ajp
  sudo a2enmod rewrite
```
Se debería ver así
