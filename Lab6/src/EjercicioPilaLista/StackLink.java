package EjercicioPilaLista;
import Actividad1.ExceptionIsEmpty;

public class StackLink<E> implements Stack<E>{
	private Node<E> top;
	public StackLink() {
		this.top = null;
	}
	
	@Override
	public void push(E x) {
		Node<E> newNode = new Node<E>(x);
		newNode.setNext(top);
		top = newNode;
		
	}
	@Override
	public E pop() throws ExceptionIsEmpty {
		if(isEmpty()) throw new ExceptionIsEmpty("Stack vacia");
		
		//guardar elemento a eliminar y mover apuntador
		E aux = top.getData();
		top = top.getNext();
		return aux;
	}
	
	@Override
	public E top() throws ExceptionIsEmpty {
		if(isEmpty()) throw new ExceptionIsEmpty("Stack vacio");
		return top.getData();
	}
	@Override
	public boolean isEmpty() {
		return top == null;
	}
	
	
	@Override
    public String toString() {
        //desde el tope hacia abajo
        StringBuilder sb = new StringBuilder();
        Node<E> aux = top;
        while (aux != null) {
        	
        	if(aux.getNext() != null) {
        		sb.append(aux.getData()).append(" -> ");
        		
        	}else {
        		sb.append(aux.getData());
        	}
            aux = aux.getNext();
        }
        return sb.toString();
    }
	
	
}
