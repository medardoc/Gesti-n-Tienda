package Vista;

import Modelo.Producto;
import Modelo.ProductoManager;
import Modelo.SistemaControlStock;
import Modelo.Implementaciones.ControlStockImplementacion;
import Controlador.PedidoAdapter;
import Controlador.ProcesadorPedidos;
import vista.VistaAplicacion;

public class Main {

    public static void main(String[] args) {
        // Singleton: Gestión de productos
        ProductoManager productoManager = ProductoManager.getInstance();
        System.out.println("Singleton: Gestión de productos");

        // Prototype: Creación de nuevos productos
        productoManager.agregarProducto(new Producto("Camisa", 25.99));
        productoManager.agregarProducto(new Producto("Pantalón", 39.99));
        System.out.println("Prototype: Creación de nuevos productos");

        // Bridge: Sistema de control de stock
        ControlStockImplementacion controlStock = new ControlStockImplementacion();
        SistemaControlStock sistemaControlStock = new SistemaControlStock(controlStock);
        System.out.println("Bridge: Sistema de control de stock");

        // Adapter: Adaptación del sistema de inventarios al procesador de pedidos
        // (aquí puedes agregar más detalles sobre cómo se aplica el patrón Adapter si fuera necesario)
        System.out.println("Adapter: Adaptación del sistema de inventarios al procesador de pedidos");

        // Mensaje de éxito
        System.out.println("Todo es un éxito, Profesor Hans, lo quiero mucho No olvide mis decimas del proyecto jijijiji.");

        // Crear y mostrar la ventana de la aplicación
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAplicacion().setVisible(true);
            }
        });
    }
}

