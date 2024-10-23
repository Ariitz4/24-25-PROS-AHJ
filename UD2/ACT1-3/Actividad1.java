
public class Actividad1 {
    public static void main(String[] args) {
        Hilo hilo1 = new Hilo("Primero");
        Hilo hilo2 = new Hilo("Segundo");

        hilo1.start();
        hilo2.start();

        System.out.print("Fin programa");
    }
}

// Hilo.java

class Hilo extends Thread {
    private String nombre;

    public Hilo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println(nombre + " " + i);
        }
    }
}
