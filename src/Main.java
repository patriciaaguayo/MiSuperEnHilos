//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Creación de clientes con su lista de productos

        Cliente cliente1 = new Cliente("Cliente 1", Arrays.asList("Producto A", "Producto B", "Producto C", "Producto D", "Producto E"));
        Cliente cliente2 = new Cliente("Cliente 2", Arrays.asList("Producto F", "Producto G", "Producto H", "Producto I", "Producto J"));
        Cliente cliente3 = new Cliente("Cliente 3", Arrays.asList("Producto K", "Producto L", "Producto M", "Producto N", "Producto O"));
        Cliente cliente4 = new Cliente("Cliente 4", Arrays.asList("Producto P", "Producto Q", "Producto R", "Producto S", "Producto T"));
        Cliente cliente5 = new Cliente("Cliente 5", Arrays.asList("Producto U", "Producto V", "Producto W", "Producto X", "Producto Y"));

        // Creación de las cajas

        Caja caja1 = new Caja("Caja 1");
        Caja caja2 = new Caja("Caja 2");

        // Tiempo inicial para el procesamiento

        long initialTime = System.currentTimeMillis();

        // Asignación de clientes a cajas y procesamiento en hilos

        caja1.procesarCliente(cliente1, initialTime);
        caja2.procesarCliente(cliente2, initialTime);
        caja1.procesarCliente(cliente3, initialTime);
        caja2.procesarCliente(cliente4, initialTime);
        caja1.procesarCliente(cliente5, initialTime);
    }
}