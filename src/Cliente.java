import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private List<String> ListaCompra;

    public Cliente(String nombre) {
        this.nombre = nombre;
        ListaCompra = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getListaCompra() {
        return ListaCompra;
    }

    public void agregarProducto(String producto) {
        ListaCompra.add(producto);
    }
}
