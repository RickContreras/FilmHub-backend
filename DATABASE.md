### Creando la infraestructura

Se recomienda crear `env.sh` para definir las siguientes variables de entorno:

```sh
#!/bin/sh

echo "Estableciendo variables de entorno"

export AZ_RESOURCE_GROUP=FilmHub
export AZ_DATABASE_NAME=filmhub
export AZ_LOCATION=eastus
export AZ_SQL_SERVER_USERNAME=postgres
export AZ_SQL_SERVER_PASSWORD=root1
export AZ_LOCAL_IP_ADDRESS=$(curl -s https://api.ipify.org)

export SPRING_DATASOURCE_URL="jdbc:sqlserver://$AZ_DATABASE_NAME.database.windows.net:1433;database=demo;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;"
export SPRING_DATASOURCE_USERNAME=spring@$AZ_DATABASE_NAME
export SPRING_DATASOURCE_PASSWORD=$AZ_SQL_SERVER_PASSWORD
```

Se necesitara configurar un *AZ_DATABASE_NAME* único así como una *AZ_SQL_SERVER_PASSWORD* correctamente asegurada.

Una vez que este archivo esté creado:

Usa source env.sh para establecer esas variables de entorno.
Usa ./create-spring-data-jpa-sql-server.sh para crear tu infraestructura.
Usa ./destroy-spring-data-jpa-sql-server.sh para eliminar tu infraestructura.

Para mayor información mirar el siguiente [link](https://learn.microsoft.com/es-es/azure/developer/java/spring-framework/configure-spring-data-jpa-with-azure-sql-server?tabs=passwordless)