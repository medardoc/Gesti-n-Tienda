package Modelo.Implementaciones;

// Interfaz para implementaciones concretas del control de stock
public interface InterfazControlStock {
    void actualizarStock(String nombreProducto, int cantidad);
    int obtenerStock(String nombreProducto);
}
