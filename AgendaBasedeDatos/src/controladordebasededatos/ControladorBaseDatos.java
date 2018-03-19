/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladordebasededatos;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author PCD
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author OrixStranger
 */
public class ControladorBaseDatos {

    private ArrayList<Persona> listaPersonas;
    private Statement estado;
    private String url = "jdbc:derby://localhost:1527/PersonaDB";
    private String usuario = "administrador";
    private String clave = "admin20";
    public Connection connection;
    PreparedStatement seleccionarPersonas;
    PreparedStatement seleccionarPersonasPorApellido;
    PreparedStatement insertarNuevaPersona;

    public ControladorBaseDatos() {
        listaPersonas = new ArrayList();
        getConnection();
    }

    public Connection getConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ArrayList<Persona> getPersona() {
        try {
            String datoSQL = "select * from Persona";
            seleccionarPersonas = connection.prepareStatement(datoSQL);
            ResultSet r = seleccionarPersonas.executeQuery(datoSQL);
            while (r.next()) {
                int id = r.getInt("id");
                String nombres = r.getString("nombres");
                String apellido = r.getString("apellido");
                String email = r.getString("email");
                String telefono = r.getString("telefono");
                Persona p = new Persona(id, nombres, apellido, email, telefono);
                listaPersonas.add(p);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPersonas;
    }

    public ArrayList<Persona> getPersonaApellido(String apellido) {
        try {
            String datoSQL = "select * from Persona where apellido like '%" + apellido + "%'";
            seleccionarPersonasPorApellido = connection.prepareStatement(datoSQL);
            seleccionarPersonasPorApellido.setString(1, apellido);
            seleccionarPersonasPorApellido.executeQuery();
            ResultSet r = seleccionarPersonasPorApellido.executeQuery();
            while(r.next()){
                int id = r.getInt("id");
                String nombres = r.getString("nombres");
                String apellidos = r.getString("apellido");
                String email = r.getString("email");
                String telefono = r.getString("telefono");
                Persona p = new Persona(id, nombres, apellidos, email, telefono);
                listaPersonas.add(p);
            }
            r.close();
            seleccionarPersonasPorApellido.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPersonas;
    }
    
    public void agregarPersona(int id,String nombre,String apellido,String email,String telefono){
        getConnection();
        try {
            String  datoSQL = "insert into Persona(id,nombres,apellido,email,telefono) values(?,?,?,?)";
            insertarNuevaPersona = connection.prepareStatement(datoSQL);
            insertarNuevaPersona.setInt(1, id);
            insertarNuevaPersona.setString(1, nombre);
            insertarNuevaPersona.setString(2, apellido);
            insertarNuevaPersona.setString(3, email);
            insertarNuevaPersona.setString(4, telefono);
            insertarNuevaPersona.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Se agrego nueva persona");
    }

}