package gym_track.gymtrackingspring;

import gym_track.gymtrackingspring.model.Ejercicio;
import gym_track.gymtrackingspring.model.GrupoMuscular;
import gym_track.gymtrackingspring.model.Registro;
import gym_track.gymtrackingspring.service.IEjercicioService;
import gym_track.gymtrackingspring.service.IGrupoMuscularService;
import gym_track.gymtrackingspring.service.IRegistroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class GymTrackingSpringApplication implements CommandLineRunner {

    @Autowired
    private IEjercicioService ejercicioService;
    @Autowired
    private IGrupoMuscularService grupoMuscularService;
    @Autowired
    private IRegistroService registroService;

    public static final Logger logger = LoggerFactory.getLogger(GymTrackingSpringApplication.class);

    String nextLine = System.lineSeparator();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(GymTrackingSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        boolean salir = false;
        while (!salir) {
            int opcion = mostrarMenu(scanner);
            salir = opciones(opcion);
        }
    }

    private int mostrarMenu(Scanner scanner) {
        logger.info(nextLine + """
                ══════════════════════════════════════
                         GYM TRACKING APP
                ══════════════════════════════════════
                  --- EJERCICIOS ---
                  1. Listar ejercicios
                  2. Buscar ejercicio por ID
                  3. Agregar ejercicio
                  4. Eliminar ejercicio

                  --- GRUPOS MUSCULARES ---
                  5. Listar grupos musculares
                  6. Buscar grupo muscular por ID

                  --- REGISTROS ---
                  7. Crear registro
                  8. Modificar registro (peso / reps)

                  9. Salir
                ══════════════════════════════════════
                Elige una opción:\s""");

        return Integer.parseInt(scanner.nextLine());
    }

    private boolean opciones(int opcion) {
        switch (opcion) {

            // ── EJERCICIOS ──────────────────────
            case 1 -> {
                List<Ejercicio> ejercicios = ejercicioService.listarEjercicio();
                if (ejercicios.isEmpty()) {
                    logger.info(nextLine + "No hay ejercicios registrados.");
                } else {
                    logger.info(nextLine + "=== Lista de ejercicios ===");
                    ejercicios.forEach(e -> logger.info(
                            "  ID: {} | Nombre: {} | Grupo muscular ID: {}",
                            e.getId_ejercicio(), e.getNombre_ejercicio(), e.getId_grupo_muscular()
                    ));
                }
            }

            case 2 -> {
                logger.info(nextLine + "ID del ejercicio a buscar: ");
                int id = Integer.parseInt(scanner.nextLine());
                Ejercicio ejercicio = ejercicioService.buscarEjercicioPorID(id);
                if (ejercicio != null)
                    logger.info(nextLine + "Encontrado -> {}", ejercicio);
                else
                    logger.info(nextLine + "Ejercicio no encontrado.");
            }

            case 3 -> {
                logger.info(nextLine + "Nombre del ejercicio: ");
                String nombre = scanner.nextLine();

                // Mostrar grupos disponibles como ayuda
                List<GrupoMuscular> grupos = grupoMuscularService.listarGrupos();
                logger.info(nextLine + "Grupos musculares disponibles:");
                grupos.forEach(g -> logger.info("  ID: {} | {}", g.getId_grupo_muscular(), g.getNombre_grupo_muscular()));

                logger.info("ID del grupo muscular: ");
                int idGrupo = Integer.parseInt(scanner.nextLine());

                Ejercicio nuevo = new Ejercicio();
                nuevo.setNombre_ejercicio(nombre);
                nuevo.setId_grupo_muscular(idGrupo);
                ejercicioService.guardarEjercicio(nuevo);
                logger.info(nextLine + "Ejercicio agregado con éxito.");
            }

            case 4 -> {
                logger.info(nextLine + "ID del ejercicio a eliminar: ");
                int id = Integer.parseInt(scanner.nextLine());
                Ejercicio ejercicio = ejercicioService.buscarEjercicioPorID(id);
                if (ejercicio != null) {
                    ejercicioService.eliminarEjercicio(ejercicio);
                    logger.info(nextLine + "Ejercicio eliminado con éxito.");
                } else {
                    logger.info(nextLine + "Ejercicio no encontrado.");
                }
            }

            case 5 -> {
                List<GrupoMuscular> grupos = grupoMuscularService.listarGrupos();
                if (grupos.isEmpty()) {
                    logger.info(nextLine + "No hay grupos musculares registrados.");
                } else {
                    logger.info(nextLine + "=== Grupos musculares ===");
                    grupos.forEach(g -> logger.info(
                            "  ID: {} | Nombre: {}",
                            g.getId_grupo_muscular(), g.getNombre_grupo_muscular()
                    ));
                }
            }

            case 6 -> {
                logger.info(nextLine + "ID del grupo muscular a buscar: ");
                int id = Integer.parseInt(scanner.nextLine());
                GrupoMuscular grupo = grupoMuscularService.buscarGrupoPorId(id);
                if (grupo != null)
                    logger.info(nextLine + "Encontrado -> {}", grupo);
                else
                    logger.info(nextLine + "Grupo muscular no encontrado.");
            }

            case 7 -> {
                // Mostrar ejercicios disponibles
                List<Ejercicio> ejercicios = ejercicioService.listarEjercicio();
                logger.info(nextLine + "Ejercicios disponibles:");
                ejercicios.forEach(e -> logger.info("  ID: {} | {}", e.getId_ejercicio(), e.getNombre_ejercicio()));

                logger.info("ID del ejercicio: ");
                int idEjercicio = Integer.parseInt(scanner.nextLine());

                logger.info("Peso (kg): ");
                double peso = Double.parseDouble(scanner.nextLine());

                logger.info("Repeticiones: ");
                int reps = Integer.parseInt(scanner.nextLine());

                Registro registro = new Registro();
                registro.setId_ejercicio(idEjercicio);
                registro.setPeso(peso);
                registro.setRepeticiones(reps);
                registroService.guardarRegistro(registro);
                logger.info(nextLine + "Registro creado con éxito.");
            }

            case 8 -> {
                logger.info(nextLine + "ID del registro a modificar: ");
                int idRegistro = Integer.parseInt(scanner.nextLine());
                logger.info(nextLine + """
                        ¿Qué deseas modificar?
                          1. Aumentar repeticiones (+1)
                          2. Disminuir repeticiones (-1)
                          3. Aumentar peso (+0.5 kg)
                          4. Disminuir peso (-0.5 kg)
                        Opción:\s""");
                int subOpcion = Integer.parseInt(scanner.nextLine());

                Registro registro = new Registro();
                registro.setId_registro(idRegistro);

                logger.info("Peso actual del registro: ");
                registro.setPeso(Double.parseDouble(scanner.nextLine()));
                logger.info("Repeticiones actuales: ");
                registro.setRepeticiones(Integer.parseInt(scanner.nextLine()));
                logger.info("ID del ejercicio del registro: ");
                registro.setId_ejercicio(Integer.parseInt(scanner.nextLine()));

                switch (subOpcion) {
                    case 1 -> {
                        registroService.aumentarRepeticiones(registro);
                        logger.info(nextLine + "Repeticiones aumentadas.");
                    }
                    case 2 -> {
                        registroService.disminuirRepeticiones(registro);
                        logger.info(nextLine + "Repeticiones disminuidas.");
                    }
                    case 3 -> {
                        registroService.aumentarPeso(registro);
                        logger.info(nextLine + "Peso aumentado.");
                    }
                    case 4 -> {
                        registroService.disminuirPeso(registro);
                        logger.info(nextLine + "Peso disminuido.");
                    }
                    default -> logger.info(nextLine + "Opción no válida.");
                }
            }
            case 9 -> {
                logger.info(nextLine + "¡Hasta luego! 💪");
                return true;
            }
            default -> logger.info(nextLine + "Opción no válida. Intenta de nuevo.");
        }
        return false;
    }
}