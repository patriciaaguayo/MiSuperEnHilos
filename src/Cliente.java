import java.util.List;

public class Cliente {
    private String nombre;
    private List<String> productos;

    public Cliente(String nombre, List<String> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getProductos() {
        return productos;
    }
}
