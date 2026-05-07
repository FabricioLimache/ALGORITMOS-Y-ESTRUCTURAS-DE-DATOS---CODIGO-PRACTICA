public class InvertirPila {
    // Método estático que realiza la inversión física de los nodos
    public static <T> void invertir(StackLink<T> pila) {
        ColaEnlazada<T> colaAux = new ColaEnlazada<>();

        // Transferencia de Pila a Cola (invierte el orden de salida)
        while (!pila.isEmpty()) {
            colaAux.encolar(pila.pop());
        }

        // Transferencia de Cola a Pila (restablece el nuevo orden inverso)
        while (!colaAux.estaVacia()) {
            pila.push(colaAux.desencolar());
        }
    }
}
