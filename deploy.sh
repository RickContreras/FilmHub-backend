#!/bin/sh

# Crear plan de App Service
echo "Creando plan de App Service"
az appservice plan create --name filmhub-backend-plan --resource-group $AZ_RESOURCE_GROUP --sku B1 --is-linux

# Crear aplicación web
echo "Creando aplicación web"
az webapp create --resource-group $AZ_RESOURCE_GROUP --plan filmhub-backend-plan --name filmhub-backend-app --runtime "JAVA|21-java21"

# Configurar variables de entorno en la aplicación web
echo "Configurando variables de entorno en la aplicación web"
az webapp config appsettings set --resource-group $AZ_RESOURCE_GROUP --name filmhub-backend-app --settings \
    AZ_RESOURCE_GROUP=$AZ_RESOURCE_GROUP \
    AZ_DATABASE_NAME=$AZ_DATABASE_NAME \
    AZ_LOCATION=$AZ_LOCATION \
    AZ_SQL_SERVER_USERNAME=$AZ_SQL_SERVER_USERNAME \
    AZ_SQL_SERVER_PASSWORD=$AZ_SQL_SERVER_PASSWORD \
    SPRING_DATASOURCE_URL=$SPRING_DATASOURCE_URL \
    SPRING_DATASOURCE_USERNAME=$SPRING_DATASOURCE_USERNAME \
    SPRING_DATASOURCE_PASSWORD=$SPRING_DATASOURCE_PASSWORD

# Empaquetar la aplicación
echo "Empaquetando la aplicación"
./mvnw clean package

# Desplegar la aplicación
echo "Desplegando la aplicación"
az webapp deploy --resource-group $AZ_RESOURCE_GROUP --name filmhub-backend-app --src-path target/filmhub-0.0.1-SNAPSHOT.jar --type jar

# Verificar el despliegue
echo "Verificando el despliegue"
echo "Abre tu navegador y navega a https://filmhub-backend-app.azurewebsites.net para verificar que tu aplicación esté funcionando"