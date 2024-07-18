package Modelo;

import java.util.ArrayList;
import java.util.List;

// Clase para gestionar los productos en el inventario (Singleton)
public class ProductoManager {
    private static ProductoManager instance; // Instancia única del gestor de productos
    private List<Producto> productos; // Lista de productos

    // Constructor privado para evitar instanciación directa
    private ProductoManager() {
        productos = new ArrayList<>();
    }

    // Método estático para obtener la única instancia del gestor de productos
    public static synchronized ProductoManager getInstance() {
        if (instance == null) {
            instance = new ProductoManager();
        }
        return instance;
    }

    // Método para agregar un nuevo producto al inventario
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Método para actualizar la información de un producto existente en el inventario
    public void actualizarProducto(Producto producto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equals(producto.getNombre())) {
                productos.set(i, producto);
                break;
            }
        }
    }

    // Método para obtener la lista de productos
    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    // Método para obtener un producto por su nombre
    public Producto obtenerProducto(String nombreProducto) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombreProducto)) {
                return producto;
            }
        }
        return null;
    }

    // Método para eliminar un producto por su nombre
    public void eliminarProducto(String nombreProducto) {
        productos.removeIf(producto -> producto.getNombre().equals(nombreProducto));
    }

    // Método para actualizar el stock de un producto
    public void actualizarStock(String nombreProducto, int nuevoStock) {
        Producto producto = obtenerProducto(nombreProducto);
        if (producto != null) {
            producto.setStock(nuevoStock);
        }
    }
}

