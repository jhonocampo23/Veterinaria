import java.util.List;
import java.util.EmptyStackException;

public class ManejoPila {
    public static Pila<Vacuna> crearPilaDeVacunas(List<Vacuna> vacunas) {
        Pila<Vacuna> pila = new Pila<>();
        for (Vacuna vacuna : vacunas) {
            pila.apilar(vacuna);
        }
        return pila;
    }

    public static void mostrarPila(Pila<Vacuna> pila) {
        System.out.println("Pila de Vacunas:");
        while (!pila.estaVacia()) {
            Vacuna vacuna = pila.desapilar();
            System.out.println("Nombre: " + vacuna.getNombreVacuna());
        }
    }

    public static Pila<Vacuna> pasarPila(Pila<Vacuna> pilaOriginal) {
        Pila<Vacuna> nuevaPila = new Pila<>();
        while (!pilaOriginal.estaVacia()) {
            nuevaPila.apilar(pilaOriginal.desapilar());
        }
        return nuevaPila;
    }

    public static Vacuna obtenerVacunaMayorPrecio(Pila<Vacuna> pila) {
        if (pila.estaVacia()) {
            throw new EmptyStackException();
        }

        Vacuna vacunaMayorPrecio = pila.desapilar();
        while (!pila.estaVacia()) {
            Vacuna vacunaActual = pila.desapilar();
            if (vacunaActual.getPrecioSugerido() > vacunaMayorPrecio.getPrecioSugerido()) {
                vacunaMayorPrecio = vacunaActual;
            }
        }

        return vacunaMayorPrecio;
    }
}