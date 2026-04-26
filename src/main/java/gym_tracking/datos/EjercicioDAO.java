package gym_tracking.datos;

import gym_tracking.conexion.Conexion;
import gym_tracking.dominio.Ejercicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EjercicioDAO implements IEjercicioDAO{
    @Override
    public List<Ejercicio> listarEjercicios() {
        Connection conexion = Conexion.getConexion();
        List<Ejercicio> listaEjercicios = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        String consulta = "SELECT * FROM ejercicios";

        try {
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while(rs.next()){
                Ejercicio ejercicio = new Ejercicio();
                ejercicio.setIdGrupo(rs.getInt("id_grupo"));
                ejercicio.setIdEjercicio(rs.getInt("id_ejercicio"));
                ejercicio.setNombreEjercicio(rs.getString("nombre_ejercicio"));
                listaEjercicios.add(ejercicio);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexion" + e.getMessage());
            }
        }
        return listaEjercicios;
    }

    @Override
    public boolean buscarEjercicioPorID(Ejercicio ejercicio) {
        Connection conexion = Conexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta = "SELECT * FROM ejercicios WHERE id_ejercicio = ?";

        try {
           ps = conexion.prepareStatement(consulta);
           ps.setInt(1, ejercicio.getIdEjercicio());
           rs = ps.executeQuery();
           if (rs.next()){
               ejercicio.setNombreEjercicio(rs.getString("nombre_ejercicio"));
               ejercicio.setIdGrupo(rs.getInt("id_grupo"));
               return true;
           }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexion" + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean agregarEjercicio(Ejercicio ejercicio) {
        Connection conexion = Conexion.getConexion();
        PreparedStatement ps;
        String consulta = "INSERT INTO ejercicios (nombre_ejercicio, id_grupo) VALUES (?, ?)";
        try {
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, ejercicio.getNombreEjercicio());
            ps.setInt(2, ejercicio.getIdGrupo());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexion" + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modificarEjercicio(Ejercicio ejercicio) {
        Connection conexion = Conexion.getConexion();
        PreparedStatement ps;
        String consulta = "UPDATE ejercicios SET nombre_ejercicio = ? WHERE id_ejercicio = ?";
        try {
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, ejercicio.getNombreEjercicio());
            ps.setInt(2, ejercicio.getIdEjercicio());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexion" + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean eliminarEjercicio(Ejercicio ejercicio) {
        Connection conexion = Conexion.getConexion();
        PreparedStatement ps;
        String consulta = "DELETE FROM ejercicios WHERE id_ejercicio = ?";
        try {
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1,ejercicio.getIdEjercicio());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexion" + e.getMessage());
            }
        }
        return false;
    }
}
