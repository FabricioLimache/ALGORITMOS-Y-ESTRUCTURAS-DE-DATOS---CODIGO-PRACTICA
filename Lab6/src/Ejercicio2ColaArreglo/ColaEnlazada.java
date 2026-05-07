public class ColaEnlazada<T> {
    private Node<T> primero; // Frente de la cola
    private Node<T> ultimo;  // Final de la cola
    private int capacidad = 5; // Límite de clientes solicitado
    private int tamaño = 0;

    public ColaEnlazada() {
        this.primero = null;
        this.ultimo = null;
    }

    // Inserta un cliente al final si hay espacio
    public boolean encolar(T x) {
        if (tamaño >= capacidad) {
            System.out.println("Cola llena"); // Validación de capacidad máxima
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

    // Retira al cliente del frente para su atención
    public T desencolar() {
        if (estaVacia()) {
            System.out.println("Cola vacía"); // Validación de estructura sin datos
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
