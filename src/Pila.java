import java.util.EmptyStackException;

class Pila<T> {
    private Nodo<T> cima;

    public Pila() {
        cima = null;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public void apilar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            cima = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(cima);
            cima = nuevoNodo;
        }
    }

    public T desapilar() {
        if (estaVacia()) {
            throw new EmptyStackException();
        } else {
            T dato = cima.getDato();
            cima = cima.getSiguiente();
            return dato;
        }
    }
}