# Gym Tracking

Aplicación de consola en Java para registrar y gestionar ejercicios de gimnasio. Permite llevar control de ejercicios por grupo muscular y hacer seguimiento del peso y repeticiones de cada uno.

---

## Estructura del proyecto

```
gym_tracking/
├── Main.java
├── conexion/
│   └── Conexion.java              # Gestión de conexión a SQLite
├── datos/
│   ├── IEjercicioDAO.java
│   ├── EjercicioDAO.java          # CRUD de ejercicios
│   ├── IGrupoMuscularDAO.java
│   ├── GrupoMuscularDAO.java      # Consulta de grupos musculares
│   ├── IRegistroDAO.java
│   └── RegistroDAO.java           # Gestión de registros (peso/reps)
├── dominio/
│   ├── Ejercicio.java
│   ├── GrupoMuscular.java
│   └── Registro.java
└── interfaz/
    └── Interfaz.java              # Menú de consola
```

---

## Tecnologías

- **Java** (17+ recomendado)
- **SQLite** como base de datos local
- **JDBC** para la conexión a la base de datos
- Sin frameworks externos (proyecto vanilla)

---

## Base de datos

La base de datos SQLite se espera en la ruta `db/gym_tracking.db` relativa al directorio de ejecución. Debe contener las siguientes tablas:

```sql
CREATE TABLE grupos_musculares (
    id    INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL
);

CREATE TABLE ejercicios (
    id_ejercicio   INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre_ejercicio TEXT NOT NULL,
    id_grupo       INTEGER,
    FOREIGN KEY (id_grupo) REFERENCES grupos_musculares(id)
);

CREATE TABLE registros (
    id_registro  INTEGER PRIMARY KEY AUTOINCREMENT,
    id_ejercicio INTEGER,
    peso         REAL DEFAULT 0,
    repeticiones INTEGER DEFAULT 0,
    FOREIGN KEY (id_ejercicio) REFERENCES ejercicios(id_ejercicio)
);
```

---

## Cómo ejecutar

1. Clona el repositorio y abre el proyecto en tu IDE (IntelliJ recomendado).
2. Asegúrate de tener el driver JDBC de SQLite en el classpath (por ejemplo, `sqlite-jdbc-x.x.x.jar`).
3. Crea la carpeta `db/` en la raíz del proyecto y coloca ahí el archivo `gym_tracking.db` con las tablas creadas.
4. Ejecuta `Main.java`.

---

## Funcionalidades

### Ejercicios
| Opción | Acción |
|--------|--------|
| 1 | Listar todos los ejercicios |
| 2 | Buscar ejercicio por ID |
| 3 | Agregar ejercicio (nombre + grupo muscular) |
| 4 | Modificar nombre de un ejercicio |
| 5 | Eliminar ejercicio |

### Grupos musculares
| Opción | Acción |
|--------|--------|
| 6 | Listar todos los grupos musculares |

### Registro de ejercicio
| Opción | Acción |
|--------|--------|
| 1 | Aumentar peso en 1 kg |
| 2 | Disminuir peso en 1 kg |
| 3 | Aumentar peso personalizado |
| 4 | Disminuir peso personalizado |
| 5 | Aumentar repeticiones en 1 |
| 6 | Disminuir repeticiones en 1 |
| 7 | Aumentar repeticiones personalizado |
| 8 | Disminuir repeticiones personalizado |

---

## Arquitectura

El proyecto sigue el patrón **DAO (Data Access Object)**, separando claramente las responsabilidades:

- **`dominio/`** — Modelos de datos (`Ejercicio`, `GrupoMuscular`, `Registro`).
- **`datos/`** — Interfaces DAO e implementaciones con acceso directo a la base de datos vía JDBC.
- **`conexion/`** — Clase utilitaria estática para obtener la conexión SQLite.
- **`interfaz/`** — Lógica de presentación y flujo de la aplicación en consola.

---

## Notas

- Este proyecto es la versión original (v1). Existe una reescritura en progreso usando **Spring Boot** con una arquitectura diferente.
- El campo `baseDatos` en `Conexion.java` está declarado pero no se utiliza; la URL de conexión está hardcodeada directamente.
