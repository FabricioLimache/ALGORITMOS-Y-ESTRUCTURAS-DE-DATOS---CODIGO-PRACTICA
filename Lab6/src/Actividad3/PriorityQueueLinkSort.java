package Actividad3;
import Actividad1.ExceptionIsEmpty;

public class PriorityQueueLinkSort<E,N extends Comparable<N>> implements PriorityQueue<E, N> {
	
	//clase interna para agrupar data  y prioridad
	class EntryNode{
		E data;
		N priority;
		
		EntryNode(E data, N priority){
			this.data = data;
			this.priority = priority;
		}
		
		@Override
		public String toString() {
			return "(" + data + ", pr=" + priority +")";
		}
	}
	
	private Node<EntryNode> first; //mayor prio
	private Node<EntryNode> last; // menor prio
	
	public PriorityQueueLinkSort() {
		this.first = null;
		this.last = null;
	}
	
	
	@Override
	public void enqueue(E x, N pr) {
		EntryNode entry = new EntryNode(x, pr);
		Node<EntryNode> newNode = new Node<EntryNode>(entry);
		
		if(isEmpty()) {
			first = newNode;
			last = newNode;
			return;
		}
		
		//insercion ordenado por prioridad: mayor prioridad en first
		//N comparable en esta clase (pr)
		if(pr.compareTo(first.getData().priority) > 0) {
			newNode.setNext(first);
			first = newNode;
			return;
		}
		
		Node<EntryNode> prev = first;
		Node<EntryNode> currentNode = first.getNext();
		
		//mientras prioridad sea menor o igual 
		while(currentNode != null && pr.compareTo(currentNode.getData().priority) <= 0) {
			prev = currentNode;
			currentNode = currentNode.getNext();
		}
		
		//insertar entre prev y currentNode
		newNode.setNext(currentNode);
		prev.setNext(newNode);
		
		//si currentNode es null, se insertó al final
		if(currentNode == null) {
			last = newNode;
		}
	}


	@Override
	public E dequeue() throws ExceptionIsEmpty {
		if(isEmpty()) throw new ExceptionIsEmpty("Queue vacia");
		
		E aux = first.getData().data;
		first = first.getNext();
		if(first == null) {
			last = null;
		}
		return aux;
	}


	@Override
	public E front() throws ExceptionIsEmpty {
		if(isEmpty()) throw new ExceptionIsEmpty("Queue vacia");
		return first.getData().data;
	}


	@Override
	public E back() throws ExceptionIsEmpty {
		if(isEmpty()) throw new ExceptionIsEmpty("Queue vacia");
		return last.getData().data;
	}


	@Override
	public boolean isEmpty() {
		return first == null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<EntryNode> aux = first;
		while(aux != null) {
			sb.append(aux.getData().toString()).append("-->");
			aux = aux.getNext();
		}
		return sb.toString();
	}
	
}
