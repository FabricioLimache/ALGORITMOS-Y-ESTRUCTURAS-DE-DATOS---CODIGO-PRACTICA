package Actividad2;

import Actividad1.ExceptionIsEmpty;

public class DequeLink<E> implements Deque<E> {
	private Node<E> first;
	private Node<E> last;
	
	public DequeLink() {
		first = null;
		last = null;
	}
	
	
	@Override
	public void addFirst(E x) {
		Node<E> newNode = new Node<E>(x);
		if(isEmpty()) {
			first = newNode;
			last = newNode;
		}else {
			newNode.next = first;
			first = newNode;
		}
		
	}
	
	@Override
	public void addLast(E x) {
		Node<E> newNode = new Node<E>(x);
		if(isEmpty()) {
			first = newNode;
			last = newNode;
		}else {
			last.next = newNode;
			last = newNode;
		}
	}
	
	
	@Override
	public E removeFirst() throws ExceptionIsEmpty{
		if(isEmpty()) throw new ExceptionIsEmpty("Cola vacia");
		
		E data = first.data;
		first = first.next;
		
		//si la cola solo tenia un elemnto y queda vacia la cola
		if(first == null) {
			last = null;
		}
		return data;
	}
	
	@Override
	public E removeLast() throws ExceptionIsEmpty{
		
		//caso vacio
		if(isEmpty()) throw new ExceptionIsEmpty("cola vacia");
		
		//caso un elemnto en la cola
		if(first == last) {
			E data = first.data;
			first = null;
			last = null;
			return data;
		}
		
		//recorrido
		Node<E> currentNode = first;
		while(currentNode.next != last) {
			currentNode = currentNode.next;
		}
		E data = last.data;
		currentNode.next = null;
		last = currentNode;
		return data;
		
	}
	
	@Override
	public E getFirst() throws ExceptionIsEmpty {
		if(isEmpty()) throw new ExceptionIsEmpty("Cola vacia");
		return first.data;
	}
	
	@Override
	public E getLast() throws ExceptionIsEmpty{
		if(isEmpty()) throw new ExceptionIsEmpty("Cola vacia");
		return last.data;
	}
	
	@Override
	public boolean isEmpty() {
		return first == null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
        Node<E> currentNode = first;
        while (currentNode != null) {
            sb.append(currentNode.data);
            if (currentNode.next != null) sb.append(" -> ");
            currentNode = currentNode.next;
        }
        sb.append("]");
        return sb.toString();
	}
	
}
