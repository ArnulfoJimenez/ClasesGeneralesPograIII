/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Estudiante;
import com.josue.BD.ConexionaMYSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Josss_k4ptalp
 */
public class Logeo {

    ConexionaMYSQL con = new ConexionaMYSQL();
    Connection conexion = con.getConecction();

    public ArrayList<Estudiante> Login() {
        ArrayList<Estudiante> Listado = null;

        try {

            Listado = new ArrayList<Estudiante>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_MOSTRARLOGEO()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {

                Estudiante es = new Estudiante();
                //llamar al obejeto de entidades
                es.setUser(resultado.getNString("User"));
                es.setPassword(resultado.getNString("Password"));

                Listado.add(es);
            }

        } catch (Exception e) {

        }
        return Listado;
    }

    public void AddUser(Estudiante es) {

        try {
            CallableStatement cb = conexion.prepareCall("{call SP_S_LOGEO(?,?)}");
            cb.setString("PUser", es.getUser());
            cb.setString("PPassword", es.getPassword());
            cb.execute();

            JOptionPane.showMessageDialog(null, "User agregado", "Mensjae sitema", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.toString(), "Mensjae sitema", 1);
        }
    }

}
