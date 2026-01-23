![Portada](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/toncat/Tomcat_IntegracionWeb/Tomcat_Integracion_Servidor_Portada.jpg)

## 1. Definir roles y usuarios en `tomcat-users.xml`

Para permitir el acceso a las aplicaciones de administración de Tomcat, es necesario definir usuarios y roles en el archivo `tomcat-users.xml`, ubicado normalmente en:
```bash
  /opt/tomcat/conf/tomcat-users.xml
```
Tomcat define varios roles administrativos:

| Rol | Descripción |
|---|---|
| `manager-gui` | Acceso a la interfaz web de *Manager App* |
| `admin-gui` | Acceso a la interfaz web de *Host Manager* |
| `manager-script` | Acceso al Manager vía scripts (sin interfaz web) |
| `manager-jmx` | Acceso a la gestión vía JMX |
| `manager-status` | Permite consultar el estado del servidor |

Ejemplo de configuración:

```bash
  <tomcat-users>
      <role rolename="manager-gui"/>
      <role rolename="admin-gui"/>
      <user username="admin" password="TuPasswordSegura123" roles="manager-gui,admin-gui"/>
  </tomcat-users>
```

## 2. Restringir el acceso al Manager

Tomcat incluye dos aplicaciones de administración:

- **Manager App**
- **Host Manager**

Para mejorar la seguridad, Tomcat restringe por defecto el acceso a estas aplicaciones únicamente desde `localhost`.  
Esta restricción se implementa mediante una **Valve** en el archivo:

```bash
/opt/tomcat/webapps/manager/META-INF/context.xml
