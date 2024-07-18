package Modelo.Implementaciones;

import java.util.HashMap;
import java.util.Map;

// Implementación concreta del control de stock
public class ControlStockImplementacion implements InterfazControlStock {
    private Map<String, Integer> stock; // Almacenamiento del stock de productos

    // Constructor
    public ControlStockImplementacion() {
        this.stock = new HashMap<>(); // Inicialización del mapa de stock
    }

    // Método para actualizar el stock de un producto
    @Override
    public void actualizarStock(String nombreProducto, int cantidad) {
        // Lógica para actualizar el stock del producto
        stock.put(nombreProducto, cantidad);
    }

    // Método para obtener el stock de un producto
    @Override
    public int obtenerStock(String nombreProducto) {
        // Lógica para obtener el stock del producto
        return stock.getOrDefault(nombreProducto, 0);
    }
}
