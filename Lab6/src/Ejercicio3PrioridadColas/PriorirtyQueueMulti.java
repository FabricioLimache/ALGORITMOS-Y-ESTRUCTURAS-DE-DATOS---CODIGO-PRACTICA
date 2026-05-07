package Ejercicio3PrioridadColas;

// Importamos la interfaz y la excepción de tu Actividad 1
import Actividad1.Queue;
import Actividad1.ExceptionIsEmpty;

// 1. Nodo simple para la lista enlazada
class Node<E> {
    E data;
    Node<E> next;
    public Node(E data) { this.data = data; this.next = null; }
}

// 2. Implementación de Cola Enlazada que respeta TU interfaz Queue
class QueueLink<E> implements Queue<E> {
    private Node<E> first, last;

    @Override
    public void enqueue(E x) {
        Node<E> newNode = new Node<>(x);
        if (isEmpty()) first = newNode;
        else last.next = newNode;
        last = newNode;
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        E temp = first.data;
        first = first.next;
        if (first == null) last = null;
        return temp;
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        return first.data;
    }

    @Override
    public boolean isEmpty() { 
        return first == null; 
    }
}

// 3. Estructura principal solicitada en el Ejercicio 3
public class PriorirtyQueueMulti<E> {
    // Usamos tu interfaz Queue como tipo de dato del arreglo
    private Queue<E>[] queues;
    private int levels;

    @SuppressWarnings("unchecked")
    public PriorirtyQueueMulti(int levels) {
        this.levels = levels;
        // Se crea el arreglo de interfaces Queue
        queues = new Queue[levels];
        for (int i = 0; i < levels; i++) {
            // Se instancia con listas enlazadas como pide el PDF
            queues[i] = new QueueLink<>();
        }
    }

    public void enqueue(E x, int priority) {
        if (priority >= 0 && priority < levels) {
            queues[priority].enqueue(x);
        } else {
            System.out.println("Prioridad fuera de rango");
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        // Recorrer desde la prioridad más alta (levels - 1) a la más baja (0)
        for (int i = levels - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("Toda la cola de prioridad está vacía");
    }

    // Método de prueba
    public static void main(String[] args) {
        try {
        	PriorirtyQueueMulti<String> pq = new PriorirtyQueueMulti<>(3);
            
            pq.enqueue("A", 0);
            pq.enqueue("B", 2);
            pq.enqueue("C", 1);
            pq.enqueue("D", 2);

            System.out.println("Orden de salida (esperado B, D, C, A):");
            while (true) {
                try {
                    System.out.print(pq.dequeue() + ", ");
                } catch (ExceptionIsEmpty e) {
                    break; 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}