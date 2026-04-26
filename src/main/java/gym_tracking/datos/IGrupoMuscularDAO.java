package gym_tracking.datos;

import gym_tracking.dominio.GrupoMuscular;

import java.util.List;

public interface IGrupoMuscularDAO {
    List<GrupoMuscular> listarGrupos();
    boolean buscarGrupoPorID(GrupoMuscular grupo);
}
