package gym_tracking.datos;

import gym_tracking.dominio.Registro;

public interface IRegistroDAO {
    boolean aumentarPeso(Registro registro);
    boolean disminuirPeso(Registro registro);
    boolean aumentarRepeticiones(Registro registro);
    boolean disminuirRepeticiones(Registro registro);
    boolean modificarPesoAumentar(Registro registro);
    boolean modificarPesoDisminuir(Registro registro);
    boolean modificarRepeticionesAumentar(Registro registro);
    boolean modificarRepeticionesDisminuir(Registro registro);

}
