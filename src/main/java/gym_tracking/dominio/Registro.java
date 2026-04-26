package gym_tracking.dominio;

import java.io.Serializable;
import java.util.Objects;

public class Registro implements Serializable {
    private int idEjercicio;
    private int idRegistro;
    private float peso;
    private int repeticiones;

    public Registro() {
    }

    public Registro(int repeticiones, float peso, int idEjercicio) {
        this.repeticiones = repeticiones;
        this.peso = peso;
        this.idEjercicio = idEjercicio;
    }

    public Registro(int idEjercicio, int idRegistro, float peso, int repeticiones) {
        this.idEjercicio = idEjercicio;
        this.idRegistro = idRegistro;
        this.peso = peso;
        this.repeticiones = repeticiones;
    }

    public int getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(int idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Registro registro = (Registro) o;
        return idEjercicio == registro.idEjercicio && idRegistro == registro.idRegistro && Float.compare(peso, registro.peso) == 0 && repeticiones == registro.repeticiones;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEjercicio, idRegistro, peso, repeticiones);
    }

    @Override
    public String toString() {
        return "Registro{" +
                "idEjercicio=" + idEjercicio +
                ", idRegistro=" + idRegistro +
                ", peso=" + peso +
                ", repeticiones=" + repeticiones +
                '}';
    }
}
