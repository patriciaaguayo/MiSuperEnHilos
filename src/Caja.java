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

        System.out.printf(" %s comienza a pasar al cliente %s en el tiempo: %.2f segundos%n",
                caja, cliente.getNombre().toUpperCase(), (System.currentTimeMillis() - initialTime) / 1000.0);

        for (String producto : cliente.getListaCompra()) {

            try {

                Thread.sleep(1000);
                System.out.printf(" %s pasando producto: %s de %s - Tiempo: %.2f segundos%n",
                        caja, producto.toUpperCase(), cliente.getNombre().toUpperCase(), (System.currentTimeMillis() - initialTime) / 1000.0);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.printf(" %s ha terminado de procesar a %s en el tiempo: %.2f segundos%n",
                caja, cliente.getNombre().toUpperCase(), (System.currentTimeMillis() - initialTime) / 1000.0);
    }
}