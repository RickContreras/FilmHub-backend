# Configuración de la Base de Datos para FilmHub

Este documento proporciona instrucciones detalladas para configurar la infraestructura de la base de datos para el proyecto FilmHub.

## Requisitos Previos

Antes de comenzar, asegúrate de tener instalados los siguientes componentes:

1. **Azure CLI**: Herramienta de línea de comandos para gestionar recursos de Azure.
    - **Instalación**:
        - **Windows**: [Instrucciones de instalación](https://docs.microsoft.com/es-es/cli/azure/install-azure-cli-windows)
        - **macOS**: [Instrucciones de instalación](https://docs.microsoft.com/es-es/cli/azure/install-azure-cli-macos)
        - **Linux**: [Instrucciones de instalación](https://docs.microsoft.com/es-es/cli/azure/install-azure-cli-linux)

2. **Maven**: Herramienta de gestión y comprensión de proyectos de software.
    - **Instalación**:
        - **Windows**: [Instrucciones de instalación](https://maven.apache.org/install.html)
        - **macOS**: `brew install maven`
        - **Linux**: `sudo apt-get install maven`

3. **Java Development Kit (JDK)**: Necesario para compilar y ejecutar el proyecto.
    - **Instalación**:
        - **Windows**: [Instrucciones de instalación](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
        - **macOS**: `brew install openjdk@21`
        - **Linux**: `sudo apt-get install openjdk-21-jdk`

## Configuración de Variables de Entorno

Crea un archivo `env.sh` para definir las siguientes variables de entorno:

```sh
#!/bin/sh

echo "Estableciendo variables de entorno"

export AZ_RESOURCE_GROUP=filmhub-backend
export AZ_DATABASE_NAME=filmhub-server
export AZ_LOCATION=australiaeast
export AZ_SQL_SERVER_USERNAME=spring
export AZ_SQL_SERVER_PASSWORD=XXXXXXXXXXXXXXXXXX
export AZ_LOCAL_IP_ADDRESS=$(curl -s https://api.ipify.org)

export SPRING_DATASOURCE_URL="jdbc:sqlserver://$AZ_DATABASE_NAME.database.windows.net:1433;database=demo;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;"
export SPRING_DATASOURCE_USERNAME=spring@$AZ_DATABASE_NAME
export SPRING_DATASOURCE_PASSWORD=$AZ_SQL_SERVER_PASSWORD
```

Asegúrate de configurar un *AZ_DATABASE_NAME* único y una *AZ_SQL_SERVER_PASSWORD* correctamente asegurada.

# Creacion de la infraestructura


1. Iniciar sesión en Azure: 
```sh
az login
```

2. Agregar la extensión serviceconnector-passwordless:  

```sh
az extension add --name serviceconnector-passwordless --upgrade
```
3. Crear la infraestructura:  

```sh
source env.sh
./create-spring-data-jpa-sql-server.sh
```
4. Crear el usuario que no es administrador de Microsoft Entra:  

```sh
az connection create sql \
--resource-group $AZ_RESOURCE_GROUP \
--connection sql_conn \
--target-resource-group $AZ_RESOURCE_GROUP \
--server $AZ_DATABASE_NAME \
--database demo \
--user-account \
--query authInfo.userName \
--output tsv
```
# Destrucción de la Infraestructura
Para eliminar la infraestructura creada, ejecuta el siguiente comando:
    
    ```sh
        ./destroy-spring-data-jpa-sql-server.sh
    ```

# Compilación y Ejecución del Proyecto
Para compilar y ejecutar el proyecto, utiliza Maven:

```sh
./mvnw spring-boot:run
```

Para mayor información mirar el siguiente [link](https://learn.microsoft.com/es-es/azure/developer/java/spring-framework/configure-spring-data-jpa-with-azure-sql-server?tabs=passwordless)