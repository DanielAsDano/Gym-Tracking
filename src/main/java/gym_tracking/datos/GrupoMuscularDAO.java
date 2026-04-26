package gym_tracking.datos;

import gym_tracking.conexion.Conexion;
import gym_tracking.dominio.GrupoMuscular;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GrupoMuscularDAO implements IGrupoMuscularDAO{
    @Override
    public List<GrupoMuscular> listarGrupos() {
        List<GrupoMuscular> listaGruposMusculares = new ArrayList<>();
        Connection conexion = Conexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta = "SELECT * FROM grupos_musculares";
        try{
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
                while (rs.next()){
                    GrupoMuscular grupo = new GrupoMuscular();
                    grupo.setId(rs.getInt("id"));
                    grupo.setNombre(rs.getString("nombre"));

                    listaGruposMusculares.add(grupo);
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
        return listaGruposMusculares;
    }

    @Override
    public boolean buscarGrupoPorID(GrupoMuscular grupo) {
        Connection conexion = Conexion.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String consulta = "SELECT * FROM ejercicios WHERE id_ejercicio = ?";
        try {
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, grupo.getId());
            rs = ps.executeQuery();
            if (rs.next()){
                grupo.setNombre(rs.getString("nombre"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return false;
    }
}
