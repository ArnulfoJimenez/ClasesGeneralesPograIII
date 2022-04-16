/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.josue.BD;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Josss_k4ptalp
 */
public class ConexionaMYSQL {

    private static Connection ConnectionBD = null;

    public Connection getConecction() {
        
        try {
            String url = "jdbc:mysql://localhost:3306/libreriabd";
            String user = "josue";
            String password = "ajsj1";

            ConnectionBD = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion exitosa");
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.toString());
        }

        return ConnectionBD;
    }
}
