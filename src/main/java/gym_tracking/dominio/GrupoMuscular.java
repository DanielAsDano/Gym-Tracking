package gym_tracking.dominio;

import java.io.Serializable;
import java.util.Objects;

public class GrupoMuscular implements Serializable {
    private int id;
    private String nombre;

    public GrupoMuscular(){
    }

    public GrupoMuscular(int id){
        this.id = id;
    }

    public GrupoMuscular(String nombre){
        this.nombre = nombre;
    }

    public GrupoMuscular(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GrupoMuscular that = (GrupoMuscular) o;
        return id == that.id && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @Override
    public String toString() {
        return "GrupoMuscular{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
