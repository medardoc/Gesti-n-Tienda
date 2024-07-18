package vista;

import Modelo.Producto;
import Modelo.ProductoManager;
import Modelo.SistemaControlStock;
import Modelo.Implementaciones.ControlStockImplementacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaAplicacion extends JFrame {

    public JTable tablaProductos;
    public JButton btnRealizarPedido;
    public JButton btnAgregarProducto;
    public JButton btnEliminarProducto;
    public DefaultTableModel tableModel;
    public ProductoManager productoManager;
    public SistemaControlStock sistemaControlStock;

    public JTextField txtNombreProducto;
    public JTextField txtCantidadProducto;
    public JTextField txtPrecioProducto;
    public JTextField txtStockProducto;

    public VistaAplicacion() {
        setTitle("Sistema de Gestión de Inventarios");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        productoManager = ProductoManager.getInstance();
        ControlStockImplementacion controlStock = new ControlStockImplementacion();
        sistemaControlStock = new SistemaControlStock(controlStock);
        cargarProductos();
    }

    private void initComponents() {
        JScrollPane scrollPane = new JScrollPane();
        tablaProductos = new JTable();
        btnRealizarPedido = new JButton("Realizar Pedido");
        btnAgregarProducto = new JButton("Agregar Producto");
        btnEliminarProducto = new JButton("Eliminar Producto");

        JLabel lblNombreProducto = new JLabel("Nombre del Producto:");
        JLabel lblCantidadProducto = new JLabel("Cantidad del Producto:");
        JLabel lblPrecioProducto = new JLabel("Precio del Producto:");
        JLabel lblStockProducto = new JLabel("Stock del Producto:");

        txtNombreProducto = new JTextField();
        txtCantidadProducto = new JTextField();
        txtPrecioProducto = new JTextField();
        txtStockProducto = new JTextField();

        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"NombreProducto", "Cantidad", "Precio", "Stock"}
        );
        tablaProductos.setModel(tableModel);
        scrollPane.setViewportView(tablaProductos);

        btnRealizarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarPedido();
            }
        });

        btnAgregarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });

        btnEliminarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblNombreProducto)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNombreProducto, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblCantidadProducto)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCantidadProducto, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblPrecioProducto)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPrecioProducto, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblStockProducto)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtStockProducto, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnRealizarPedido, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAgregarProducto, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnEliminarProducto, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNombreProducto)
                                        .addComponent(txtNombreProducto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblCantidadProducto)
                                        .addComponent(txtCantidadProducto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblPrecioProducto)
                                        .addComponent(txtPrecioProducto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblStockProducto)
                                        .addComponent(txtStockProducto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnRealizarPedido)
                                        .addComponent(btnAgregarProducto)
                                        .addComponent(btnEliminarProducto))
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }

    private void cargarProductos() {
        tableModel.setRowCount(0);
        List<Producto> productos = productoManager.getProductos();
        for (Producto producto : productos) {
            tableModel.addRow(new Object[]{producto.getNombre(), producto.getCantidad(), producto.getPrecio(), producto.getStock()});
        }
    }

    private void realizarPedido() {
        int selectedRow = tablaProductos.getSelectedRow();
        if (selectedRow != -1) {
            String nombreProducto = (String) tableModel.getValueAt(selectedRow, 0);
            Producto producto = productoManager.obtenerProducto(nombreProducto);
            if (producto != null && producto.getStock() > 0) {
                try {
                    int cantidad = Integer.parseInt(txtCantidadProducto.getText());
                    if (cantidad <= producto.getStock()) {
                        productoManager.actualizarStock(nombreProducto, producto.getStock() - cantidad);
                        cargarProductos(); // Actualizar la tabla después de realizar el pedido
                        JOptionPane.showMessageDialog(this, "Pedido realizado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(this, "La cantidad solicitada excede el stock disponible.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Por favor, ingrese una cantidad válida.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "El producto seleccionado no está disponible en stock.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto de la tabla.");
        }
    }

    private void agregarProducto() {
        String nombre = txtNombreProducto.getText();
        int cantidad = Integer.parseInt(txtCantidadProducto.getText());
        double precio = Double.parseDouble(txtPrecioProducto.getText());
        int stock = Integer.parseInt(txtStockProducto.getText());

        Producto producto = new Producto(nombre, precio);
        producto.setCantidad(cantidad); // Aquí se establece la cantidad del producto
        producto.setStock(stock);

        productoManager.agregarProducto(producto);
        sistemaControlStock.actualizarStock(nombre, stock);
        cargarProductos();
    }

    private void eliminarProducto() {
        int selectedRow = tablaProductos.getSelectedRow();
        if (selectedRow != -1) {
            String nombreProducto = (String) tableModel.getValueAt(selectedRow, 0);
            productoManager.eliminarProducto(nombreProducto);
            cargarProductos();
            JOptionPane.showMessageDialog(this, "Producto eliminado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto de la tabla.");
        }
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana de la aplicación
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAplicacion().setVisible(true);
            }
        });
    }
}
