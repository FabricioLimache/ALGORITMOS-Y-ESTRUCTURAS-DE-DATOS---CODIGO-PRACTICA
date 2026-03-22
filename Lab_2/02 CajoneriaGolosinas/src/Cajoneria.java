import java.util.ArrayList;
import java.util.Iterator;

/*contenedor genérico de Cajas
 en lugar de almcnar objtos, almacena objtos Caja<T> dnde cada caja contiene
 un obj de tipo T*/

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
    
    //el metodo equals ya compara por nombre y peso ya que en el 
    //ejecicio 01 ya se modifico el equals() de Golosina para que la comparacion sea por ambos atributos
    
    ////metodo search: 
    public String search(T elemento){
    	for(int i=0; i<cajas.size(); i++)
    		if(cajas.get(i).getObjeto().equals(elemento))
    			return "Posicion: " + (i+1) +", Color: " + cajas.get(i).getColor();    
    	return null;
    }
    
    //metodo delete
    public T delete(T elemento) {
    	for(int i=0; i<cajas.size(); i++ ) {
    		if(cajas.get(i).getObjeto().equals(elemento)) {
    			T objEliminado = cajas.get(i).getObjeto();
    			cajas.remove(i);
    			return objEliminado;
    					
    		}
    	}
    	return null;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %-15s %s%n", "Posicion", "Color Caja", "Objeto"));
        sb.append("-".repeat(60)).append("\n");
        for (int i = 0; i < cajas.size(); i++) {
            sb.append(String.format("%-10d %-15s %s%n",
                (i + 1),
                cajas.get(i).getColor(),
                cajas.get(i).getObjeto()
            ));
        }
        return sb.toString();
    }
    
    
    public int contar(T elemento) {
    	int count = 0;
    	for(Caja<T> caja: cajas) {
    		if(caja.getObjeto().equals(elemento))
    			count++;
    	}
    	return count;
    }
    

    @Override
    public Iterator<Caja<T>> iterator() {
        return cajas.iterator();
    }
}