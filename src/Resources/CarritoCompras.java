/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resources;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompras {
    private static List<String> nombresProductos = new ArrayList<>();
    private static List<Integer> cantidadProductos = new ArrayList<>();
    private static List<Double> preciosProductos = new ArrayList<>();
    private static List<Double> subtotales = new ArrayList<>();
    private static double total_pago;
    private static String metodoPago;
    private static String tipoEntrega;
    private static String correo;

    public static void agregarProducto(String nombre, double precio) {
        nombresProductos.add(nombre);
        preciosProductos.add(precio);
        subtotales.add(precio);
    }

    public static void total_precio(double total) {
        total_pago = total;
    }
    
    public static void MetodoPago(String metodo) {
        metodoPago = metodo;
    }
    
    public static void TipoEntrega(String entrega) {
        tipoEntrega = entrega;
    }
    
    public static void setCorreo(String email) {
        correo = email;
    }
    
    public static List<String> getNombresProductos() {
        return nombresProductos;
    }
    
    public static List<Integer> getCantidadesProductos() {
        return cantidadProductos;
    }
    
    public static List<Double> getPreciosProductos() {
        return preciosProductos;
    }
    
    public static List<Double> getSubtotales() {
        return subtotales;
    }
    
    public static double getTotalPrecio() {
        return total_pago;
    }
    
    public static String getMetodoPago() {
        return metodoPago;
    }
    
    public static String getTipoEntrega() {
        return tipoEntrega;
    }
    
    public static String getCorreo() {
        return correo;
    }
    
    public static String generarResumenCompra() {
        String resumen = "Resumen de la compra:\n";
        resumen += "--------------------------------------\n";
        resumen += "Precio total: S/. " + String.format("S/. %.2f",getTotalPrecio()) + "\n";
        resumen += "Método de pago: " + getMetodoPago() + "\n";
        resumen += "Tipo de entrega: " + getTipoEntrega() + "\n";

        if (getTipoEntrega().equals("Delivery")) {
            double precioTotalConDelivery = getTotalPrecio();
            resumen += "Precio total con delivery: S/. " + String.format("S/. %.2f",precioTotalConDelivery) + "\n";
        }

        resumen += "--------------------------------------";

        return resumen;
    }
    
    public static String generarMensajeConfirmacionCompra() {
        String mensaje = "¡Compra realizada con éxito!\n";
        mensaje += "--------------------------------------\n";
        
        if (getTipoEntrega().equals("Delivery")) {
            mensaje += "Su producto estará llegando en breves momentos.\n";
        } else if (getTipoEntrega().equals("Recoger en tienda")) {
            mensaje += "Su producto está listo para recogerse en nuestra tienda.\n";
        }
        
        if (getMetodoPago().equals("Efectivo")) {
            mensaje += "La compra ha sido efectuada para pagarse en efectivo.\n";
        } else if (getMetodoPago().equals("Tarjeta")) {
            mensaje += "Tenga su tarjeta lista, ya que se pedirá para usar el POS.\n";
        }

        mensaje += "¡Gracias por su compra!\n";
        mensaje += "--------------------------------------\n";
        mensaje += "Total de productos: S/. " + getTotalPrecio() + "\n";

        return mensaje;
    }
}
