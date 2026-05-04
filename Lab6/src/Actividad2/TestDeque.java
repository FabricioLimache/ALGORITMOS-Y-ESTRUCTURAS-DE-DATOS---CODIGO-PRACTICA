package Actividad2;

import Actividad1.ExceptionIsEmpty;
public class TestDeque {
	public static void main(String[] args) {
		try {
            //prueba de funcionamiento con enteros
            DequeLink<Integer> intDeque = new DequeLink<>();
            intDeque.addFirst(10);
            intDeque.addLast(20); 
            intDeque.addFirst(5); //[5 -> 10 -> 20]
            System.out.println("Deque de enteros: " + intDeque);

            System.out.println("Primer elemento: " + intDeque.getFirst());//5
            System.out.println("Ultimo elemento: " + intDeque.getLast());  //20

            intDeque.removeFirst(); //elimina 5 → [10 -> 20]
            System.out.println("Despues de removeFirst: " + intDeque);

            intDeque.removeLast();  //elimina 20 → [10]
            System.out.println("Despues de removeLast: " + intDeque);

            //prueba de funcionamiento con Strings
            System.out.println("------------------------------------");
            DequeLink<String> strDeque = new DequeLink<>();
            strDeque.addLast("A");
            strDeque.addLast("B"); 
            strDeque.addFirst("Z"); //[Z -> A -> B]
            System.out.println("Deque de Strings: " + strDeque);

            System.out.println("Primer elemento: " + strDeque.getFirst()); //Z
            System.out.println("Ultimo elemento: " + strDeque.getLast()); //B

            strDeque.removeLast(); //elimina B → [Z -> A]
            System.out.println("Despues de removeLast: " + strDeque);

            strDeque.removeFirst(); //elimina Z → [A]
            System.out.println("Despues de removeFirst: " + strDeque);

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
	}
}
