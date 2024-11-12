import java.util.List;

public class Caja implements Runnable {
    private String nombre;
    private List<Cliente> clientes;
    private long initialTime;

    public Caja(String nombre, List<Cliente> clientes, long initialTime) {
        this.nombre = nombre;
        this.clientes = clientes;
        this.initialTime = initialTime;
    }

    @Override
    public void run() {
        while (true) {
            Cliente cliente;
            // Bloque sincronizado para que solo un hilo acceda a la lista a la vez
            synchronized (clientes) {
                if (clientes.isEmpty()) {
                    break;  // Salimos del bucle si ya no hay clientes
                }
                cliente = clientes.remove(0);  // Tomamos el siguiente cliente y lo eliminamos de la lista
            }
            procesarCliente(cliente);
        }
    }

    private void procesarCliente(Cliente cliente) {
        System.out.println(nombre + " comienza a procesar al " + cliente.getNombre() + " en el tiempo: " + (System.currentTimeMillis() - initialTime) + " ms");

        for (String producto : cliente.getProductos()) {
            try {
                Thread.sleep(1000);  // Simulamos el tiempo de procesamiento de cada producto
                System.out.println(nombre + " procesando producto: " + producto + " del " + cliente.getNombre() + " - Tiempo: " + (System.currentTimeMillis() - initialTime) + " ms");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(nombre + " ha terminado de procesar al " + cliente.getNombre() + " en el tiempo: " + (System.currentTimeMillis() - initialTime) + " ms");
    }
}