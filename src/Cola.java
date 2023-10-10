import java.util.NoSuchElementException;

class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> finalCola;

    public Cola() {
        frente = null;
        finalCola = null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void encolar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.setSiguiente(nuevoNodo);
            finalCola = nuevoNodo;
        }
    }

    public T desencolar() {
        if (estaVacia()) {
            throw new NoSuchElementException();
        } else {
            T dato = frente.getDato();
            frente = frente.getSiguiente();
            return dato;
        }
    }
}