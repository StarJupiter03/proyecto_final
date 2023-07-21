package Resources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import SQL.Conexion;
import java.util.List;

public class HistorialComprasDAO {
    public static void agregarCompra(String correo, List<String> nombresProductos, List<Double> preciosProductos) {
        // Obtener el DNI correspondiente al correo electrónico
        String dni = obtenerDniPorCorreo(correo);

        // Insertar los datos en la tabla "HistorialCompras"
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = Conexion.getConexion();

            String query = "INSERT INTO HistorialCompras (DNI_CLIENTE, Producto, Precio) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(query);

            // Recorrer los productos y sus precios
            for (int i = 0; i < nombresProductos.size(); i++) {
                String producto = nombresProductos.get(i);
                double precio = preciosProductos.get(i);

                pstmt.setString(1, dni);
                pstmt.setString(2, producto);
                pstmt.setDouble(3, precio);

                pstmt.executeUpdate();

                System.out.println("La compra del producto '" + producto + "' se ha agregado al historial de compras.");
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar la compra al historial de compras: " + e.getMessage());
        } finally {
            // Cerrar conexión y liberar recursos
            try {
                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    
    private static String obtenerDniPorCorreo(String correo) {
        // Realizar la consulta para obtener el DNI a partir del correo electrónico
        // Aquí debes usar la consulta SQL correspondiente
        // Recuerda reemplazar "correo_electronico" con el valor real del correo electrónico
        String query = "SELECT DNI FROM CLIENTE WHERE Email = ?";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        String dni = "";
        
        try {
            conn = Conexion.getConexion();
            
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, correo);
            
            // Ejecutar la consulta
            // Aquí debes obtener el resultado de la consulta y asignarlo a la variable "dni"
            // Debes adaptar el código para manejar el resultado de la consulta y asignar correctamente el valor a "dni"
            // Aquí hay un ejemplo básico de cómo obtener el resultado:
            /*
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                dni = rs.getString("DNI");
            }
            */
        } catch (SQLException e) {
            System.out.println("Error al obtener el DNI: " + e.getMessage());
        } finally {
            // Cerrar conexión y liberar recursos
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        
        return dni;
    }
    public static void mostrarRegistro(String dni, String producto, double precio) {
    System.out.println("Registro a insertar en la tabla HistorialCompras:");
    System.out.println("----------------------------------------------");
    System.out.println("DNI_CLIENTE: " + dni);
    System.out.println("Producto: " + producto);
    System.out.println("Precio: " + precio);
    System.out.println("----------------------------------------------");
}

}
