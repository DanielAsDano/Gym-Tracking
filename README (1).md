#  Gym Tracking — Spring Boot

Reescritura del proyecto [Gym Tracking](https://github.com/) usando **Spring Boot + MySQL**. Aplicación de consola para gestionar ejercicios de gimnasio y llevar seguimiento de peso y repeticiones por ejercicio.

> ⚠️ Proyecto en desarrollo activo.

---

## Estructura del proyecto

```
gym_track.gymtrackingspring/
├── model/
│   ├── Ejercicio.java
│   ├── GrupoMuscular.java
│   └── Registro.java
├── repository/
│   ├── IEjercicioRepository.java
│   ├── IGrupoMuscularRepository.java
│   └── IRegistroRepository.java
├── service/
│   ├── IEjercicioService.java      / EjercicioService.java
│   ├── IGrupoMuscularService.java  / GrupoMuscularService.java
│   ├── IRegistroService.java       / RegistroService.java
└── GymTrackingSpringApplication.java
```

---

##  Tecnologías

- **Java 17+**
- **Spring Boot 3**
- **Spring Data JPA** — abstracción del acceso a datos vía `JpaRepository`
- **MySQL** como base de datos
- **Lombok** — reduce boilerplate en los modelos (`@Data`, `@NoArgsConstructor`, etc.)
- **SLF4J** — logging

---

## Configuración y ejecución

### 1. Clona el repositorio

```bash
git clone https://github.com/tu-usuario/gym-tracking-spring.git
cd gym-tracking-spring
```

### 2. Configura la base de datos

Copia el archivo de ejemplo y rellena tus credenciales:

```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```

Edita `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gymtrack
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Crea la base de datos

Ejecuta el esquema en MySQL Workbench o desde la terminal (ver sección [Esquema](#-esquema-de-la-base-de-datos)).

### 4. Ejecuta el proyecto

```bash
./mvnw spring-boot:run
```

---

##  Esquema de la base de datos

```sql
CREATE DATABASE IF NOT EXISTS gymtrack;
USE gymtrack;

CREATE TABLE `grupos_musculares` (
  `id_grupo_muscular` int NOT NULL AUTO_INCREMENT,
  `nombre_grupo_muscular` varchar(45) NOT NULL,
  PRIMARY KEY (`id_grupo_muscular`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `ejercicios` (
  `id_ejercicio` int NOT NULL AUTO_INCREMENT,
  `nombre_ejercicio` varchar(45) NOT NULL,
  `id_grupo_muscular` int DEFAULT NULL,
  PRIMARY KEY (`id_ejercicio`),
  KEY `id_grupo_muscular_idx` (`id_grupo_muscular`),
  CONSTRAINT `id_grupo_muscular` FOREIGN KEY (`id_grupo_muscular`) REFERENCES `grupos_musculares` (`id_grupo_muscular`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `registros` (
  `id_registro` int NOT NULL AUTO_INCREMENT,
  `peso` double NOT NULL,
  `repeticiones` int NOT NULL,
  `id_ejercicio` int DEFAULT NULL,
  PRIMARY KEY (`id_registro`),
  KEY `id_ejercicio_idx` (`id_ejercicio`),
  CONSTRAINT `id_ejercicio` FOREIGN KEY (`id_ejercicio`) REFERENCES `ejercicios` (`id_ejercicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```

---

##  Arquitectura

El proyecto sigue una arquitectura en capas estándar de Spring Boot:

| Capa | Responsabilidad |
|---|---|
| **Model** | Entidades JPA mapeadas a tablas de MySQL |
| **Repository** | Interfaces que extienden `JpaRepository` — Spring genera las queries automáticamente |
| **Service** | Lógica de negocio; las operaciones de registro (peso/reps) viven aquí |
| **Application** | Punto de entrada; implementa `CommandLineRunner` para el flujo de consola |

---

## Funcionalidades implementadas

### Ejercicios
- [x] Listar todos
- [x] Buscar por ID
- [x] Guardar / actualizar
- [x] Eliminar

### Grupos musculares
- [x] Listar todos
- [x] Buscar por ID

### Registro
- [x] Guardar registro
- [x] Aumentar / disminuir peso (± 0.5 kg)
- [x] Aumentar / disminuir repeticiones (± 1)

### Interfaz de consola
- [ ] Menú principal (en desarrollo en `GymTrackingSpringApplication.run()`)

---

## Relación con la versión anterior

Este proyecto es una reescritura de la versión original en Java puro con SQLite y el patrón DAO manual. Las diferencias principales son:

| | v1 (original) | v2 (este proyecto) |
|---|---|---|
| Base de datos | SQLite (archivo local) | MySQL |
| Acceso a datos | DAO manual con JDBC | Spring Data JPA |
| Inyección de dependencias | Manual | Spring IoC (`@Autowired`) |
| Modelos | POJOs con constructores manuales | Lombok (`@Data`, etc.) |
| Build | Proyecto Java plano | Maven + Spring Boot |
