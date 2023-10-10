import java.util.List;

public class ManejoCola {
    public static Cola<Mascota> crearColaDeMascotas(List<Mascota> mascotas) {
        Cola<Mascota> cola = new Cola<>();
        for (Mascota mascota : mascotas) {
            cola.encolar(mascota);
        }
        return cola;
    }

    public static void mostrarCola(Cola<Mascota> cola) {
        System.out.println("Cola de Mascotas:");
        while (!cola.estaVacia()) {
            Mascota mascota = cola.desencolar();
            System.out.println("Nombre: " + mascota.getNombre());
        }
    }

    public static Cola<Mascota> pasarCola(Cola<Mascota> colaOriginal) {
        Cola<Mascota> nuevaCola = new Cola<>();
        while (!colaOriginal.estaVacia()) {
            nuevaCola.encolar(colaOriginal.desencolar());
        }
        return nuevaCola;
    }
}