#!/bin/sh

# Destruyendo grupo de recursos
echo "Destruyendo grupo de recursos"

az group delete \
    --name $AZ_RESOURCE_GROUP \
    --yes