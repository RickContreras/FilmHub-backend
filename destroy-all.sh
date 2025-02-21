#!/bin/sh

# Verificar que la variable de entorno AZ_RESOURCE_GROUP esté definida
if [ -z "$AZ_RESOURCE_GROUP" ]; then
    echo "Error: La variable de entorno AZ_RESOURCE_GROUP no está definida."
    exit 1
fi

# Confirmar la eliminación del grupo de recursos
echo "Estás a punto de eliminar el grupo de recursos: $AZ_RESOURCE_GROUP"
read -p "¿Estás seguro? Esta acción no se puede deshacer. (sí/no): " confirm

if [ "$confirm" != "sí" ]; then
    echo "Operación cancelada."
    exit 0
fi

# Destruyendo grupo de recursos
echo "Destruyendo grupo de recursos: $AZ_RESOURCE_GROUP"

az group delete \
    --name $AZ_RESOURCE_GROUP \
    --yes \
    --no-wait

echo "Eliminación del grupo de recursos iniciada. Esto puede tardar unos minutos."