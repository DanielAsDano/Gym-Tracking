package gym_track.gymtrackingspring.service;

import gym_track.gymtrackingspring.model.Registro;

public interface IRegistroService {
    void guardarRegistro(Registro registro);

    void aumentarRepeticiones(Registro registro);
    void disminuirRepeticiones(Registro registro);
    void aumentarPeso(Registro registro);
    void disminuirPeso(Registro registro   );
}
