package Actividad3;

import Actividad1.ExceptionIsEmpty;
public class Test {
	public static void main(String[] args) throws ExceptionIsEmpty {
        PriorityQueue<String, Integer> pq = new PriorityQueueLinkSort<>();

        pq.enqueue("A", 10);
        pq.enqueue("D", 3);
        pq.enqueue("B", 10);
        pq.enqueue("C", 7);
        pq.enqueue("D", 5);

        System.out.println("Cola de prioridad: " + pq);
        System.out.println("Front: " + pq.front()); //mayor prioridad
        System.out.println("Back: " + pq.back());   //menor prioridad

        System.out.println("Dequeue: " + pq.dequeue());
        System.out.println("Cola despues de Dequeue: " + pq);
    }
}
