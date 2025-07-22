/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.mycompany.login.MenuPrincipal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

/**
 *
 * @author ascen
 */
public class CLogin {

    // Método para validar el ingreso del usuario en el Login
    public void validaUsuario(JTextField usuario, JPasswordField contra) {
        try {
            
            //Declaro un objeto de tipo "ResultSet" llamado "rs"
            ResultSet rs = null;
            //Declaro un objeto de tipo "PreparedStatement" llamado "ps"
            PreparedStatement ps = null;
            //Ambos se inicializan en "null"

            // Creo un objeto llamado "CConexion" para establecer la conexión con la Base de Datos
            Clases.CConexion objectoConexion = new Clases.CConexion();

            //Hago la consulta SQL para verificar las credenciales del usuario
            String consulta = "select * from usuario where usuario.ingresoUsuario = (?) and usuario.ingresoPassword = (?);";
            ps = objectoConexion.estableceConexion().prepareStatement(consulta);

            // Obtengo la contraseña ingresada como cadena de texto
            String pass = String.valueOf(contra.getPassword());

            // Configuro los parámetros de la consulta
            ps.setString(1, usuario.getText());
            ps.setString(2, pass);

            // Ejecuto la consulta SQL
            rs = ps.executeQuery();
            
            // Verificaré el resultado de la consulta
            if (rs.next()) {
                // Si se encuentra el usuario, se muestra un mensaje de confirmación
                JOptionPane.showMessageDialog(null, "Usuario Correcto");
                //Creo y visualizo el menú principal
                MenuPrincipal menu = new MenuPrincipal();
                menu.setVisible(true);
            } else {
                // Si las credenciales no estan o no son correctas, muestro este mensaje
                JOptionPane.showMessageDialog(null, "Usuario Incorrecto. Intenta de nuevo");

            }

        } catch (Exception e) {
            // Por si la conexión da error inesperado
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());

        }
    }
}

/*
    Esta clase maneja la validación de entrada del
    correo y la contraseña que ya esta en la Base de datos.
    El método propio "validaUsuario()" recibe dos parámetros:
        1. JTextField
        2. JPasswordField
    
    Creo una consulta SQL para verificar si los credenciales ingresados
    existen en la tabla "usuario" en la base "login".
    Si existe muestro un mensaje con JOptionPane que dice afirma el usuario.
    Y abre "MenuPrincipal". Si no, muestra un mensaje de error y muere.
*/