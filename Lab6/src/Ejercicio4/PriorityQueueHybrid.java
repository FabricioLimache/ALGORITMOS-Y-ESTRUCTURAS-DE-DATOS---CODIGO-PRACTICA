package Ejercicio4;


//Reutilizamos tu excepción de la Actividad 1
import Actividad1.ExceptionIsEmpty;

public class PriorityQueueHybrid<E, V extends Comparable<V>> {
 
 // 1. Nodo interno que guarda el dato y el valor secundario
 private static class SortedNode<E, V> {
     E data;
     V secValue;
     SortedNode<E, V> next;
     
     public SortedNode(E data, V secValue) {
         this.data = data;
         this.secValue = secValue;
         this.next = null;
     }
 }

 // 2. Lista enlazada que inserta ordenando por el valor secundario (menor a mayor)
 private static class SortedQueue<E, V extends Comparable<V>> {
     SortedNode<E, V> front;

     public void enqueueSorted(E data, V value) {
         SortedNode<E, V> newNode = new SortedNode<>(data, value);
         
         if (front == null || value.compareTo(front.secValue) < 0) {
             newNode.next = front;
             front = newNode;
         } else {
             SortedNode<E, V> current = front;
             while (current.next != null && current.next.secValue.compareTo(value) <= 0) {
                 current = current.next;
             }
             newNode.next = current.next;
             current.next = newNode;
         }
     }

     public E dequeue() throws ExceptionIsEmpty {
         if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
         E temp = front.data;
         front = front.next;
         return temp;
     }
     
     public boolean isEmpty() { 
         return front == null; 
     }
 }

 // 3. Estructura principal
 private SortedQueue<E, V>[] queues;
 private int levels;

 @SuppressWarnings("unchecked")
 public PriorityQueueHybrid(int levels) {
     this.levels = levels;
     queues = new SortedQueue[levels];
     for (int i = 0; i < levels; i++) {
         queues[i] = new SortedQueue<>();
     }
 }

 public void enqueue(E item, int priority, V secondaryValue) {
     if (priority >= 0 && priority < levels) {
         queues[priority].enqueueSorted(item, secondaryValue);
     } else {
         System.out.println("Prioridad fuera de rango");
     }
 }

 public E dequeue() throws ExceptionIsEmpty {
     for (int i = levels - 1; i >= 0; i--) {
         if (!queues[i].isEmpty()) {
             return queues[i].dequeue();
         }
     }
     throw new ExceptionIsEmpty("La cola híbrida está vacía");
 }

 // Método de prueba
 public static void main(String[] args) {
     try {
         PriorityQueueHybrid<String, Integer> pqh = new PriorityQueueHybrid<>(3);
         
         pqh.enqueue("A", 2, 5);
         pqh.enqueue("B", 2, 1);
         pqh.enqueue("C", 1, 3);
         pqh.enqueue("D", 2, 3);

         System.out.println("Orden de salida (esperado B, D, A, C):");
         while (true) {
             try {
                 System.out.print(pqh.dequeue() + ", ");
             } catch (ExceptionIsEmpty e) {
                 break;
             }
         }
     } catch (Exception e) {
         e.printStackTrace();
     }
 }
}