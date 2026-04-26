package gym_tracking.interfaz;

import gym_tracking.datos.*;
import gym_tracking.dominio.*;

import java.util.List;
import java.util.Scanner;

public class Interfaz {

    IEjercicioDAO ejercicioDAO = new EjercicioDAO();
    IGrupoMuscularDAO grupoMuscularDAO = new GrupoMuscularDAO();
    IRegistroDAO registroDAO = new RegistroDAO();
    Scanner scanner = new Scanner(System.in);

    public void app() {
        boolean salir = false;
        while (!salir) {
            System.out.printf("""
                    --------------------------Gym Tracking--------------------------
                    1. Listar ejercicios
                    2. Buscar ejercicio por ID
                    3. Agregar ejercicio
                    4. Modificar ejercicio
                    5. Eliminar ejercicio
                    6. Listar grupos musculares
                    7. Gestionar registro de ejercicio
                    8. Salir
                    Opcion: """);
            int operacion = Integer.parseInt(scanner.nextLine());
            System.out.println();
            salir = operaciones(operacion);
            System.out.println();
        }
    }

    private boolean operaciones(int operacion) {
        switch (operacion) {
            case 1 -> {
                List<Ejercicio> lista = ejercicioDAO.listarEjercicios();
                lista.forEach(System.out::println);
            }
            case 2 -> {
                System.out.print("ID del ejercicio a buscar: ");
                int id = Integer.parseInt(scanner.nextLine());
                Ejercicio ejercicio = new Ejercicio(id);
                if (ejercicioDAO.buscarEjercicioPorID(ejercicio))
                    System.out.println(ejercicio);
                else
                    System.out.println("Ejercicio no encontrado");
            }
            case 3 -> {
                System.out.print("Nombre del ejercicio: ");
                String nombre = scanner.nextLine();
                System.out.print("ID del grupo muscular: ");
                int idGrupo = Integer.parseInt(scanner.nextLine());
                Ejercicio ejercicio = new Ejercicio(0, nombre, idGrupo);
                if (ejercicioDAO.agregarEjercicio(ejercicio))
                    System.out.println("Ejercicio agregado con exito :)");
                else
                    System.out.println("Error al agregar");
            }
            case 4 -> {
                System.out.print("ID del ejercicio a modificar: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Nuevo nombre: ");
                String nombre = scanner.nextLine();
                Ejercicio ejercicio = new Ejercicio(id, nombre);
                if (ejercicioDAO.modificarEjercicio(ejercicio))
                    System.out.println("Ejercicio modificado con exito :)");
                else
                    System.out.println("Error al modificar");
            }
            case 5 -> {
                System.out.print("ID del ejercicio a eliminar: ");
                int id = Integer.parseInt(scanner.nextLine());
                Ejercicio ejercicio = new Ejercicio(id);
                if (ejercicioDAO.eliminarEjercicio(ejercicio))
                    System.out.println("Ejercicio eliminado con exito :)");
                else
                    System.out.println("Error al eliminar");
            }
            case 6 -> {
                List<GrupoMuscular> grupos = grupoMuscularDAO.listarGrupos();
                grupos.forEach(System.out::println);
            }
            case 7 -> menuRegistro();
            case 8 -> {
                return true;
            }
            default -> System.out.println("Opcion invalida");
        }
        return false;
    }

    private void menuRegistro() {
        System.out.print("ID del ejercicio: ");
        int idEjercicio = Integer.parseInt(scanner.nextLine());
        Registro registro = new Registro();
        registro.setIdEjercicio(idEjercicio);

        System.out.printf("""
                    1. Aumentar peso en 1
                    2. Disminuir peso en 1
                    3. Aumentar peso personalizado
                    4. Disminuir peso personalizado
                    5. Aumentar repeticiones en 1
                    6. Disminuir repeticiones en 1
                    7. Aumentar repeticiones personalizado
                    8. Disminuir repeticiones personalizado
                    Opcion: """);

        int opcion = Integer.parseInt(scanner.nextLine());

        switch (opcion) {
            case 1 -> registroDAO.aumentarPeso(registro);
            case 2 -> registroDAO.disminuirPeso(registro);
            case 3 -> {
                System.out.print("Cuanto peso aumentar: ");
                registro.setPeso(Float.parseFloat(scanner.nextLine()));
                registroDAO.modificarPesoAumentar(registro);
            }
            case 4 -> {
                System.out.print("Cuanto peso disminuir: ");
                registro.setPeso(Float.parseFloat(scanner.nextLine()));
                registroDAO.modificarPesoDisminuir(registro);
            }
            case 5 -> registroDAO.aumentarRepeticiones(registro);
            case 6 -> registroDAO.disminuirRepeticiones(registro);
            case 7 -> {
                System.out.print("Cuantas repeticiones aumentar: ");
                registro.setRepeticiones(Integer.parseInt(scanner.nextLine()));
                registroDAO.modificarRepeticionesAumentar(registro);
            }
            case 8 -> {
                System.out.print("Cuantas repeticiones disminuir: ");
                registro.setRepeticiones(Integer.parseInt(scanner.nextLine()));
                registroDAO.modificarRepeticionesDisminuir(registro);
            }
            default -> System.out.println("Opcion invalida");
        }
        System.out.println("Operacion realizada con exito :)");
    }
}