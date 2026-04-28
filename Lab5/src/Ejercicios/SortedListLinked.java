package Ejercicios;

public class SortedListLinked<T extends Comparable<T>> extends ListLinked<T> {
	public void insertOrden(T x) {
		Node<T> newNode = new Node<T>(x);
		if(this.getFirst() == null) {
			this.setFirst(newNode);
			return;
		}
		if(x.compareTo(this.getFirst().data) <= 0) {
			newNode.next = this.getFirst();
			this.setFirst(newNode);
			return;
		}
		
		Node<T> prevNode =  this.getFirst();
		Node<T> currentNode = this.getFirst().next;
		while(currentNode != null && x.compareTo(currentNode.data) > 0) {
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		newNode.next = currentNode;
		prevNode.next = newNode;
		
	}
	
	public static void main(String[] args) {
		
		//pueba ejercicio 7
		
		SortedListLinked<Integer> listaOrdenada = new SortedListLinked<Integer>();
		listaOrdenada.insertOrden(5);
	    listaOrdenada.insertOrden(69);
	    listaOrdenada.insertOrden(10);
	    listaOrdenada.insertOrden(35);
	    listaOrdenada.insertOrden(30);
	    listaOrdenada.insertOrden(5);
	    listaOrdenada.insertOrden(5);
	    listaOrdenada.insertOrden(3);

	    //verificar el orden
	    System.out.println("Lista ordenada:");
	    listaOrdenada.printLinkedList();
	}
}
