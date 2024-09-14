# Usar una imagen base de Java
FROM mcr.microsoft.com/vscode/devcontainers/java:0-21

# Instalar Maven
RUN apt-get update && apt-get install -y maven

# Instalar PostgreSQL
RUN apt-get update && apt-get install -y postgresql postgresql-contrib

# Configurar PostgreSQL
USER postgres
RUN /etc/init.d/postgresql start &&\
    psql --command "CREATE USER dev WITH SUPERUSER PASSWORD 'dev';" &&\
    createdb -O dev filmhub

# Exponer el puerto de la aplicación
EXPOSE 8090

# Establecer el usuario de vuelta a vscode
USER vscode