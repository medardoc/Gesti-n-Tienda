package Modelo;

// Clase para representar un producto en el inventario
public class Producto {
    private String nombre;
    private double precio;
    private int stock;
    private int cantidad;

    // Constructor
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

   public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
}

    public int getCantidad() {
    return this.cantidad;
}
}
