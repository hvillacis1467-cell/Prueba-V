package HV;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OperacionesCompletas {
    
    // ACCIÓN 1: INSERTAR / REGISTRAR UN NUEVO REGISTRO
    public void insertarRegistro(String nombre, int edad) {
        Conexion cc = new Conexion();
        Connection cn = cc.conectar();

        if (cn != null) {
            try {
                String sql = "INSERT INTO usuarios (nombre, edad) VALUES (?, ?)";
                
                PreparedStatement pst = cn.prepareStatement(sql);
                
                pst.setString(1, nombre);
                pst.setInt(2, edad);
                
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "¡Registro guardado con éxito!");
                cn.close();
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al insertar: " + e.getMessage());
            }
        }
    }

    // ACCIÓN 2: CONSULTAR / LISTAR DATOS Y MOSTRARLOS EN UN JTABLE
    public void mostrarDatosEnTabla(JTable tablaDestino) {
        Conexion cc = new Conexion();
        Connection cn = cc.conectar();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");

        String sql = "SELECT * FROM usuarios";

        try {
            java.sql.Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            String[] datos = new String[3];

            while (rs.next()) {
                datos[0] = rs.getString("id"); 
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("edad"); 
                
                modelo.addRow(datos);
            }

            tablaDestino.setModel(modelo);
            cn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar los datos: " + e.getMessage());
        }
    }

    //ACCIÓN 3: ACTUALIZAR / MODIFICAR UN REGISTRO EXISTENTE
    public void actualizarRegistro(int idBuscado, String nuevoNombre, int nuevaEdad) {
        Conexion cc = new Conexion();
        Connection cn = cc.conectar();

        if (cn != null) {
            try {
                String sql = "UPDATE usuarios SET nombre = ?, edad = ? WHERE id = ?";
                
                PreparedStatement pst = cn.prepareStatement(sql);
                
                pst.setString(1, nuevoNombre);
                pst.setInt(2, nuevaEdad);
                pst.setInt(3, idBuscado);
                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "¡Registro actualizado correctamente!");
                cn.close();
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage());
            }
        }
    }

    // ACCIÓN 4: ELIMINAR UN REGISTRO POR SU ID
    public void eliminarRegistro(int idBuscado) {
        Conexion cc = new Conexion();
        Connection cn = cc.conectar();

        if (cn != null) {
            try {
                String sql = "DELETE FROM usuarios WHERE id = ?";
                
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, idBuscado); // Indicamos cuál ID se va a eliminar
                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "¡Registro eliminado con éxito!");
                cn.close();
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage());
            }
        }
    }
}
