package Actividades;

public class ListLinked<T> {
    Node<T> first;

    public boolean isEmptyList() { return first == null; }

    public void insertFirst(T x) {
        Node<T> newNode = new Node<>(x);
        newNode.next = first;
        first = newNode;
    }

    public void insertLast(T x) {
        if (isEmptyList()) { insertFirst(x); return; }
        Node<T> current = first;
        while (current.next != null) current = current.next;
        current.next = new Node<>(x);
    }

    public boolean search(T x) {
        Node<T> current = first;
        while (current != null) {
            if (current.value.equals(x)) return true;
            current = current.next;
        }
        return false;
    }

    public boolean removeNode(T x) {
        if (isEmptyList()) return false;
        if (first.value.equals(x)) { first = first.next; return true; }
        Node<T> current = first;
        while (current.next != null && !current.next.value.equals(x)) current = current.next;
        if (current.next != null) {
            current.next = current.next.next;
            return true;
        }
        return false;
    }

    public int length() {
        int count = 0;
        Node<T> current = first;
        while (current != null) { count++; current = current.next; }
        return count;
    }

    public void print() {
        Node<T> current = first;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public void reverse() { //invertimos el orden de los nodos
        Node<T> prev = null, current = first, nextNode = null;
        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        first = prev;
    }
}
