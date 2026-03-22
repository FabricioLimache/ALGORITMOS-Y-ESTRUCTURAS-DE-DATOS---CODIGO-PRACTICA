import java.util.ArrayList;
import java.util.Iterator;

/*contenedor genérico de Cajas
 Cada caja tiene un color y almacena un objeto de tipo T */

public class Cajoneria<T> implements Iterable<Caja<T>> {
    private ArrayList<Caja<T>> cajas = new ArrayList<>();
    private int tope;
    
    public Cajoneria(int tope) {
    	this.tope = tope;
    }

    public void add(String color, T objeto) {
    	if (cajas.size() < tope) {
            cajas.add(new Caja<>(color, objeto));
        } else {
            throw new RuntimeException("no caben más cajas");
        }
    }

    @Override
    public Iterator<Caja<T>> iterator() {
        return cajas.iterator();
    }
}