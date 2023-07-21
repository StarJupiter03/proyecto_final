/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
package com.mycompany.tambo_mysql;

import Resources.Producto;
import SQL.Conexion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogoFrame extends JFrame {
    private JPanel panelProductos;
    private List<Producto> productos;
    private int paginaActual;
    private int productosPorPagina;

    public CatalogoFrame(List<Producto> productos) {
        // Configurar el JFrame
        setTitle("Catálogo de Productos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        this.productos = productos;
        this.paginaActual = 1;
        this.productosPorPagina = 9;

        // Crear un GridLayout para dividir los productos en 3 columnas
        GridLayout gridLayout = new GridLayout(0, 3);
        gridLayout.setHgap(10); // Espacio horizontal entre las columnas
        gridLayout.setVgap(10); // Espacio vertical entre las filas

        // Crear el JPanel para mostrar los productos
        panelProductos = new JPanel(gridLayout);

        // Mostrar la página actual de productos
        mostrarPagina(paginaActual);

        // Crear botones de navegación
        JButton btnPaginaAnterior = new JButton("<< Anterior");
        JButton btnPaginaSiguiente = new JButton("Siguiente >>");

        // Agregar listeners para los botones de navegación
        btnPaginaAnterior.addActionListener(e -> {
            if (paginaActual > 1) {
                paginaActual--;
                mostrarPagina(paginaActual);
            }
        });

        btnPaginaSiguiente.addActionListener(e -> {
            int totalPages = getTotalPaginas();
            if (paginaActual < totalPages) {
                paginaActual++;
                mostrarPagina(paginaActual);
            }
        });

        // Crear un JPanel para contener los botones de navegación
        JPanel panelNavegacion = new JPanel();
        panelNavegacion.add(btnPaginaAnterior);
        panelNavegacion.add(btnPaginaSiguiente);

        // Crear un JPanel principal y agregar el panel de productos y el panel de navegación
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(panelProductos, BorderLayout.CENTER);
        panelPrincipal.add(panelNavegacion, BorderLayout.SOUTH);

        // Agregar el panel principal al JFrame
        add(panelPrincipal);

        // Mostrar el JFrame
        setVisible(true);
    }

    private void mostrarPagina(int numeroPagina) {
        panelProductos.removeAll();

        int inicio = (numeroPagina - 1) * productosPorPagina;
        int fin = Math.min(inicio + productosPorPagina, productos.size());

        for (int i = inicio; i < fin; i++) {
            panelProductos.add(crearPanelProducto(productos.get(i)));
        }

        panelProductos.revalidate();
        panelProductos.repaint();
    }

    private JPanel crearPanelProducto(Producto producto) {
        JPanel panelProducto = new JPanel(new BorderLayout());

        // Agregar la imagen del producto al panel
        JLabel labelImagen = new JLabel(producto.getImagen());
        panelProducto.add(labelImagen, BorderLayout.CENTER);

        // Agregar el nombre del producto al panel
        JLabel labelNombre = new JLabel(producto.getNombre());
        panelProducto.add(labelNombre, BorderLayout.NORTH);

        // Agregar el precio del producto al panel
        JLabel labelPrecio = new JLabel(String.valueOf(producto.getPrecio()));
        panelProducto.add(labelPrecio, BorderLayout.CENTER);

        // Agregar los botones "Añadir al carrito" y "Comprar" al panel
        JButton btnAgregarCarrito = new JButton("Añadir al carrito");
        JButton btnComprar = new JButton("Comprar");
        panelProducto.add(btnAgregarCarrito, BorderLayout.SOUTH);
        panelProducto.add(btnComprar, BorderLayout.SOUTH);

        return panelProducto;
    }

    private int getTotalPaginas() {
        return (int) Math.ceil((double) productos.size() / productosPorPagina);
    }

    public static void main(String[] args) {
        // Crear una lista de productos a partir de la base de datos
        List<Producto> productos = obtenerProductosDesdeBD();

        // Crear la ventana del catálogo
        CatalogoFrame catalogoFrame = new CatalogoFrame(productos);
    }

    private static List<Producto> obtenerProductosDesdeBD() {
        List<Producto> productos = new ArrayList<>();

        try (Connection con = Conexion.getConexion()) {
            String consulta = "SELECT * FROM PRODUCTO";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            while (rs.next()) {
                String nombre = rs.getString("Producto");
                double precio = rs.getDouble("Precio");
                ImageIcon imagen = new ImageIcon("ruta_imagenes/" + nombre + ".jpg");

                Producto producto = new Producto(nombre, precio, imagen);
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }
}
*/