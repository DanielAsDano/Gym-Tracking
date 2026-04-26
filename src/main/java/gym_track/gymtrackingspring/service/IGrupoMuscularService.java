package gym_track.gymtrackingspring.service;

import gym_track.gymtrackingspring.model.GrupoMuscular;

import java.util.List;

public interface IGrupoMuscularService {
    List<GrupoMuscular> listarGrupos();
    GrupoMuscular buscarGrupoPorId(Integer id);
}
