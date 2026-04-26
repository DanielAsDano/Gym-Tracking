package gym_tracking.dominio;

import java.io.Serializable;
import java.util.Objects;

public class Ejercicio implements Serializable {
    private int idEjercicio;
    private String nombreEjercicio;
    private int idGrupo;

    public Ejercicio() {
    }

    public Ejercicio(int idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public Ejercicio(int idEjercicio, String nombreEjercicio) {
        this.idEjercicio = idEjercicio;
        this.nombreEjercicio = nombreEjercicio;
    }

    public Ejercicio(int idEjercicio, String nombreEjercicio, int idGrupo) {
        this.idEjercicio = idEjercicio;
        this.nombreEjercicio = nombreEjercicio;
        this.idGrupo = idGrupo;
    }

    public int getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(int idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public String getNombreEjercicio() {
        return nombreEjercicio;
    }

    public void setNombreEjercicio(String nombreEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ejercicio ejercicio = (Ejercicio) o;
        return idEjercicio == ejercicio.idEjercicio && idGrupo == ejercicio.idGrupo && Objects.equals(nombreEjercicio, ejercicio.nombreEjercicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEjercicio, nombreEjercicio, idGrupo);
    }

    @Override
    public String toString() {
        return "Ejercicio{" +
                "idEjercicio=" + idEjercicio +
                ", nombreEjercicio='" + nombreEjercicio + '\'' +
                ", idGrupo=" + idGrupo +
                '}';
    }
}
