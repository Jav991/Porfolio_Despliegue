![Portada](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/Filezilla/Instalaci%C3%B3n%20y%20configuraci%C3%B3n%20inicial%20del%20servidor/portada.png)

# Práctica 2 — Instalación y configuración inicial de FileZilla Server

---

## Introducción

En esta práctica he realizado la instalación y configuración inicial de FileZilla Server con el objetivo de poner en funcionamiento un servidor FTP. 

He configurado el puerto de escucha, la dirección IP y el inicio automático del servicio. Finalmente, he verificado el funcionamiento del servidor mediante pruebas desde consola y desde un cliente FTP.

---

## Índice

1. Instalación de FileZilla Server  
2. Acceso a la consola de administración  
3. Configuración inicial  
   - 3.1 Puerto de escucha  
   - 3.2 Dirección IP  
   - 3.3 Inicio automático del servicio  
4. Verificación del servicio  
5. Conclusión  

---

## 1. Instalación de FileZilla Server

Primero descargué e instalé FileZilla Server configurándolo como servicio del sistema con inicio automático con el siguiente comando.
Descragé el archivo desde su página web [web_Filezilla](https://filezilla-project.org/download.php?type=server)

![Descarga_Filezilla](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/Filezilla/Instalaci%C3%B3n%20y%20configuraci%C3%B3n%20inicial%20del%20servidor/descarga_FIlezilla.png)

```bash
  sudo apt update && sudo dpkg -i FileZilla_Server_1.12.3_x86_64-linux-gnu.deb
```
Durante la instalación, el sistema mostrará un asistente de configuración solicitando  una contraseña de administrador. Es muy recomendable establecer una contraseña segura, 
ya que sin ella no podremos administrar FileZilla Server de forma remota.
![Instalación_Filezilla](https://github.com/Jav991/Porfolio_Despliegue/blob/main/img/Filezilla/Instalaci%C3%B3n%20y%20configuraci%C3%B3n%20inicial%20del%20servidor/Configuraci%C3%B3n_FIlezilla.png)

Para comprobar que el servicio está activo ejecuté:

```bash
systemctl status filezilla-server
```

