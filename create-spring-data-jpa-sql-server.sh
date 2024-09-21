#!/bin/sh

echo "Creando recursos en la nube..."

echo "-----------------------------------------------------"
echo "Usando variables de entorno:"
echo "AZ_RESOURCE_GROUP=$AZ_RESOURCE_GROUP"
echo "AZ_DATABASE_NAME=$AZ_DATABASE_NAME"
echo "AZ_LOCATION=$AZ_LOCATION"
echo "AZ_SQL_SERVER_USERNAME=$AZ_SQL_SERVER_USERNAME"
echo "AZ_SQL_SERVER_PASSWORD=$AZ_SQL_SERVER_PASSWORD"
echo "AZ_LOCAL_IP_ADDRESS=$AZ_LOCAL_IP_ADDRESS"

echo "SPRING_DATASOURCE_URL=$SPRING_DATASOURCE_URL"
echo "SPRING_DATASOURCE_USERNAME=$SPRING_DATASOURCE_USERNAME"
echo "SPRING_DATASOURCE_PASSWORD=$SPRING_DATASOURCE_PASSWORD"
echo "-----------------------------------------------------"

# Verificar que todas las variables de entorno estén definidas
if [ -z "$AZ_RESOURCE_GROUP" ] || [ -z "$AZ_DATABASE_NAME" ] || [ -z "$AZ_LOCATION" ] || [ -z "$AZ_SQL_SERVER_USERNAME" ] || [ -z "$AZ_SQL_SERVER_PASSWORD" ] || [ -z "$AZ_LOCAL_IP_ADDRESS" ]; then
    echo "Error: Una o más variables de entorno no están definidas."
    exit 1
fi

echo "Creando grupo de recursos"
echo "-----------------------------------------------------"
az group create \
    --name $AZ_RESOURCE_GROUP \
    --location $AZ_LOCATION \
    -o tsv
echo "-----------------------------------------------------"
echo "Creando instancia de servidor SQL"
echo "-----------------------------------------------------"

az sql server create \
    --resource-group $AZ_RESOURCE_GROUP \
    --name $AZ_DATABASE_NAME \
    --location $AZ_LOCATION \
    --admin-user $AZ_SQL_SERVER_USERNAME \
    --admin-password $AZ_SQL_SERVER_PASSWORD \
    -o tsv

echo "-----------------------------------------------------"
echo "Configurando firewall del servidor SQL"
echo "Permitiendo dirección IP local: $AZ_LOCAL_IP_ADDRESS"
echo "-----------------------------------------------------"

az sql server firewall-rule create \
    --resource-group $AZ_RESOURCE_GROUP \
    --name $AZ_DATABASE_NAME-database-allow-local-ip \
    --server $AZ_DATABASE_NAME \
    --start-ip-address $AZ_LOCAL_IP_ADDRESS \
    --end-ip-address $AZ_LOCAL_IP_ADDRESS \
    -o tsv

echo "-----------------------------------------------------"
echo "Configurando base de datos del servidor SQL"
echo "-----------------------------------------------------"

az sql db create \
    --resource-group $AZ_RESOURCE_GROUP \
    --name demo \
    --server $AZ_DATABASE_NAME \
    -o tsv

echo "-----------------------------------------------------"
echo "Recursos:"
echo "AZ_RESOURCE_GROUP=$AZ_RESOURCE_GROUP"
echo "AZ_DATABASE_NAME=$AZ_DATABASE_NAME"
echo "AZ_LOCATION=$AZ_LOCATION"
echo "AZ_SQL_SERVER_USERNAME=$AZ_SQL_SERVER_USERNAME"
echo "AZ_SQL_SERVER_PASSWORD=$AZ_SQL_SERVER_PASSWORD"
echo "AZ_LOCAL_IP_ADDRESS=$AZ_LOCAL_IP_ADDRESS"

echo "SPRING_DATASOURCE_URL=$SPRING_DATASOURCE_URL"
echo "SPRING_DATASOURCE_USERNAME=$SPRING_DATASOURCE_USERNAME"
echo "SPRING_DATASOURCE_PASSWORD=$SPRING_DATASOURCE_PASSWORD"
echo "-----------------------------------------------------"