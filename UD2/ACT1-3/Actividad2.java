public class Actividad2 {
    public static void main(String[] args) {
        final int N= 5;
        for (int i = 1; i <= N; i++) {
            Hilo h= new Hilo("Hilo"+i);
            h.run();
        }
        System.out.print("Fin programa");
    }
}

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
