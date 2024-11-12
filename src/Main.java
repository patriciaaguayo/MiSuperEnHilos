//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();

        // Creación de clientes con su lista de productos

        Cliente cliente1 = new Cliente("Juana la Loca");

        cliente1.agregarProducto("Cereales");
        cliente1.agregarProducto("Huevos");
        cliente1.agregarProducto("Leche");
        cliente1.agregarProducto("Pan");
        cliente1.agregarProducto("Tomate");

        Cliente cliente2 = new Cliente("Anastasio");

        cliente2.agregarProducto("Pescado");
        cliente2.agregarProducto("Pimientos");
        cliente2.agregarProducto("Galletas");
        cliente2.agregarProducto("Yogurt");
        cliente2.agregarProducto("Agua");

        Cliente cliente3 = new Cliente("Dora Exploradora");

        cliente3.agregarProducto("Ajo");
        cliente3.agregarProducto("Tarta");
        cliente3.agregarProducto("Canela");
        cliente3.agregarProducto("Helados");
        cliente3.agregarProducto("Leche");

        Cliente cliente4 = new Cliente("Paco Porros");

        cliente4.agregarProducto("Galletas");
        cliente4.agregarProducto("Porros");
        cliente4.agregarProducto("María");
        cliente4.agregarProducto("Coca");
        cliente4.agregarProducto("LSD");

        Cliente cliente5 = new Cliente("Vampira Anémica");

        cliente5.agregarProducto("Sangre");
        cliente5.agregarProducto("Cuerpo");
        cliente5.agregarProducto("Dientes");
        cliente5.agregarProducto("Piel");
        cliente5.agregarProducto("Vampirismo");

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        clientes.add(cliente5);

        // Tiempo inicial de la simulación

        long initialTime = System.currentTimeMillis();

         // Crear y lanzar hilos de cajas

        Thread caja1Thread = new Thread(new Caja("Caja 1", clientes, initialTime));
        Thread caja2Thread = new Thread(new Caja("Caja 2", clientes, initialTime));

        System.out.println("");

        caja1Thread.start();
        caja2Thread.start();

        try {

            caja1Thread.join();
            caja2Thread.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n Han terminado de procesar a todos los clientes en el tiempo: " + (System.currentTimeMillis() - initialTime) + " ms");

    }
}