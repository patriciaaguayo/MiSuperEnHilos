public class Caja implements Runnable {
    private String nombre;
    private Cliente cliente;
    private long initialTime;

    public Caja(String nombre) {
        this.nombre = nombre;
    }

    public void procesarCliente(Cliente cliente, long initialTime) {
        this.cliente = cliente;
        this.initialTime = initialTime;
        new Thread(this).start();  // Se inicia el hilo de procesamiento
    }

    @Override
    public void run() {
        System.out.println("La " + nombre + " comienza a procesar al cliente " + cliente.getNombre() + " en el tiempo: " + (System.currentTimeMillis() - initialTime) + "ms");

        for (String producto : cliente.getProductos()) {
            procesarProducto(producto);
        }

        System.out.println("La " + nombre + " ha terminado de procesar al cliente " + cliente.getNombre() + " en el tiempo: " + (System.currentTimeMillis() - initialTime) + "ms");
    }

    private void procesarProducto(String producto) {
        try {
            Thread.sleep(1000);  // Simulamos el tiempo de procesamiento de cada producto
            System.out.println(nombre + " procesando producto: " + producto + " del cliente " + cliente.getNombre() + " - Tiempo: " + (System.currentTimeMillis() - initialTime) + "ms");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
