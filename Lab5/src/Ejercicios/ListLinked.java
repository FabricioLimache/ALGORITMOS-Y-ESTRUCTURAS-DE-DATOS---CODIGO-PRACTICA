package Ejercicios;

public class ListLinked<T> {
	private Node<T> first;
	
	public ListLinked() {
		this.first = null;
	}
	
	public Node<T> getFirst(){
		return this.first;
	}
	public void setFirst(Node<T> first) {
		this.first = first;
	}
	
	//metodos iniciales basicas para pruebas del avance de ejercicios
	public void printLinkedList() {
		Node<T> currentNode = first;
		while(currentNode != null) {
			
			System.out.print(currentNode.data);
			if(currentNode.next != null) {
				System.out.print(" -> ");
			}
			currentNode = currentNode.next;
		}
		System.out.println();
	}
	
	public void insertFirst(T x) {
		Node<T> newNode = new Node<T>(x);
		newNode.next = this.first;
		this.first = newNode;
	}
	
	
}
