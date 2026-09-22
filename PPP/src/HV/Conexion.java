package HV;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    public Connection conectar() {
        
        Connection link = null;
        
        try {
            String url = "jdbc:mysql://localhost:3308/practica_java";
            String usuario = "root";
            String password = "";

            link = DriverManager.getConnection(url, usuario, password);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error crítico de conexión: " + e.getMessage());
        }
        
        return link;
    }
}
