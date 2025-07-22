/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ascen
 */
public class CConexion {

    Connection conectar;

    //Crear las creedenciales de mysql
    String usuario = "root";
    String contra = "wirtaryen17:D";
    String base = "login";
    String ip = "localhost";
    String puerto = "3306";

    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+base;

    //Método para conectar la base
    public Connection estableceConexion() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contra);
            //Funciona la conexion
            //JOptionPane.showMessageDialog(null, "Se ha conectado con exito a la Base de Datos");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas en la conexion: " + e.toString());
        }

        return conectar;

    }
}

/*
    Esta clase maneja la conexión de MYSQL.
    Define las credenciales:
        1. Usuario
        2. Contraseña
        3. El nombre de la Base de Datos
        4. IP: Es el localhost u otro usuario que hayamos creado
        5. Puerto: El puerto es el por defecto: 3306

    También hice un método llamado "estableceConexion" que 
    hará la conexión a MySQL, si se puede todo correcto, sino
    muestro un mensaje con el JOptionPane que no se puedo y muere :D
*/