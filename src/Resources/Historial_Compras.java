/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resources;

import SQL.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Historial_Compras {
    
    public static void guardarCompra(String dniCliente, List<String> nombresProductos, List<Double> preciosProductos) throws SQLException {
        // Obtener la conexión a la base de datos
        Connection connection = Conexion.getConexion();
        if (connection == null) {
            // Manejar error de conexión
            return;
        }
        
        try {
            // Crear la consulta SQL para insertar en la tabla "HistorialCompras"
            String sql = "INSERT INTO HistorialCompras (DNI_CLIENTE, Producto, Precio) VALUES (?, ?, ?)";
            
            // Recorrer las listas de nombres y precios
            try ( // Preparar la declaración SQL
                    PreparedStatement statement = connection.prepareStatement(sql)) {
                // Recorrer las listas de nombres y precios
                for (int i = 0; i < nombresProductos.size(); i++) {
                    String nombre = nombresProductos.get(i);
                    double precio = preciosProductos.get(i);
                    
                    // Establecer los parámetros en la consulta SQL
                    statement.setString(1, dniCliente);
                    statement.setString(2, nombre);
                    statement.setDouble(3, precio);
                    
                    // Ejecutar la consulta SQL
                    statement.executeUpdate();
                }
                // Cerrar la declaración
            }
            
            // Cerrar la conexión a la base de datos
            connection.close();
        } catch (SQLException e) {
        }
    }
}

