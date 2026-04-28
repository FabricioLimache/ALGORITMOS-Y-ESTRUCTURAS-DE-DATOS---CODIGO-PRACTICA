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
	
	//EJERCICIO 2: BUSCAR ELEMENTO GENÉRICO EN UNA LISTA
		public static <T> ListLinked<T> invertirLista(ListLinked<T> lista){
			ListLinked<T> newList = new ListLinked<>();
			Node<T> currentNode = lista.getFirst();
			
			while (currentNode != null) {
				newList.insertFirst(currentNode.data);
				currentNode = currentNode.next;
			}
			return newList;
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
      
        
	}
	
}
