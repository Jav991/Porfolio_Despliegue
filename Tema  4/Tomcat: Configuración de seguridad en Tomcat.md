![Portada](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/Tomcat_IntegracionWeb/Tomcat_Integracion_Servidor_Portada.jpg)

## 1. Definir roles y usuarios en `tomcat-users.xml`

Para permitir el acceso a las aplicaciones de administración de Tomcat, es necesario definir usuarios y roles en el archivo `tomcat-users.xml`, ubicado normalmente en:

```bash
/etc/tomcat10/tomcat-users.xml
```

### Pasos para configurar:

1. Editar el archivo:
```bash
sudo nano /etc/tomcat10/tomcat-users.xml
```

2. Buscar la sección comentada de usuarios (entre `<!--` y `-->`).

3. Descomentar y modificar los usuarios.

Tomcat define varios roles administrativos:

| Rol | Descripción |
|---|---|
| `manager-gui` | Acceso a la interfaz web de *Manager App* |
| `admin-gui` | Acceso a la interfaz web de *Host Manager* |
| `manager-script` | Acceso al Manager vía scripts (sin interfaz web) |
| `manager-jmx` | Acceso a la gestión vía JMX |
| `manager-status` | Permite consultar el estado del servidor |

### Configuración de usuarios:

El archivo viene con usuarios de ejemplo **comentados**. Debes descomentar y modificar esta sección:

**Antes**
```xml
<!--
  <user username="admin" password="<must-be-changed>" roles="manager-gui"/>
  <user username="robot" password="<must-be-changed>" roles="manager-script"/>
-->
```

**Después**
```xml
<role rolename="manager-gui"/>
<role rolename="admin-gui"/>
<user username="admin" password="admin123" roles="manager-gui, admin-gui"/>
<user username="robot" password="robot123" roles="manager-script"/>
```

### Pasos:

1. Eliminar `<!--` al inicio y `-->` al final
2. Añadir las definiciones de roles
3. Cambiar `<must-be-changed>` por contraseñas reales
4. Añadir `,admin-gui` al usuario admin para acceso al Host Manager

### Debería quedar así

![Seguridad_Tomcat_1](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/tomcat_seguridad_1.png)

### Reiniciamos Tomcat con:

```bash
sudo systemctl restart tomcat10
```

### Verificar el  estado de Tomcat después de reiniciar:

```bash
sudo systemctl status tomcat10
```
![Seguridad_Tomcat_2](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/tomcat_seguridad_2.png)

## 2. Restringir el acceso al Manager

Tomcat incluye dos aplicaciones de administración:

- **Manager App**
- **Host Manager**

Para mejorar la seguridad, Tomcat restringe por defecto el acceso a estas aplicaciones únicamente desde `localhost`.

Esta restricción se implementa mediante una **Valve** en el archivo:

```bash
/etc/tomcat10/Catalina/localhost/manager.xml
```


En Tomcat 10, normalmente encontrarás:
- `/etc/tomcat10/Catalina/localhost/manager.xml`
- `/etc/tomcat10/Catalina/localhost/host-manager.xml`

Editar el archivo del Manager:

```bash
sudo nano /etc/tomcat10/Catalina/localhost/manager.xml
```

 Contenido del archivo:

El archivo `/etc/tomcat10/Catalina/localhost/manager.xml` contiene:

```xml
<Context antiResourceLocking="false" privileged="true" >
  <Valve className="org.apache.catalina.valves.RemoteAddrValve"
         allow="127\.\d+\.\d+\.\d+|::1|0:0:0:0:0:0:0:1" />
</Context>
```

Esta configuración solo permite acceso desde localhost (127.x.x.x o ::1).

### Debe de quedar así
![Seguridad_Tomcat_3](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/Tomcat_Seguridad_3.png)

### Opciones de configuración:

#### Opción 1: Permitir acceso desde una IP específica

```xml
<Context antiResourceLocking="false" privileged="true" >
  <Valve className="org.apache.catalina.valves.RemoteAddrValve"
         allow="127\.\d+\.\d+\.\d+|::1|0:0:0:0:0:0:0:1|192\.168\.1\.100" />
</Context>
```

#### Opción 2: Permitir acceso desde una red completa

```xml
<Context antiResourceLocking="false" privileged="true" >
  <Valve className="org.apache.catalina.valves.RemoteAddrValve"
         allow="127\.\d+\.\d+\.\d+|::1|0:0:0:0:0:0:0:1|192\.168\.1\.\d+" />
</Context>
```
### Aplicar lo mismo al Host Manager:
Aplicamos la misma modificación que hicimos en `manager.xml`.

```bash
sudo nano /etc/tomcat10/Catalina/localhost/host-manager.xml
```
### Debe de quedar así
![Seguridad_tomcat_4](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/tomcat_seguridad_4.png)


### Reiniciar Tomcat después de los cambios:

```bash
sudo systemctl restart tomcat10
```

### Verificamos el acceso:

Accedemos a las aplicaciones desde el navegador:

- **Manager App:** `http://tu-servidor:8080/manager/html`
  ### Debe salir esto
  ![Seguridad_Tomcat_5](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/Seguridad_Tomcat_Seguridad_5.png)



 ## 3. Configurar HTTPS con keystore y conector SSL
 Habilitar conexiones cifradas (HTTPS) en Tomcat usando un certificado autofirmado.
 
 **Pasos a seguir:**
  1. Crear keystore con `keytool`, almacena certificado privado.
  2. Configurar conector SSL en `server.xml`, escucha puerto 8443.
  3. Resultado: Acceso seguro por `https://localhost:8443/`.

Ejecutamos el siguiente comando

```bash
sudo keytool -genkeypair -alias tomcat -keyalg RSA -keysize 3072 -keystore /etc/tomcat10/keystore.jks -storepass changeit -keypass changeit -validity 90 -dname "CN=localhost, OU=DAW, O=IES, L=CiudadReal, S=CLM, C=ES"
```
y deberia salir

![Configurar_HTTPS_1](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/Configurar_SSL_1.png)

cambiamos lo permisos para que keystore pueda acceder
![Configurar_HTPPS_2](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/permiso_1.png)
     
