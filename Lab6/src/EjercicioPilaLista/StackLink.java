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
		newNode.setNext(top); // newNode apuntando a top
		top = newNode;//newNode nuevo top
		
	}
	@Override
	public E pop() throws ExceptionIsEmpty {
		//caso con pila vacia
		if(isEmpty()) throw new ExceptionIsEmpty("Stack vacia");
		
		//guardar dato de nodo a eliminar y mover apuntador top al siguiente
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
