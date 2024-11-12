import java.util.List;

public class Cliente {
    private String nombre;
    private List<String> productos;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getProductos() {
        return productos;
    }

    public void agregarProducto(String producto) {
        productos.add(producto);
    }
}
