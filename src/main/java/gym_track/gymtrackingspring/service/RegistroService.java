package gym_track.gymtrackingspring.service;

import gym_track.gymtrackingspring.model.Registro;
import gym_track.gymtrackingspring.repository.IRegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroService implements IRegistroService {

    @Autowired
    private IRegistroRepository registroRepository;

    @Override
    public void guardarRegistro(Registro registro) {
        registroRepository.save(registro);
    }

    @Override
    public void aumentarRepeticiones(Registro registro) {
        registro.setRepeticiones(registro.getRepeticiones() + 1);
        registroRepository.save(registro);
    }

    @Override
    public void disminuirRepeticiones(Registro registro) {
        registro.setRepeticiones(registro.getRepeticiones() - 1);
        registroRepository.save(registro);
    }

    @Override
    public void aumentarPeso(Registro registro) {
        registro.setPeso(registro.getPeso() + 0.5);
        registroRepository.save(registro);
    }

    @Override
    public void disminuirPeso(Registro registro) {
        registro.setPeso(registro.getPeso() - 0.5);
        registroRepository.save(registro);
    }
}
