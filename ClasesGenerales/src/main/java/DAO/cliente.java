/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.clientes1;
import com.josue.BD.ConexionaMYSQL;
import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Vkaiido
 */
public class cliente {

    ConexionaMYSQL con = new ConexionaMYSQL();
    Connection conexion = con.getConecction();

    public ArrayList<clientes1> ListaClientes() {
        ArrayList<clientes1> lista = null;
        try {
            lista = new ArrayList<clientes1>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_CLIENTES()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                clientes1 cl = new clientes1();

                cl.setCodigoCliente(resultado.getString("CodigoCliente"));
                cl.setNombreCliente(resultado.getString("NombreCliente"));
                cl.setApellidoCliente(resultado.getString("ApellidoCliente"));
                cl.setEdad(resultado.getString("Edad"));
                cl.setDireccion(resultado.getString("Direccion"));
                cl.setTelefono(resultado.getString("Telefono"));
                cl.setImagen(resultado.getString("Imagen"));

                lista.add(cl);
            }

        } catch (Exception e) {
            System.out.println("Error man" + e);
        }

        return lista;
    }

    public void AddCliente(clientes1 cl) {

        try {

            CallableStatement cb = conexion.prepareCall("{call SP_I_CLIENTES(?,?,?,?,?,?,?)}");
            cb.setString("PCodigoCliente", cl.getCodigoCliente());
            cb.setString("PNombreCliente", cl.getNombreCliente());
            cb.setString("PApellidoCliente", cl.getApellidoCliente());
            cb.setString("PEdad", cl.getEdad());
            cb.setString("PDireccion", cl.getDireccion());
            cb.setString("PTelefono", cl.getTelefono());
            cb.setString("PImagen", cl.getImagen());
            cb.execute();

            JOptionPane.showMessageDialog(null, "Persona Agregada");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error" + ex);
        }

    }

   
    }


