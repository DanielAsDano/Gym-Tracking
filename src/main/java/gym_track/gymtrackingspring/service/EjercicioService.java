package gym_track.gymtrackingspring.service;

import gym_track.gymtrackingspring.model.Ejercicio;
import gym_track.gymtrackingspring.repository.IEjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioService implements IEjercicioService{

    @Autowired
    private IEjercicioRepository ejercicioRepository;

    @Override
    public List<Ejercicio> listarEjercicio() {
        List<Ejercicio> ejercicios = ejercicioRepository.findAll();
        return ejercicios;
    }

    @Override
    public Ejercicio buscarEjercicioPorID(Integer id) {
        Ejercicio ejercicio = ejercicioRepository.findById(id).orElse(null);
        return ejercicio;
    }

    @Override
    public void guardarEjercicio(Ejercicio ejercicio) {
        ejercicioRepository.save(ejercicio);
    }

    @Override
    public void eliminarEjercicio(Ejercicio ejercicio) {
        ejercicioRepository.delete(ejercicio);
    }
}
