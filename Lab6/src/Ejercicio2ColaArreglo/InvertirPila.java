public class InvertirPila {
    // invertimos los nodos
    public static <T> void invertir(StackLink<T> pila) {
        ColaEnlazada<T> colaAux = new ColaEnlazada<>();

        // transferimos de pila a cola, e invertimos el orden de la salida

        while (!pila.isEmpty()) {
            colaAux.encolar(pila.pop());
        }
        //transferimos de cola a pila y restablecemos el nuevo orden inverso
        while (!colaAux.estaVacia()) {
            pila.push(colaAux.desencolar());
        }
    }
}
