#!/bin/sh

# Verify that the AZ_RESOURCE_GROUP environment variable is defined
if [ -z "$AZ_RESOURCE_GROUP" ]; then
    echo "Error: The AZ_RESOURCE_GROUP environment variable is not defined."
    exit 1
fi

# Confirm the deletion of the resource group
echo "You are about to delete the resource group: $AZ_RESOURCE_GROUP"
read -p "Are you sure? This action cannot be undone. (yes/no): " confirm

# Convert the response to lowercase to facilitate comparison
confirm=$(echo "$confirm" | tr '[:upper:]' '[:lower:]')

# Check if the response is a form of "yes"
if [ "$confirm" != "yes" ] && [ "$confirm" != "y" ] && [ "$confirm" != "sí" ] && [ "$confirm" != "s" ]; then
    echo "Operation canceled."
    exit 0
fi

# Deleting resource group
echo "Deleting resource group: $AZ_RESOURCE_GROUP"

az group delete \
    --name $AZ_RESOURCE_GROUP \
    --yes \
    --no-wait

echo "Resource group deletion initiated. This may take a few minutes."