import java.util.List;
import java.util.Objects;

public class Caja implements Runnable {
    private String caja;
    private List<Cliente> clientes;
    private long initialTime;


    public Caja(String nombre, List<Cliente> clientes, long initialTime) {
        this.caja = nombre;
        this.clientes = clientes;
        this.initialTime = initialTime;
    }

    @Override
    public void run() {
        while (true) {
            Cliente cliente;

            synchronized (clientes) {
                if (clientes.isEmpty()) {
                    break;
                }
                cliente = clientes.remove(0);
            }
            procesarCliente(cliente);
        }
    }

    private void procesarCliente(Cliente cliente) {
        System.out.println(" " + caja + " comienza a pasar al cliente " + cliente.getNombre().toUpperCase() + " en el tiempo: " + (System.currentTimeMillis() - initialTime) + " ms");

        for (String producto : cliente.getListaCompra()) {
            try {
                Thread.sleep(1000);
                System.out.println(" " + caja + " pasando producto: " + producto.toUpperCase() + " de " + cliente.getNombre().toUpperCase() + " - Tiempo: " + (System.currentTimeMillis() - initialTime) + " ms");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(" " + caja + " ha terminado de procesar a " + cliente.getNombre().toUpperCase() + " en el tiempo: " + (System.currentTimeMillis() - initialTime) + " ms");
    }
}