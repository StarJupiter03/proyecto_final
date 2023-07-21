/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tambo_mysql;

import SQL.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.*; 

/**
 *
 * @author fabri
 */


public class Cliente {
    protected String DNI;
    protected String Nombre;
    protected String Apellido;
    protected String Direccion;
    protected String Celular;
    protected String Email;
    protected String Pass;

    
    public Cliente(String DNI, String Nombre, String Apellido, String Direccion, String Celular, String Email, String Pass) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Direccion = Direccion;
        this.Celular = Celular;
        this.Email = Email;
        this.Pass = Pass;
    }

    public Cliente(String Email, String Pass) {
        this.Email = Email;
        this.Pass = Pass;
    }
    
    void RegistroDB(){
        
        if(DNI.isEmpty() || Nombre.isEmpty() || Apellido.isEmpty() || Direccion.isEmpty() || Celular.isEmpty() || Email.isEmpty() || Pass.isEmpty()){
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
        }else{
            try{
            Connection con=Conexion.getConexion();
            PreparedStatement ps=con.prepareStatement("INSERT INTO CLIENTE (DNI, Nombre, Apellido, Direccion, Celular, Email ,Pass) VALUES(?,?,?,?,?,?,?)");
            
            ps.setString(1, DNI);
            ps.setString(2, Nombre);
            ps.setString(3, Apellido);
            ps.setString(4, Direccion);
            ps.setString(5, Celular);
            ps.setString(6, Email);
            ps.setString(7, Pass);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null , "Registro guardado, proceda a iniciar sesión");
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null , ex.toString());
            }
                Login LoginFrame = new Login();
                LoginFrame.setVisible(true);
                LoginFrame.pack();
                LoginFrame.setLocationRelativeTo(null);//Centra el formulario
        }  
    }
    
    void InicioSeionDB() {
        String query = "SELECT * FROM CLIENTE WHERE Email = ? AND Pass = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, Email);
            ps.setString(2, Pass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Si existe el Email y la contraseña es correcta
                String em = rs.getString("Email");
                String pa = rs.getString("Pass");

                if (Pass.equals(pa)) {
                    // Si la contraseña es igual, se redirecciona a siguiente proceso
                    JOptionPane.showMessageDialog(null, "Bienvenido");

                    // Si deseas realizar alguna operación con el cliente autenticado, puedes hacerlo aquí

                } else {
                    JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
                }
            } else {
                // El Email no existe o la contraseña no coincide
                JOptionPane.showMessageDialog(null, "El correo electrónico no está registrado o la contraseña es incorrecta");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
}
