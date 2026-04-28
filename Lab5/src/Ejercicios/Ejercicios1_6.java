package Ejercicios;

import java.util.Objects;

public class Ejercicios1_6 {
	//EJERCICIO 1: BUSCAR ELEMENTO GENÉRICO EN UNA LISTA
	public static <T> boolean buscarElemento(ListLinked<T> lista, T valor) {
		
		
		Node<T> currentNode = lista.getFirst();
		
		while(currentNode != null) {
			//uso de Objects, si en caso currentNode.data sea null y evitar NullPointerException
			if(Objects.equals(currentNode.data, valor)) return true;
			currentNode = currentNode.next;
		}
		
		return false;
	}
	
	//EJERCICIO 2: INVERTIR UNA LISTA
	public static <T> ListLinked<T> invertirLista(ListLinked<T> lista){
		ListLinked<T> newList = new ListLinked<>();
		Node<T> currentNode = lista.getFirst();
			
		while (currentNode != null) {
			newList.insertFirst(currentNode.data);
			currentNode = currentNode.next;
		}
		return newList;
	}
	
	
	//EJERCICIO 3: INSERTAR NODE AL FINAL
	public static <T> Node<T> insertarAlFinal(Node<T> head, T valor){
		Node<T> newNode = new Node<T>(valor);
		if(head == null) {
			//nuevo head si la lista esta vacia
			return newNode;
		}
		Node<T> currentNode = head;
		while(currentNode.next != null) {
			currentNode = currentNode.next;
		}
		//enlazar nodo al final
		currentNode.next = newNode;
		return head;
	}
		
	//EJERCICIO 4: Contar NODOS
	public static <T> int contarNodos(Node<T> head) {
		Node<T> currentNode = head;
		int count=0;
		while(currentNode != null) {
			count++;
			currentNode = currentNode.next;
		}
		return count;
	}
	
	//EJERCICIO 5: COMPARAR DOS LISTAS
	public static <T> boolean sonIguales(ListLinked<T> lista1, ListLinked<T> lista2) {
		if (lista1 == null || lista2 == null) return false;

		Node<T> a = lista1.getFirst();
		Node<T> b = lista2.getFirst();
		//listas vacias 
		
		while(a != null && b != null) {
			if(!a.data.equals(b.data)) return false;
			a = a.next;
			b = b.next;
		}
		return a == null && b == null;
	}
	
	
	
	public static void main(String[] args) {
		//prueba ejercicio 01
		//crear lista e insertar elementos
		ListLinked<Integer> lista = new ListLinked<Integer>();
		lista.insertFirst(3);
		lista.insertFirst(4);
		lista.insertFirst(300);
		lista.insertFirst(40);
		
		System.out.println("--------- EJERCICIO 01 ---------\nbuscarElemento(): ");
		
        System.out.println("Contenido de la lista:");
        
		lista.printLinkedList();
		
		//busqueda de elemento
		int valor = 300;
		boolean encontrado = buscarElemento(lista, valor);
        
		
        if (encontrado) {
            System.out.println("El elemento " + valor + " SI esta en la lista");
        } else {
            System.out.println("El elemento " + valor + " NO se encuentra en la lista");
        }
        
        //prueba ejercicio 02
        System.out.println("\n--------- EJERCICIO 02 ---------\ninvertirLista(): ");
        System.out.println("Lista original:");
        lista.printLinkedList(); // suponiendo que tienes un método printList()

        // Invertimos la lista
        ListLinked<Integer> listaInvertida = invertirLista(lista);

        System.out.println("Lista invertida:");
        listaInvertida.printLinkedList();
        
        //prueba ejercicio 03
        System.out.println("\n--------- EJERCICIO 03 ---------\ninsertarAlFinal(): ");
        Node<Integer> head = lista.getFirst();

        System.out.println("Contenido lista original: ");
        
		lista.printLinkedList();
        // Insertar al final 
        head = insertarAlFinal(head, 10);
        head = insertarAlFinal(head, 20);
   
        // Actualizar el first de la lista;
        lista.setFirst(head);
        
        System.out.println("Lista con inserciones al final:");
        lista.printLinkedList();
        
        
        //prueba ejercicio 04
        System.out.println("\n--------- EJERCICIO 04 ---------\ncontarNodos(): ");
        
        int numNodos = contarNodos(lista.getFirst());
        System.out.print("Cantidad de nodos de lista:");
        System.out.println(numNodos);
        
        //prueba ejercicio 05
        System.out.println("\n--------- EJERCICIO 05 ---------\nsonIguales(): ");
        ListLinked<Integer> lista2 = new ListLinked<Integer>();
		lista2.insertFirst(20);
		lista2.insertFirst(10);
		lista2.insertFirst(3);
		lista2.insertFirst(4);
		lista2.insertFirst(300);
		lista2.insertFirst(40);

        System.out.println("Lista 1: ");
        lista.printLinkedList();
        
        System.out.println("Lista 2: ");
        lista2.printLinkedList();
        System.out.println("Resultado: " + sonIguales(lista, lista2));
	}
	
}
