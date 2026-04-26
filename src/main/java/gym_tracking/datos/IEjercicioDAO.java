package gym_tracking.datos;

import gym_tracking.dominio.Ejercicio;

import java.util.List;

public interface IEjercicioDAO {
    List<Ejercicio> listarEjercicios();
    boolean buscarEjercicioPorID(Ejercicio ejercicio);
    boolean agregarEjercicio(Ejercicio ejercicio);
    boolean modificarEjercicio(Ejercicio ejercicio);
    boolean eliminarEjercicio(Ejercicio ejercicio);
}
