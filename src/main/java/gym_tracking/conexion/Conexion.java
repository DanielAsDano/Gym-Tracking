package gym_tracking.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection getConexion(){
        Connection conexion = null;
        String baseDatos = "gym_tracking";
        String url = "jdbc:sqlite:db/gym_tracking.db";
        try {
            conexion = DriverManager.getConnection(url);
        }catch (Exception e){
            System.out.println("Error al connectar: " + e.getMessage());
        }
        return conexion;
    }
}
