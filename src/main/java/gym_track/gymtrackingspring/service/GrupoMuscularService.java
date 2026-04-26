package gym_track.gymtrackingspring.service;

import gym_track.gymtrackingspring.model.GrupoMuscular;
import gym_track.gymtrackingspring.repository.IGrupoMuscularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoMuscularService implements IGrupoMuscularService{

    @Autowired
    private IGrupoMuscularRepository grupoMuscularService;

    @Override
    public List<GrupoMuscular> listarGrupos() {
        List<GrupoMuscular> grupoMusculars = grupoMuscularService.findAll();
        return grupoMusculars;
    }

    @Override
    public GrupoMuscular buscarGrupoPorId(Integer id) {
        GrupoMuscular grupo = grupoMuscularService.findById(id).orElse(null);
        return grupo;
    }
}
