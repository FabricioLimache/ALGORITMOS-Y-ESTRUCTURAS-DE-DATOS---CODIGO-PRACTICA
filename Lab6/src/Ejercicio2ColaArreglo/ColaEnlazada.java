public class ColaEnlazada<T> {
    private Node<T> primero; // Frente de la cola
    private Node<T> ultimo;  // Final de la cola
    private int capacidad = 5; // Limite de clientes 

    private int tamaño = 0;

    public ColaEnlazada() {
        this.primero = null;
        this.ultimo = null;
    }

    // Inserta un cliente al final si hay espacio
    public boolean encolar(T x) {
        if (tamaño >= capacidad) {
            System.out.println("Cola llena"); // valida capacidad maxima
            return false;
        }
        Node<T> nuevoNodo = new Node<>(x);
        if (estaVacia()) {
            primero = nuevoNodo;
        } else {
            ultimo.next = nuevoNodo;
        }
        ultimo = nuevoNodo;
        tamaño++;
        return true;
    }

    // Retira al cliente del frente para su atencion
    public T desencolar() {
        if (estaVacia()) {
            System.out.println("Cola vacía"); //vaida q la cola no este vacia
            return null;
        }
        T valor = primero.value;
        primero = primero.next;
        if (primero == null) ultimo = null;
        tamaño--;
        return valor;
    }

    public T verFrente() {
        return (estaVacia()) ? null : primero.value; // Retorna el cliente al frente
    }

    public boolean estaVacia() {
        return primero == null;
    }
}
