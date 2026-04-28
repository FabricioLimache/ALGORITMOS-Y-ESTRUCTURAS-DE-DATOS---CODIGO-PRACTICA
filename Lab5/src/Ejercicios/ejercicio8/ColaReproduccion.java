package ejercicio8;

import java.util.Random;

public class ColaReproduccion<T> {
    private NodeDoble<T> head;
    private NodeDoble<T> tail;
    private NodeDoble<T> actual; // Puntero a la canción que se está reproduciendo
    private int size;

    public ColaReproduccion() {
        this.head = null;
        this.tail = null;
        this.actual = null;
        this.size = 0;
    }

    // 4. Agregar al final de la cola
    public void agregarCancion(T cancion) {
        NodeDoble<T> newNode = new NodeDoble<>(cancion);
        if (head == null) {
            head = newNode;
            tail = newNode;
            actual = head; // Por defecto la actual es la primera al iniciar
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // 5. Avanzar al siguiente nodo
    public T reproducirSiguiente() {
        if (actual != null && actual.next != null) {
            actual = actual.next;
            return actual.value;
        }
        return null; 
    }

    // 6. Retroceder al nodo anterior
    public T reproducirAnterior() {
        if (actual != null && actual.prev != null) {
            actual = actual.prev;
            return actual.value;
        }
        return null;
    }

    // 7. Mezclar (Fisher-Yates)
    public void mezclar() {
        if (size <= 1) return;

        // Extraemos los valores a un arreglo temporal para aplicar Fisher-Yates en O(N)
        Object[] arregloTemp = new Object[size];
        NodeDoble<T> temp = head;
        int idx = 0;
        while (temp != null) {
            arregloTemp[idx++] = temp.value;
            temp = temp.next;
        }

        Random rand = new Random();
        for (int i = size - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            // Intercambio
            Object swap = arregloTemp[i];
            arregloTemp[i] = arregloTemp[j];
            arregloTemp[j] = swap;
        }

        // Volcamos los valores mezclados de vuelta a los nodos sin romper los enlaces
        temp = head;
        idx = 0;
        while (temp != null) {
            @SuppressWarnings("unchecked")
            T valorCasteado = (T) arregloTemp[idx++];
            temp.value = valorCasteado;
            temp = temp.next;
        }
        
        actual = head; // Reseteamos la reproducción al inicio de la nueva cola mezclada
    }

    // 8. Imprimir todas las canciones
    public void mostrarCola() {
        NodeDoble<T> temp = head;
        int index = 1;
        while (temp != null) {
            if (temp == actual) {
                System.out.println("► Reproduciendo ahora: " + temp.value);
            } else {
                System.out.println(index + ". " + temp.value);
            }
            temp = temp.next;
            index++;
        }
    }

    // 9. Retorna la suma de las duraciones
    public int duracionTotal() {
        int total = 0;
        NodeDoble<T> temp = head;
        while (temp != null) {
            // Verificamos que el tipo genérico sea una instancia de Cancion
            if (temp.value instanceof Cancion) {
                total += ((Cancion) temp.value).getDuracionSeg();
            }
            temp = temp.next;
        }
        return total;
    }
}