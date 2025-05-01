package co.edu.uniquindio.poo.correccion_parcial_2_pii.model;
import java.util.*;

/**
 * Singleton que gestiona un registro global de productos.
 */
public class RegistroGlobal {
    private static RegistroGlobal instancia;
    private List<Producto> productos = new ArrayList<>();

    private RegistroGlobal() {
    }

    public static RegistroGlobal getInstancia() {
        if (instancia == null)
            instancia = new RegistroGlobal();
        return instancia;
    }

    //añadir Producto
    public String añadirProducto(Producto producto) throws IllegalArgumentException {
        String mensaje = "Se añadió correctamente";
        if (producto == null) {
            throw new IllegalArgumentException("No se aceptan objetos nulos");
        }
        productos.add(producto);
        return mensaje;
    }

    //eliminar producto
    public String eliminarPersona(Producto producto) throws IllegalArgumentException {
        String mensaje = "Se eliminó correctamente";
        if (producto == null) {
            throw new IllegalArgumentException("No se aceptan objetos nulos");
        }
        if (!productos.contains(producto)) {
            mensaje = "No se encuentra en la lista";
        }
        productos.remove(producto);
        return mensaje;
    }


    //editar producto
    public String editarProducto(Producto producto, Producto nuevoProducto) throws IllegalArgumentException {
        String mensaje = "Editado correctamente";

        if (producto == null || nuevoProducto == null) {
            throw new IllegalArgumentException("No se aceptan objetos nulos");
        }

        if (!productos.contains(producto)) {
            mensaje = "No se encuentra en la lista";
        }

        productos.remove(producto);
        productos.add(nuevoProducto);
        return mensaje;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void mostrar() {
        System.out.println("\nProductos en Registro Global:");
        productos.forEach(System.out::println);
    }
}
