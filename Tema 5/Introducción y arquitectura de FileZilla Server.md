![Portada](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/Filezilla/Portada.png)

## 1. FTP vs FTPS vs SFTP (conceptual)

Existen distintos protocolos para la transferencia de archivos entre un cliente y un servidor, siendo los más habituales **FTP**, **FTPS** y **SFTP**. Aunque su finalidad es la misma, presentan diferencias importantes en cuanto a seguridad y funcionamiento.

**FTP (File Transfer Protocol)** es el protocolo más antiguo. Funciona mediante una arquitectura cliente-servidor y utiliza dos canales de comunicación: uno para el control y otro para los datos. El principal inconveniente de FTP es que no cifra la información, por lo que usuarios, contraseñas y archivos viajan en texto plano.

**FTPS (FTP Secure)** es una extensión de FTP que añade cifrado mediante SSL/TLS. Mantiene el mismo funcionamiento básico que FTP, pero protege la información durante la transmisión. Puede funcionar en modo explícito o implícito, lo que influye en el uso de puertos y en la configuración del cortafuegos.

**SFTP (SSH File Transfer Protocol)** es un protocolo diferente a FTP, ya que está basado en SSH. Utiliza un único canal cifrado para el control y los datos, lo que lo hace más seguro y sencillo de configurar. Por este motivo, suele ser la opción recomendada en entornos actuales.

---

## 2. Arquitectura cliente–servidor en FTP

El protocolo FTP sigue un modelo cliente–servidor, donde:

- El cliente FTP inicia la conexión y solicita operaciones como listar directorios, subir o descargar archivos.
- El servidor FTP recibe las peticiones, autentica al usuario y gestiona la transferencia de datos.

Una característica particular de FTP es el uso de dos conexiones independientes:

- Conexión de control.
- Conexión de datos.

Esta separación influye directamente en los modos activo y pasivo.

---

## 3. Puertos implicados en FTP

FTP utiliza diferentes puertos dependiendo del tipo de conexión:

- **Puerto 21**: utilizado para la conexión de control.
- **Conexión de datos**:
  - En **modo activo**, el servidor inicia la conexión de datos desde el puerto 20 hacia el cliente.
  - En **modo pasivo**, el servidor utiliza un rango de puertos y es el cliente quien inicia la conexión.

Actualmente, el modo pasivo es el más utilizado debido a su mayor compatibilidad con firewalls y redes NAT.

---

## 4. Esquema del flujo de conexión FTP

### Conexión de control

- El cliente establece conexión con el servidor a través del puerto 21.
- Por esta conexión se intercambian comandos y respuestas (autenticación, navegación, órdenes de transferencia).

### Conexión de datos

- Se utiliza para la transferencia de archivos y listados de directorios.
- Se abre y se cierra según la operación realizada.

### Diferencias entre modo activo y pasivo

**Modo activo**:
- El cliente inicia la conexión de control.
- El servidor inicia la conexión de datos hacia el cliente.
- Puede presentar problemas con firewalls del lado del cliente.

**Modo pasivo**:
- El cliente inicia tanto la conexión de control como la de datos.
- El servidor indica el puerto que debe utilizarse.
- Es el modo más recomendado en la mayoría de entornos.

