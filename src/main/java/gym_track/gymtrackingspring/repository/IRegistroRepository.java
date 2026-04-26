package gym_track.gymtrackingspring.repository;

import gym_track.gymtrackingspring.model.Registro;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRegistroRepository extends JpaRepository<Registro, Integer> {
}
