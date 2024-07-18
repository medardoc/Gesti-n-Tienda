package Modelo;

import Modelo.Implementaciones.InterfazControlStock;

// Clase para gestionar el control de stock de los productos (Bridge)
public class SistemaControlStock {
    private InterfazControlStock implementacion; // Implementación concreta del control de stock

    // Constructor
    public SistemaControlStock(InterfazControlStock implementacion) {
        this.implementacion = implementacion;
    }

    // Métodos para gestionar el stock de productos
    public void actualizarStock(String nombreProducto, int cantidad) {
        implementacion.actualizarStock(nombreProducto, cantidad);
    }

    public int obtenerStock(String nombreProducto) {
        return implementacion.obtenerStock(nombreProducto);
    }
}
