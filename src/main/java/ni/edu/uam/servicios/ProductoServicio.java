package ni.edu.uam.servicios;

import ni.edu.uam.interfaces.ProductoInterface;
import ni.edu.uam.modelos.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoServicio  implements ProductoInterface {

    private List<Producto> productos;

    public ProductoServicio() {
        this.productos = new ArrayList<>();
    }

    @Override
    public void agregarProducto(String nombre, double precio, int cantidad) {
        this.productos.add(new Producto(nombre, cantidad, precio));

    }

    @Override
    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public boolean eliminarProducto(String nombre) {
        return false;
    }

    @Override
    public boolean editarProducto(String nombre, double precio, int cantidad) {
        return false;
    }

    public boolean buscarProducto(String nombre, int cantidad, double precio) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)
                    && p.getCantidad() == cantidad
                    && p.getPrecio() == precio) {
                return true;
            }
        }
        return false;
    }
    public boolean buscarProductoPorNombre(String nombre) {
        for (Producto g : productos) {
            if (g.getNombre().equalsIgnoreCase(nombre)){
                return true;
            }
        }
        return false;
    }
    public boolean eliminarP(String nombre) {
        return productos.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));


    }

    public boolean modificarProducto(String nombre, int nuevaCantidad, double nuevoPrecio) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.setCantidad(nuevaCantidad);
                p.setPrecio(nuevoPrecio);
                return true;
            }
        }
        return false;
    }

    public StringBuilder getFactura(){
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Factura");
        mensaje.append("\n");
        for (Producto prod : productos) {
            mensaje.append(prod.getNombre());
            mensaje.append(" | ");
            mensaje.append(prod.getPrecio());
            mensaje.append(" | ");
            mensaje.append(prod.getCantidad());
            mensaje.append(" | ");
            mensaje.append(prod.getPrecio() * prod.getCantidad());
            mensaje.append("\n");
        }
        mensaje.append(this.getMonto());
        return mensaje;
    }
    public double getMonto(){
        double total = 0 , monto =0;
        for (Producto producto: productos){
            total = producto.getCantidad() * producto.getPrecio();
            monto += total;
        }
        return  monto;
    }
}
