package Actividad1;

public class TestQueue {
	public static void main(String[] args) {
        try {
            //prueba con Cola de enteros
            QueueArray<Integer> intQueue = new QueueArray<>(5);
            //System.out.println("Cola de Strings, front: " + intQueue.front()) ; // throw ExceptionIsEmpty, cola vacia 
            intQueue.enqueue(10);
            intQueue.enqueue(20);
            intQueue.enqueue(30);
            System.out.println("Cola de enteros: " + intQueue);

            intQueue.dequeue();
            System.out.println("Cola despues de dequeue: " + intQueue);

            intQueue.enqueue(40);
            intQueue.enqueue(50);
            intQueue.enqueue(60); //rear rota al inicio -> indice rear = 0
            System.out.println("Cola llena: " + intQueue);

            //cola de Strings
            System.out.println("------------------------------------------------");
            QueueArray<String> strQueue = new QueueArray<>(4);
            strQueue.enqueue("A");
            strQueue.enqueue("B");
            strQueue.enqueue("C");
            System.out.println("Cola de Strings: " + strQueue);

            strQueue.dequeue(); //[B, C]
            strQueue.enqueue("D");
            strQueue.enqueue("E"); //rear rota a 0
            System.out.println("Cola de Strings despues de operaciones: " + strQueue);
            System.out.println("Cola de Strings, front: " + strQueue.front()) ;

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
	}
}
