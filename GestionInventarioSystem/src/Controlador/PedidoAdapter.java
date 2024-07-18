package Controlador;

import Modelo.SistemaControlStock;

// Clase para adaptar el sistema de inventarios al procesador de pedidos (Adapter)
public class PedidoAdapter {
    private SistemaControlStock sistemaControlStock; // Referencia al sistema de control de stock

    // Constructor
    public PedidoAdapter(SistemaControlStock sistemaControlStock) {
        this.sistemaControlStock = sistemaControlStock;
    }

    // Métodos para adaptar el sistema de inventarios al procesador de pedidos
}
