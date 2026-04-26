package gym_tracking.datos;

import gym_tracking.conexion.Conexion;
import gym_tracking.dominio.Registro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroDAO implements IRegistroDAO{
    @Override
    public boolean aumentarPeso(Registro registro) {
        Connection conexion = Conexion.getConexion();
        PreparedStatement ps;
        String consulta = "UPDATE registros SET peso = (peso + 1) WHERE id_ejercicio = ?";
        try {
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, registro.getIdEjercicio());
            ps.executeUpdate();
            return true;
        }catch (Exception e){
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
    public boolean disminuirPeso(Registro registro) {
        Connection conexion = Conexion.getConexion();
        PreparedStatement ps;
        String consulta = "UPDATE registros SET peso = (peso - 1) Where id_ejercicio = ?";
        try {
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, registro.getIdEjercicio());
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
    public boolean aumentarRepeticiones(Registro registro) {
        Connection conexion = Conexion.getConexion();
        PreparedStatement ps;
        String consulta = "UPDATE registros SET repeticiones = (repeticiones + 1) WHERE id_ejercicio = ?";
        try {
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, registro.getIdEjercicio());
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
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
    public boolean disminuirRepeticiones(Registro registro) {
        Connection conexion = Conexion.getConexion();
        PreparedStatement ps;
        String consulta = "UPDATE registros SET repeticiones = (repeticiones - 1) WHERE id_ejercicio = ?";
        try {
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, registro.getIdEjercicio());
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
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
    public boolean modificarPesoAumentar(Registro registro) {
        Connection conexion = Conexion.getConexion();
        PreparedStatement ps;
        String consulta = "UPDATE registros SET peso = (peso + ?) WHERE id_ejercicio = ?";
        try {
            ps = conexion.prepareStatement(consulta);
            ps.setDouble(1,registro.getPeso());
            ps.setInt(2, registro.getIdEjercicio());
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
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
    public boolean modificarPesoDisminuir(Registro registro) {
        Connection conexion = Conexion.getConexion();
        PreparedStatement ps;
        String consulta = "UPDATE registros SET peso = (peso - ?) WHERE id_ejercicio = ?";
        try {
            ps = conexion.prepareStatement(consulta);
            ps.setDouble(1,registro.getPeso());
            ps.setInt(2, registro.getIdEjercicio());
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
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
    public boolean modificarRepeticionesAumentar(Registro registro) {
        Connection conexion = Conexion.getConexion();
        PreparedStatement ps;
        String consulta = "UPDATE registros SET repeticiones = (repeticiones + ?) WHERE id_ejercicio = ?";
        try {
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1,registro.getRepeticiones());
            ps.setInt(2,registro.getIdEjercicio());
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
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
    public boolean modificarRepeticionesDisminuir(Registro registro) {
        Connection conexion = Conexion.getConexion();
        PreparedStatement ps;
        String consulta = "UPDATE registros SET repeticiones = (repeticiones - ?) WHERE id_ejercicio = ?";
        try {
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1,registro.getRepeticiones());
            ps.setInt(2,registro.getIdEjercicio());
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
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
