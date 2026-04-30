package Actividades;

public class GestorDeTareas<T> {
    public ListLinked<T> lista = new ListLinked<>();

    public void agregarTarea(T tarea) { lista.insertLast(tarea); }
    public boolean eliminarTarea(T tarea) { return lista.removeNode(tarea); }
    public boolean contieneTarea(T tarea) { return lista.search(tarea); }
    public void imprimirTareas() { lista.print(); }
    public int contarTareas() { return lista.length(); }
    public void invertirTareas() { lista.reverse(); }

    public T obtenerTareaMasPrioritaria() {
        if (lista.isEmptyList()) return null;
        Node<T> current = lista.first;
        T masPrioritaria = current.value;
        while (current != null) {
            if (((Comparable<T>) current.value).compareTo(masPrioritaria) < 0) {
                masPrioritaria = current.value;
            }
            current = current.next;
        }
        return masPrioritaria;
    }
}
