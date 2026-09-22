package HV;

public class Extras {
    
    /*
    Jframe**********
    
    ==== modificarlos o borrarlos sin tener que escribir el ID a mano.
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                   
    // 1. Obtenemos la fila que el usuario seleccionó con el ratón
    int filaSeleccionada = jTable1.getSelectedRow();

    // 2. Pasamos los datos de la tabla de vuelta a las cajas de texto (JTextfield)
    // (Suponiendo que la columna 1 es el nombre y la columna 2 es la edad)
    jtxtNombre.setText(jTable1.getValueAt(filaSeleccionada, 1).toString());
    jtxtEdad.setText(jTable1.getValueAt(filaSeleccionada, 2).toString());
    
    ---------------------------------------------------------------------------------------
    
    =====Si te piden Guardar en un botón:
    String nombre = jtxtNombre.getText();
    int edad = Integer.parseInt(jtxtEdad.getText());
    OperacionesCompletas op = new OperacionesCompletas();
    op.insertarRegistro(nombre, edad);   <- eje(juan, 20)
    
    op.mostrarDatosEnTabla(jTable1);
        
    =====Si te piden Eliminar:
    int idBorrable = Integer.parseInt(jtxtId.getText());
    OperacionesCompletas op = new OperacionesCompletas();
    op.eliminarRegistro(idBorrable); <- ejemplo(4)
    
    op.mostrarDatosEnTabla(jTable1);
    
    -----------------------------------------------------------------
    ====== Para cargar la tabal al iniciar
    =====poner a bajo de initComponetes
    OperacionesCompletas op = new OperacionesCompletas();
    op.mostrarDatosEnTabla(jTable1);
    */
    
}
