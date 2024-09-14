# 📽️ Filmhub - Backend

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.3-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-42.7.3-blue)
![Maven](https://img.shields.io/badge/Maven-3.9.9-red)

Este proyecto es una aplicación **REST API** creada con **Spring Boot** que permite gestionar contenido audiovisual (películas, series, recomendaciones, usuarios, etc.) usando una base de datos **Azure SQL**.

## 🚀 Descripción

Filmhub es una aplicación que permite a los usuarios gestionar y visualizar contenido audiovisual. Los usuarios pueden registrarse, agregar contenido a su lista y marcar contenido como visto o no visto.



## 🛠️ Tecnologías Utilizadas

- **Spring Boot**: Framework para desarrollar aplicaciones Java de manera rápida.
- **Spring Data JPA**: Módulo para interactuar con bases de datos relacionales usando JPA/Hibernate.
- **Azure SQL Database**: Base de datos en la nube proporcionada por Microsoft Azure.
- **Maven**: Sistema de gestión de dependencias y construcción de proyectos.
- **Postman**: Para probar las API expuestas.

## 📂 Estructura del Proyecto

La estructura del proyecto sigue las mejores prácticas de Spring Boot, dividiendo la lógica en capas como controladores, modelos, repositorios, y más.

```bash
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── udea/
│   │           └── filmhub/  # Paquete base
│   │               ├── controller/
│   │               ├── exceptions/  
│   │               ├── model/        # Entidades JPA (tablas)
│   │               ├── repository/   # Repositorios JPA
│   │               ├── service/      # Servicios (lógica de negocio)
│   │               └── FilmhubApplication.java      
│   └── resources/
│       ├── static/                   # Archivos estáticos (si es necesario)
│       ├── templates/                # Plantillas Thymeleaf (si usas vistas)
│       ├── application-dev.properties 
│       ├── application-pdn.properties
│       └── application.properties    # Configuración de la base de datos y otros
└── test/                             # Pruebas unitarias e integración
```

### 📂 Descripción de carpetas

1. **`controller/`**: Contiene los controladores REST que manejan las peticiones HTTP y exponen los endpoints de la API. Cada controlador corresponde a una entidad (por ejemplo, `UsuarioController` para gestionar usuarios).

2. **`model/`**: Define las entidades JPA que representan las tablas en la base de datos. Cada entidad contiene atributos y relaciones mapeadas desde el modelo de datos, como `Usuario`, `ContenidoAudiovisual`, `Recomendacion`, etc.

3. **`repository/`**: Contiene las interfaces que extienden `JpaRepository` para interactuar con la base de datos. Estos repositorios permiten realizar operaciones CRUD sobre las entidades.

4. **`service/`** *(opcional)*: Aquí se puede colocar la lógica de negocio. Si alguna operación en tu API requiere más procesamiento o lógica compleja, se puede implementar en los servicios.

5. **`resources/`**:
    - **`application.properties`**: Archivo de configuración principal. Contiene las propiedades de la aplicación, como la conexión a la base de datos, el puerto del servidor, etc.
    - **`static/`** y **`templates/`**: Estas carpetas solo se usarían si tu aplicación incluye una parte de frontend como archivos HTML o plantillas Thymeleaf, pero en una API REST estas pueden no ser necesarias.

6. **`test/`**: Carpeta para pruebas unitarias e integración de los componentes del proyecto.

## 📦 Dependencias Principales

Estas son algunas de las dependencias más importantes utilizadas en el proyecto, las cuales están incluidas en el archivo `pom.xml`:

- **Spring Boot Starter Web**: Para crear aplicaciones web y exponer REST APIs.
- **Spring Boot Starter Data JPA**: Para realizar operaciones con bases de datos usando JPA/Hibernate.
- **Microsoft SQL Server JDBC Driver**: Para conectar con Azure SQL Database.
- **Lombok** *(En consideración)*: Simplifica el código eliminando la necesidad de escribir getters, setters, etc.
- **Spring Boot DevTools** *(En consideración)*: Permite reinicios automáticos durante el desarrollo.

```xml
<dependencies>
    <!-- Dependencia de Spring Web para hacer tu aplicación RESTful -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Dependencia de Spring Data JPA para interactuar con la base de datos -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- Driver de conexión a SQL Server (Azure SQL Database) -->
    <dependency>
        <groupId>com.microsoft.sqlserver</groupId>
        <artifactId>mssql-jdbc</artifactId>
        <version>9.4.0.jre8</version>
    </dependency>

    <!-- Lombok (opcional, para simplificar getters y setters) -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <scope>provided</scope>
    </dependency>

    <!-- Spring Boot DevTools (opcional, para reinicios automáticos en desarrollo) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

## ⚙️ Configuración de la Base de Datos en Azure SQL

El archivo `application.properties` incluye la configuración para conectar tu aplicación Spring Boot con Azure SQL Database.

```properties
# Datos de conexión para Azure SQL Database
spring.datasource.url=jdbc:sqlserver://<nombre-servidor>.database.windows.net:1433;database=<nombre-base-datos>
spring.datasource.username=<tu-usuario>
spring.datasource.password=<tu-contraseña>
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver

# Configuración de JPA y Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServer2012Dialect
```

### Configuración requerida:

1. Reemplaza `<nombre-servidor>`, `<nombre-base-datos>`, `<tu-usuario>` y `<tu-contraseña>` con los valores correctos de tu base de datos en Azure.
2. Asegúrate de que tu firewall en Azure esté configurado para permitir conexiones desde tu máquina local o servicio donde esté desplegada la aplicación.

## ⚙️ Configuración del Entorno

1. **Clonar el repositorio:**

    ```bash
    git clone https://github.com/RickContreras/FilmHub-backend.git
    cd FilmHub-backend
    ```

2. **Configurar la base de datos:**

   Asegúrate de tener PostgreSQL instalado y ejecutándose. Luego, crea una base de datos llamada `filmhub`.

    ```sql
    CREATE DATABASE filmhub;
    ```

3. **Configurar las propiedades de la aplicación:**

   Edita el archivo `src/main/resources/application-dev.properties` con las credenciales de tu base de datos:

    ```ini
    spring.datasource.url=jdbc:postgresql://localhost:5432/filmhub
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    ```

4. **Construir y ejecutar la aplicación:**

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

   La aplicación estará disponible en `http://localhost:8090`.
 

5. **Prueba la API**: Puedes usar **Postman** o **cURL** para interactuar con los endpoints de la API.

   Ejemplo para obtener todos los usuarios:

   ```bash
   GET http://localhost:8090/api/usuarios
   ```


## 🧪 Pruebas

Las pruebas unitarias y de integración pueden ser ejecutadas desde la carpeta `test/`. Para ejecutar las pruebas, usa:

```bash
mvn test
```

## 📡 Endpoints

- **GET /contenidos**: Obtiene todos los contenidos.
- **GET /contenidos/{id}**: Obtiene un contenido por ID.
- **GET /usuarios/{id}/contenidos**: Obtiene los contenidos asociados a un usuario.

## 🤝 Contribuir

1. **Fork el repositorio**
2. **Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`)**
3. **Haz commit de tus cambios (`git commit -am 'Añadir nueva funcionalidad'`)**
4. **Haz push a la rama (`git push origin feature/nueva-funcionalidad`)**
5. **Abre un Pull Request**

## 🔒 Seguridad

Este proyecto aún no incluye seguridad, pero se podría integrar fácilmente con **Spring Security** para proteger ciertos endpoints con autenticación y autorización.



