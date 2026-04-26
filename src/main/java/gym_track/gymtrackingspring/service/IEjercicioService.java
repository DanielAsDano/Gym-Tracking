package gym_track.gymtrackingspring.service;

import gym_track.gymtrackingspring.model.Ejercicio;

import java.util.List;

public interface IEjercicioService {
    List<Ejercicio> listarEjercicio();
    Ejercicio buscarEjercicioPorID(Integer id);
    void guardarEjercicio(Ejercicio ejercicio);
    void eliminarEjercicio(Ejercicio ejercicio);
}
