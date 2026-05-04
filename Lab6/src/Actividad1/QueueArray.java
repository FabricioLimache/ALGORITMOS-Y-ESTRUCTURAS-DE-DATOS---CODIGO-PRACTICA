package Actividad1;

public class QueueArray<E> implements Queue<E> {
	private E[] array;
	private int front;
	private int rear;
	private int size;
	
	public QueueArray(int n) {
		array = (E[]) new Object[n];
		front = 0;
		rear = -1;
		size = 0;
	}
	
	//agregar elemento a la cola
	@Override
	public void enqueue(E x) {
		//no se puede agregar si esta lleno
		if(isFull()) return;
		
		//si hay espacios vacios al inicio, rotar indice
		//length = 5, rear = (4 + 1) % 5  --> rear = 0
		rear = (rear + 1) % array.length;
		array[rear] = x;
		size++;
	}
	
	//elimianr elemento de cola
	@Override
	public E dequeue() throws ExceptionIsEmpty {
		if(isEmpty()) {
			throw new ExceptionIsEmpty("Cola Vacia, no hay elementos que eliminar en la cola");
		}
		
		//almacenar elemento a eliminar
		E data = array[front];
		array[front] = null;
		front = (front + 1) % array.length;
		size--;
		return data;
	}
	
	@Override
	public E front() throws ExceptionIsEmpty {
		if(isEmpty()) throw new ExceptionIsEmpty("Cola Vacia");
		return array[front];
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;	
	}
	

	public boolean isFull() {
		return size == array.length;
	}
	

	
	@Override
	public String toString() {
		if (isEmpty()) return "[]";
	    StringBuilder sb = new StringBuilder("[");
	    for (int i = 0; i < size; i++) {
	        int index = (front + i) % array.length;
	        sb.append(array[index]);
	        if (i < size - 1) sb.append(", ");
	    }
	    sb.append("]");
	    return sb.toString();
	}
	
}
