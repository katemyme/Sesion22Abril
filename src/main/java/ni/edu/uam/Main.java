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
                            "3. buscar\n" +
                            "4. buscar producto por nombre\n"+
                            "5. Eliminar Producto\n" +
                            "6. Modificar Producto \n" +
                            "7. Salir\n" +
                            "Elige una opción:"
            ));

            switch (opcion) {

                case 1:
                    String nombre = JOptionPane.showInputDialog("Nombre del producto:");

                    double precio = Double.parseDouble(
                            JOptionPane.showInputDialog("Precio:")
                    );

                    int cantidad = Integer.parseInt(
                            JOptionPane.showInputDialog("Cantidad:")
                    );

                    productos.agregarProducto(nombre, precio, cantidad);

                    JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, productos.getFactura());
                    break;

                case 3:
                    nombre = JOptionPane.showInputDialog("Nombre del producto:");

                    precio = Double.parseDouble(
                            JOptionPane.showInputDialog("Precio:")
                    );

                    cantidad = Integer.parseInt(
                            JOptionPane.showInputDialog("Cantidad:")
                    );

                    JOptionPane.showMessageDialog(null,
                            productos.buscarProducto(nombre, cantidad, precio)
                    );
                    break;

                case 4:
                    nombre = JOptionPane.showInputDialog("Nombre del producto:");
                    JOptionPane.showMessageDialog(null,
                            productos.buscarProductoPorNombre(nombre)
                    );
                    break;

                case 5:
                    nombre = JOptionPane.showInputDialog("Nombre del producto a eliminar:");
                    boolean eliminado = productos.eliminarP(nombre);

                    JOptionPane.showMessageDialog(null,
                            eliminado ? "Producto eliminado" : "Producto no encontrado"
                    );
                    break;
                case 6:
                    nombre = JOptionPane.showInputDialog("Nombre del producto a modificar:");

                    int nuevaCantidad = Integer.parseInt(
                            JOptionPane.showInputDialog("Nueva cantidad:")
                    );

                    double nuevoPrecio = Double.parseDouble(
                            JOptionPane.showInputDialog("Nuevo precio:")
                    );

                    boolean modificado = productos.modificarProducto(nombre, nuevaCantidad, nuevoPrecio);

                    JOptionPane.showMessageDialog(null,
                            modificado ? "Producto modificado correctamente" : "Producto no encontrado"
                    );
                    break;

                case 7:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }

        } while (opcion != 7);
    }
}