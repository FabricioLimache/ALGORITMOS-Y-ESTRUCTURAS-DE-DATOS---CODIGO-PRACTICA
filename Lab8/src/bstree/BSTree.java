package bstree;

import bstreeInterface.BinarySearchTree;
import exceptions.*;

public class BSTree<E extends Comparable<E>> implements BinarySearchTree<E> {

    // Clase interna nodo base
    protected class Node {
        public E data;
        public Node left;
        public Node right;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    protected Node root; // Raíz del árbol binario

    public BSTree() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public void insert(E data) throws ItemDuplicated {
        this.root = insertRecursive(this.root, data);
    }

    private Node insertRecursive(Node current, E data) throws ItemDuplicated {
        if (current == null) return new Node(data);
        int res = data.compareTo(current.data);
        if (res == 0) throw new ItemDuplicated("El dato ya existe.");
        if (res < 0) current.left = insertRecursive(current.left, data);
        else current.right = insertRecursive(current.right, data);
        return current;
    }

    @Override
    public E search(E data) throws ItemNotFound {
        return searchRecursive(this.root, data);
    }

    private E searchRecursive(Node current, E data) throws ItemNotFound {
        if (current == null) throw new ItemNotFound("No se encontró el dato.");
        int res = data.compareTo(current.data);
        if (res == 0) return current.data;
        return (res < 0) ? searchRecursive(current.left, data) : searchRecursive(current.right, data);
    }

    public E minRecover() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Árbol vacío");
        return minRecover(this.root).data;
    }

    protected Node minRecover(Node current) {
        if (current.left == null) return current;
        return minRecover(current.left);
    }

    public E maxRecover() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Árbol vacío");
        return maxRecover(this.root).data;
    }

    protected Node maxRecover(Node current) {
        if (current.right == null) return current;
        return maxRecover(current.right);
    }

    @Override
    public void delete(E data) throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Árbol vacío.");
        try {
            this.root = deleteRecursive(this.root, data);
        } catch (ItemNotFound e) {
            System.out.println(e.getMessage());
        }
    }

    private Node deleteRecursive(Node current, E data) throws ItemNotFound {
        if (current == null) throw new ItemNotFound("No se puede eliminar: dato no encontrado.");
        
        int res = data.compareTo(current.data);
        if (res < 0) {
            current.left = deleteRecursive(current.left, data);
        } else if (res > 0) {
            current.right = deleteRecursive(current.right, data);
        } else {
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;

            Node temp = minRecover(current.right);
            current.data = temp.data;
            try {
                current.right = deleteRecursive(current.right, temp.data);
            } catch (ItemNotFound e) { /* No ocurrirá */ }
        }
        return current;
    }

    public void inOrder() {
        System.out.print("Recorrido In-Order BST: ");
        inOrderRecursive(this.root);
        System.out.println();
    }

    protected void inOrderRecursive(Node current) {
        if (current != null) {
            inOrderRecursive(current.left);
            System.out.print(current.data + " ");
            inOrderRecursive(current.right);
        }
    }
}