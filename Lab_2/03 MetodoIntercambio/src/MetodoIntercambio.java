public class MetodoIntercambio {

    // metodo generico <T> que intercambia dos posiciones en cualquier arreglo de objetos
    public static <T> void swap(T[] arreglo, int i, int j) {

        // Primero validamos que los índices i y j estén dentro del rango real del arreglo
        if (i < 0 || i >= arreglo.length || j < 0 || j >= arreglo.length) {
            System.out.println("Error: Uno de los índices está fuera de los límites.");
            return;
        }

        /* Guardamos temporalmente el elemento en la posición i,
        usamos el tipo T para que el compilador sepa que es el mismo tipo del arreglo
        y así evitamos hacer conversiones manuales (casting).
        */
        T temporal = arreglo[i];

        // Hacemos el intercambio de valores entre las posiciones i y j
        arreglo[i] = arreglo[j];
        arreglo[j] = temporal;
    }

    // Imprimimos el arreglo
    public static <T> void imprimirArreglo(T[] arreglo) {
        System.out.print("[");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + (i < arreglo.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
