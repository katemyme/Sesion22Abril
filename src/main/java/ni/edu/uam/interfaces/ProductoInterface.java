package ni.edu.uam.interfaces;

import ni.edu.uam.modelos.Producto;

import java.util.List;
import java.util.function.ToDoubleBiFunction;

public interface ProductoInterface {

    public void agregarProducto(String nombre,double precio, int cantidad);

    public List<Producto> getProductos();

    public  boolean eliminarProducto (String nombre);

    public  boolean editarProducto (String nombre, double precio, int cantidad);

    public  boolean buscarProducto(String nombre, int cantidad, double precio);
}
