# 📽️ Filmhub - Backend

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.3-brightgreen)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-3.2.5-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-42.7.3-blue)
![Maven](https://img.shields.io/badge/Maven-3.9.9-red)
![Codespaces](https://img.shields.io/badge/Codespaces-Enabled-blue?logo=github)
![Azure](https://img.shields.io/badge/Azure-Enabled-blue?logo=microsoft-azure)
![Azure SQL Database](https://img.shields.io/badge/Azure%20SQL%20Database-Enabled-blue?logo=microsoft-azure)

Una aplicación **REST API** robusta creada con **Spring Boot** para gestionar contenido audiovisual, utilizando **Azure SQL Database** o **PostgreSQL**.

## 📑 Tabla de Contenidos

- [🚀 Descripción](#-descripción)
- [🛠️ Tecnologías Utilizadas](#️-tecnologías-utilizadas)
- [📂 Estructura del Proyecto](#-estructura-del-proyecto)
- [📦 Dependencias Principales](#-dependencias-principales)
- [🔧 Configuración de Entorno](#-configuración-de-entorno)
  - [Azure SQL Database](#azure-sql-database)
  - [PostgreSQL](#postgresql)
- [🏗️ Creación de la Infraestructura](#️-creación-de-la-infraestructura)
- [💥 Destrucción de la Infraestructura](#-destrucción-de-la-infraestructura)
- [🚀 Compilación y Ejecución del Proyecto](#-compilación-y-ejecución-del-proyecto)
- [🧪 Pruebas](#-pruebas)
- [📡 Endpoints](#-endpoints)
- [🤝 Contribuir](#-contribuir)
- [🔒 Seguridad](#-seguridad)
- [📄 Licencia](#-licencia)

## 🚀 Descripción

Filmhub es una aplicación backend diseñada para ofrecer una experiencia completa en la gestión de contenido audiovisual. Permite a los usuarios:

- Registrarse y gestionar sus perfiles
- Explorar un catálogo extenso de películas y series
- Agregar contenido a listas personalizadas
- Marcar contenido como visto o no visto
- Recibir recomendaciones personalizadas basadas en sus preferencias

Esta API RESTful proporciona la base para construir aplicaciones frontend robustas y escalables en el dominio del streaming y la gestión de contenido multimedia.

## 🛠️ Tecnologías Utilizadas

- **Spring Boot**: Framework Java para desarrollo rápido de aplicaciones con configuración mínima.
- **Spring Data JPA**: Simplifica el acceso a datos utilizando el estándar JPA con Hibernate.
- **Azure SQL Database**: Base de datos relacional en la nube, totalmente administrada y con alta disponibilidad.
- **PostgreSQL**: Sistema de gestión de bases de datos relacional de código abierto.
- **Maven**: Herramienta de gestión y construcción de proyectos Java.
- **Postman**: Plataforma de colaboración para el desarrollo de API.
- **GitHub Codespaces**: Entorno de desarrollo en la nube integrado con GitHub.
- **Azure CLI**: Interfaz de línea de comandos para gestionar recursos de Azure.

## 📂 Estructura del Proyecto

La estructura del proyecto sigue las mejores prácticas de Spring Boot, dividiendo la lógica en capas como controladores, modelos, repositorios, y más.

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── udea/
│   │           └── filmhub/
│   │               ├── controller/
│   │               ├── exceptions/
│   │               ├── model/
│   │               ├── repository/
│   │               ├── service/
│   │               └── FilmhubApplication.java
│   └── resources/
│       ├── static/
│       ├── templates/
│       ├── application-dev.properties
│       ├── application-pdn.properties
│       └── application.properties
└── test/
```

### 📂 Descripción de carpetas

1. **`controller/`**: Controladores REST que manejan las peticiones HTTP y definen los endpoints de la API.
2. **`model/`**: Entidades JPA que representan las tablas en la base de datos.
3. **`repository/`**: Interfaces que extienden `JpaRepository` para operaciones CRUD.
4. **`service/`**: Implementación de la lógica de negocio.
5. **`exceptions/`**: Manejo personalizado de excepciones.
6. **`resources/`**: Archivos de configuración y recursos estáticos.
7. **`test/`**: Pruebas unitarias e integración.

## 📦 Dependencias Principales

- **Spring Boot Starter Web**: Configuración para aplicaciones web y REST.
- **Spring Boot Starter Data JPA**: Integración con JPA y Hibernate.
- **Microsoft SQL Server JDBC Driver**: Conector para Azure SQL Database.
- **PostgreSQL Driver**: Conector para PostgreSQL.
- **Lombok**: Reduce el boilerplate en el código Java.
- **Spring Boot Starter Test**: Soporte para pruebas unitarias e integración.

## 🔧 Configuración de Entorno

**Clona el repositorio:**

```bash
    git clone https://github.com/RickContreras/FilmHub-backend.git
    cd FilmHub-backend
```


### Azure SQL Database

1. Crea un archivo `env.sh`:

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

2. Configura un `AZ_DATABASE_NAME` único y una `AZ_SQL_SERVER_PASSWORD` segura.


### PostgreSQL

1. Instala y configura PostgreSQL.
2. Crea la base de datos:

```sql
CREATE DATABASE filmhub;
```

3. Configura `src/main/resources/application-dev.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/filmhub
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

## 🏗️ Creación de la Infraestructura

Para Azure SQL Database:

```sh
az login
az extension add --name serviceconnector-passwordless --upgrade
source env.sh
./create-spring-data-jpa-sql-server.sh
```

Crear usuario no administrador:

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

## 💥 Destrucción de la Infraestructura

Para eliminar la infraestructura de Azure:

```sh
./destroy-spring-data-jpa-sql-server.sh
```

## 🚀 Compilación y Ejecución del Proyecto

```sh
./mvnw clean install
./mvnw spring-boot:run
```

O usa el botón para abrir en GitHub Codespaces y ejecutalos para trabajar con PostgreSQL:

[![Abrir en Codespaces](https://github.com/codespaces/badge.svg)](https://github.com/codespaces/new?template_repository=RickContreras/filmhub-backend)

Nota: Si desea usar swagger en codespaces cambien lo siguiente en 'application-dev.properties'


 ```sh
swagger.server.url=https://la-url-de-su-codespace.dev/api
```

Ademas ponga el puerto "Publico" y en "http".

## 🧪 Pruebas

Ejecuta las pruebas con:

```sh
./mvnw test
```

## 📡 Endpoints

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/contenidos` | Obtiene todos los contenidos |
| GET | `/api/contenidos/{id}` | Obtiene un contenido por ID |
| GET | `/api/usuarios/{id}/contenidos` | Obtiene los contenidos de un usuario |
| POST | `/api/usuarios` | Crea un nuevo usuario |
| PUT | `/api/usuarios/{id}` | Actualiza un usuario existente |
| DELETE | `/api/usuarios/{id}` | Elimina un usuario |

(En desarrollo)

## 🤝 Contribuir

1. Fork el repositorio
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`)
3. Realiza tus cambios y haz commit (`git commit -am 'Añadir nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request

Por favor, asegúrate de actualizar las pruebas según sea necesario y sigue nuestro código de conducta.

## 🔒 Seguridad

Actualmente, este proyecto no implementa medidas de seguridad. Para un entorno de producción, se recomienda integrar:

- **Spring Security** para autenticación y autorización.
- **JWT** para manejo de tokens de sesión.
- **HTTPS** para encriptación de datos en tránsito.
- Implementar buenas prácticas como validación de entrada, manejo seguro de errores, y protección contra ataques comunes (CSRF, XSS, etc.).

---

Desarrollado con ❤️ por el equipo de Filmhub



