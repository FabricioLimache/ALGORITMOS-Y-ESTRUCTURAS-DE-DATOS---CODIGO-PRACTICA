import java.util.ArrayList;
import java.util.Iterator;

// Implementamos Iterable para poder usar el for-each en el main sin problemas
public class Bolsa<T> implements Iterable<T> {
    private ArrayList<T> lista = new ArrayList<>();
    private int tope;

    // Definimos el máximo de elementos que aguantará esta instancia
    public Bolsa(int tope) {
        this.tope = tope;
    }

    public void add(T objeto) {
        // Verificamos si todavía hay espacio comparando el tamaño actual con el tope
        if (lista.size() < tope) {
            lista.add(objeto);
        } else {
            // Si ya no entra nada, lanzamos el error para avisar que está llena
            throw new RuntimeException("no caben más");
        }
    }

    @Override
    public Iterator<T> iterator() {
        // Esto permite que la bolsa sea recorrida fácilmente como una lista normal
        return lista.iterator();
    }
}
