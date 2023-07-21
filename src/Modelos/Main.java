/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import SQL.Conexion;

public class Main {
    public static void main(String[] args) {
        // Using try-with-resources to automatically close resources
        try (Connection connection = Conexion.getConexion();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM productos")) {

            // Imprimir los productos
            while (resultSet.next()) {
                String producto = resultSet.getString("Producto");
                String categoria = resultSet.getString("Categoria");
                String stock = resultSet.getString("Stock");
                double precio = resultSet.getDouble("Precio");

                System.out.println("Producto: " + producto);
                System.out.println("Categoria: " + categoria);
                System.out.println("Stock: " + stock);
                System.out.println("Precio: " + precio);
                System.out.println("---------------------");
            }
        } catch (SQLException e) {
        }
    }
}