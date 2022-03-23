/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Entidades.Nota;
import ViewModel.VMNotas;
import com.josue.BD.ConexionaMYSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Josss_k4ptalp
 */
public class Notas {

    ConexionaMYSQL con = new ConexionaMYSQL();
    Connection conexion = con.getConecction();

   public ArrayList<Nota> ListadoEstudiantes() {
        ArrayList<Nota> Listado = null;

        try {

            Listado = new ArrayList<Nota>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_MOSTRARNOTAS()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {

                Nota es = new Nota();
                //llamar al obejeto de entidades
                es.setNota(resultado.getNString("nota"));
                es.setNombreMateria(resultado.getNString("NombreMateria"));
                es.setNombre(resultado.getNString("Nombre"));
                

                Listado.add(es);
            }

        } catch (Exception e) {

        }
        return Listado;

    }
    
    public ArrayList<VMNotas> ListadoEstudiantesConNotas() {
        ArrayList<VMNotas> Listado = null;

        try {

            Listado = new ArrayList<VMNotas>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_MOSTRARNOTAS()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {

                VMNotas es = new VMNotas();
                //llamar al obejeto de entidades
                es.setNota(resultado.getNString("nota"));
                es.setNombreMateria(resultado.getNString("NombreMateria"));
                es.setNombre(resultado.getNString("Nombre"));
                

                Listado.add(es);
            }

        } catch (Exception e) {

        }
        return Listado;

    }
}
