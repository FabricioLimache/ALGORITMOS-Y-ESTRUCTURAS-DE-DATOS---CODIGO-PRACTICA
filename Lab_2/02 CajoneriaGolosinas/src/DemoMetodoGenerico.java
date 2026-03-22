public class DemoMetodoGenerico {

    // compara dos arreglos del mismo tipo T para ver si son idénticos
    public static <T extends Comparable<T>> boolean igualArrays(T[] x, T[] y) {
        // Si no miden lo mismo, es imposible que sean iguales
        if (x.length != y.length)
            return false;

        for (int i = 0; i < x.length; i++) {
            /*
             * Usamos la función equals aquí para comparar el contenido real de los objetos
             * Si un elemento no coincide, devolvemos false de inmediato.
             */
            if (!x[i].equals(y[i]))
                return false;
        }
        // Si el for termina, significa que todo es equivalente
        return true;
    }

    // EJERCICIO 1: exist()
    public static <T> boolean exist(T[] arreglo, T elemento) {
        for (T item : arreglo) {
            if (item.equals(elemento))
                return true;
        }
        return false;
    }
}
