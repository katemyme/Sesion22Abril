package ni.edu.uam;

import ni.edu.uam.servicios.ProductoServicio;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ProductoServicio productos = new ProductoServicio();

        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENU \n" +
                            "1. Agregar producto\n" +
                            "2. Mostrar productos\n" +
                            "3. Salir\n" +
                            "Elige una opción:"
            ));

            switch (opcion) {
                case 1:
                    String nombre = JOptionPane.showInputDialog("Nombre del producto:");

                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio:")
                    );

                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad:")
                    );
                    productos.agregarProducto(nombre, precio, cantidad);

                    JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, productos.getFactura());
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }

        } while (opcion != 3);
    }
}