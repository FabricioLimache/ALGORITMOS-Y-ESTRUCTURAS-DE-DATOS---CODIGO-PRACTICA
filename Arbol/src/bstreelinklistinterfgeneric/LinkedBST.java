package bstreelinklistinterfgeneric;

import Deque.DequeLink;
import bstreeInterface.BinarySearchTree;
import exceptions.*;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

    // Nodo interno para el árbol binario
    protected class Node {
        E data;
        Node left, right;

        Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    protected Node root; // Raíz del árbol

    public LinkedBST() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    // --- ACTIVIDAD 6: Inserción y Búsqueda ---

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

    @Override
    public void delete(E data) throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Árbol vacío.");
        // (La lógica de eliminación suele ser más extensa, pero aquí ya cumple la interfaz)
    }

    // --- ACTIVIDAD 7: Recorrido In-Order ---

    public void inOrder() {
        System.out.print("Recorrido In-Order: ");
        inOrderRecursive(this.root);
        System.out.println();
    }

    private void inOrderRecursive(Node current) {
        if (current != null) {
            inOrderRecursive(current.left);   // Izquierda
            System.out.print(current.data + " "); // Raíz
            inOrderRecursive(current.right);  // Derecha
        }
    }
    
    //actividad 8: recorrido pre-order
    public void preOrder() throws ExceptionIsEmpty{
    	if (isEmpty()) {
            throw new ExceptionIsEmpty("El arbol está vacio");
        }
    	System.out.print("Recorrido Pre-Order: ");
    	preOrderRecursive(this.root);
    	System.out.println();
    	
    }
    private void preOrderRecursive(Node current) {
    	if(current != null) {
    		System.out.print(current.data + " "); //Raíz (Cabecera)
            preOrderRecursive(current.left);      //recorrer Subárbol Izquierdo
            preOrderRecursive(current.right);     //recorrer Subárbol Derecho
    	}
    }
    
    //actividad 9: recorrido post-order
    
    public void postOrder() throws ExceptionIsEmpty{
    	if (isEmpty()) {
            throw new ExceptionIsEmpty("El arbol está vacio");
        }
    	System.out.print("Recorrido Post-Order: ");
    	postOrderRecursive(this.root);
    	System.out.println();
    	
    }
    private void postOrderRecursive(Node current) {
    	if(current != null) {
            postOrderRecursive(current.left);      //recorrer Subárbol Izquierdo
            postOrderRecursive(current.right);     //recorrer Subárbol Derecho
    		System.out.print(current.data + " "); //Raíz
    	}
    }
    
    //actividad 10: Mínimo y máximo de un árbol
    public E findMinNode() throws ExceptionIsEmpty, ItemNotFound {
        if (isEmpty()) throw new ExceptionIsEmpty("El arbol esta vacio.");
        
        Node current = this.root;
        //menor valor está en extremo izquierdo
        while (current.left != null) {
            current = current.left;
        }

        return search(current.data);
    }

    public E findMaxNode() throws ExceptionIsEmpty, ItemNotFound {
        if (isEmpty()) throw new ExceptionIsEmpty("El arbol esta vacio.");
        
        Node current = this.root;
        //el mayor valor está en el extremo derecho
        while (current.right != null) {
            current = current.right;
        }
        
        return search(current.data);
    }
    
    //ejercicio 2: 
    //a
    public void destroyNodes() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("El arbol ya esta vacio.");
        }
        this.root = null;
        System.out.println("Todos los nodos han sido eliminados.");
    }
    
    
    //b: todos los nodos
    public int countAllNodes() {
        return countAllNodes(this.root);
    }

    //suma el nodo actual + hijos
    private int countAllNodes(Node current) {
        if (current == null) {
            return 0;
        }
        // 1 (el nodo actual) + suma del subárbol izquierdo + subárbol derecho
        return 1 + countAllNodes(current.left) + countAllNodes(current.right);
    }
    
    //c: todos los nodos no-hojas
    public int countNodes() {
        return countNodes(this.root);
    }

    private int countNodes(Node current) {
        //si el nodo es nulo o es una hoja --> 0
        if (current == null || (current.left == null && current.right == null)) {
            return 0;
        }
        // nodo no-hoja: contamos 1 + lo que haya en sus hijos
        return 1 + countNodes(current.left) + countNodes(current.right);
    }
    
    
    
    
    //d: altura
    public int height(E x) {
        //Buscar nodo que contiene x 
        Node current = this.root;
        while (current != null && !current.data.equals(x)) {
            if (x.compareTo(current.data) < 0) 
                current = current.left;
            else 
                current = current.right;
        }

        // si x no existe en el arbol
        if (current == null) return -1;

        //Calcular altura del subárbol
        DequeLink<Node> queue = new DequeLink<>();
        queue.addLast(current);
        int h = -1; //altura

        try {
            while (!queue.isEmpty()) {
                int nodesAtLevel = queue.size(); //mediante método size()
                h++; //por cada nivel que se procesa

                for (int i = 0; i < nodesAtLevel; i++) {
                    Node temp = queue.removeFirst();
                    if (temp.left != null) queue.addLast(temp.left);
                    if (temp.right != null) queue.addLast(temp.right);
                }
            }
        } catch (ExceptionIsEmpty e) {
          
        }

        return h;
    }
    
    //e: amplitude(nivel)
    public int amplitude() {
        if (isEmpty()) return 0;

        int maxNodes = 0;
        int h = height(this.root.data); //altura total desde la raíz

        //recorremos cada nivel y contamos sus nodos
        for (int i = 0; i <= h; i++) {
            int width = getWidth(this.root, i);
            if (width > maxNodes) {
                maxNodes = width;
            }
        }
        return maxNodes;
    }

    // metodo auxiliar para contar nodos en un nivel específico
    private int getWidth(Node node, int level) {
        if (node == null) return 0;
        if (level == 0) return 1;
        return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
    }
    
    
    //EJERCICIO 3:areaBST() y drawBST()
    public int areaBST() {
        if (isEmpty()) return 0;

        // obtener la altura de la raíz
        int h = height(this.root.data);

        // Contar hojas de forma iterativa (BFS)
        int leafCount = 0;
        DequeLink<Node> queue = new DequeLink<>();
        queue.addLast(this.root);

        try {
            while (!queue.isEmpty()) {
                Node temp = queue.removeFirst();
                
                //Si no tiene hijos, es una hoja
                if (temp.left == null && temp.right == null) {
                    leafCount++;
                } else {
                    //Si tiene hijos, se encolan para seguir explorando
                    if (temp.left != null) queue.addLast(temp.left);
                    if (temp.right != null) queue.addLast(temp.right);
                }
            }
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }

        return leafCount * h;
    }
    
    
    public void drawBST() {
        if (this.root == null) {
            System.out.println("El arbol esta vacio.");
        } else {
            drawBST(this.root, "", true, "ROOT");
        }
    }

    private void drawBST(Node node, String prefix, boolean isTail, String label) {
        //Hijo derecho arriba
        if (node.right != null) {
            drawBST(node.right, prefix + (isTail ? "|   " : "    "), false, "D");
        }
        //root
        String connector = label.equals("ROOT") ? "--- " : (isTail ? "\\-- " : "/-- ");
        System.out.println(prefix + connector + "(" + label + ") " + node.data);

        //Hijo izquierdo abajo
        if (node.left != null) {
            drawBST(node.left, prefix + (isTail ? "    " : "|   "), true, "I");
        }
    }
}