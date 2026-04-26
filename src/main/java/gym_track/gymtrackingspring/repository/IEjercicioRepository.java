package gym_track.gymtrackingspring.repository;

import gym_track.gymtrackingspring.model.Ejercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEjercicioRepository extends JpaRepository<Ejercicio, Integer> {
}
