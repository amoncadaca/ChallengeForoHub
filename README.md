# ChallengeForoHub

Foro Hub es una API REST desarrollada en **Spring Boot** para la gestión de tópicos en un foro. Este proyecto incluye funcionalidades CRUD, validaciones, seguridad con autenticación JWT y una base de datos relacional.

---

## Tecnologías utilizadas

- **Java JDK**: 17+
- **Spring Boot**: 3+
- **Maven**: 4+
- **MySQL**: 8+
- **JWT (JSON Web Token)**
- **Lombok**

---

## Funcionalidades principales

1. **Crear un nuevo tópico**
   - Endpoint: `POST /topicos`
   - Requiere datos como título, mensaje, autor y curso en formato JSON.
2. **Listar todos los tópicos**
   - Endpoint: `GET /topicos`
   - Soporte para paginación y filtros opcionales.
3. **Mostrar un tópico específico**
   - Endpoint: `GET /topicos/{id}`.
4. **Actualizar un tópico**
   - Endpoint: `PUT /topicos/{id}`.
5. **Eliminar un tópico**
   - Endpoint: `DELETE /topicos/{id}`.

### Seguridad

- Implementación de autenticación y autorización con **Spring Security** y **JWT**.
- Solo usuarios autenticados pueden interactuar con la API.

---

## Configuración del entorno

1. **Instalaciones necesarias**:
   - Java JDK 17+
   - Maven 4+
   - MySQL 8+
   - IntelliJ IDEA (opcional)

2. **Configuración del proyecto con Spring Initializr**:
   - Dependencias necesarias:
     - Spring Web
     - Spring Boot DevTools
     - Spring Data JPA
     - Flyway Migration
     - MySQL Driver
     - Validation
     - Lombok
     - Spring Security

3. **Archivo `application.properties`**:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

   spring.jpa.hibernate.ddl-auto=validate
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

   jwt.secret=tu_secreto_jwt
   jwt.expiration=86400000
   ```

---

## Ejecución del proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/amoncadaca/ChallengeForoHub.git
   ```

2. Navega al directorio del proyecto:
   ```bash
   cd foro-hub
   ```

3. Ejecuta el proyecto con Maven:
   ```bash
   mvn spring-boot:run
   ```

---

## Endpoints principales

### Crear un nuevo tópico
```http
POST /topicos
```
**Body**:
```json
{
  "titulo": "Aprendiendo Spring Boot",
  "mensaje": "Un gran framework para APIs REST",
  "autor": "Juan Pérez",
  "curso": "Java Backend"
}
```

### Listar todos los tópicos
```http
GET /topicos
```

### Mostrar un tópico específico
```http
GET /topicos/{id}
```

### Actualizar un tópico
```http
PUT /topicos/{id}
```
**Body**:
```json
{
  "titulo": "Título actualizado",
  "mensaje": "Mensaje actualizado",
  "autor": "Juan Pérez",
  "curso": "Java Backend"
}
```

### Eliminar un tópico
```http
DELETE /topicos/{id}
```

---

## Autenticación

1. Solicita un token JWT:
   ```http
   POST /login
   ```
   **Body**:
   ```json
   {
     "username": "usuario",
     "password": "contraseña"
   }
   ```

2. Agrega el token JWT en el encabezado de las solicitudes:
   ```http
   Authorization: Bearer <tu_token_jwt>
   ```

---

## Migraciones con Flyway

Define las tablas y datos iniciales en archivos SQL dentro del directorio `src/main/resources/db/migration`.

Ejemplo: `V1__crear_tabla_topicos.sql`
```sql
CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    autor VARCHAR(255) NOT NULL,
    curso VARCHAR(255) NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(50) DEFAULT 'ACTIVO',
    UNIQUE (titulo, mensaje)
);
```

---

## Pruebas

Utiliza herramientas como Postman o Insomnia para probar los endpoints.

### Ejemplo de prueba con Postman:
1. Genera un token JWT con `POST /login`.
2. Usa el token en el encabezado `Authorization` para realizar solicitudes a los endpoints protegidos.

---

## Mejoras futuras

- Implementar búsquedas avanzadas (por curso, fecha, etc.).
- Agregar soporte para paginación.
- Mejorar la validación de datos y manejo de errores.
- Añadir tests unitarios y de integración.

---

## Contribuciones

¡Las contribuciones son bienvenidas! Por favor, crea un _fork_ del repositorio y abre un _pull request_.

---

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más información.
