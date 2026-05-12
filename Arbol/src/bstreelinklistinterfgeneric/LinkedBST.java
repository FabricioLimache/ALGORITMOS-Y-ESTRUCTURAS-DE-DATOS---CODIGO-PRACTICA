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
    
}

//==========================================
// --- EJERCICIO 03 ---
// ==========================================

// a. Método iterativo para calcular el área (Hojas * Altura)
public int areaBST() {
    if (this.root == null) {
        return 0;
    }

    int leafCount = 0;
    int height = -1; 
    
    DequeLink<Node> queue = new DequeLink<>();
    queue.addLast(this.root);

    while (!queue.isEmpty()) {
        int levelSize = queue.size(); 
        height++; 

        for (int i = 0; i < levelSize; i++) {
            try {
                Node current = queue.removeFirst(); 

                if (current.left == null && current.right == null) {
                    leafCount++;
                }
                
                if (current.left != null) {
                    queue.addLast(current.left);
                }
                if (current.right != null) {
                    queue.addLast(current.right);
                }
            } catch (ExceptionIsEmpty e) {
                System.out.println("Error interno: " + e.getMessage());
            }
        }
    }
    return leafCount * height;
}

// b. Dibujar el BST usando parenthesize()
public void drawBST() {
    System.out.println("Representacion visual del BST:");
    parenthesize();
}


// ==========================================
// --- EJERCICIO 04 ---
// ==========================================

// Representación entre paréntesis con sangría
public void parenthesize() {
    if (this.root == null) {
        System.out.println("Arbol vacio");
        return;
    }
    parenthesizeHelper(this.root, 0);
}

private void parenthesizeHelper(Node node, int level) {
    if (node == null) return;

    for (int i = 0; i < level; i++) {
        System.out.print("  "); 
    }

    System.out.print(node.data);

    if (node.left != null || node.right != null) {
        System.out.println(" (");
        parenthesizeHelper(node.left, level + 1);
        parenthesizeHelper(node.right, level + 1);
        
        for (int i = 0; i < level; i++) {
            System.out.print("  "); 
        }
        System.out.println(")");
    } else {
        System.out.println();
    }
}

// Verificación de propiedades del BST
public boolean isValidBST() {
    DequeLink<Node> stack = new DequeLink<>();
    Node current = this.root;
    Node prev = null; 

    while (current != null || !stack.isEmpty()) {
        while (current != null) {
            stack.addFirst(current); 
            current = current.left;
        }

        try {
            current = stack.removeFirst(); 

            if (prev != null && ((Comparable<E>) current.data).compareTo(prev.data) <= 0) {
                return false; 
            }

            prev = current;
            current = current.right;

        } catch (ExceptionIsEmpty e) {
             System.out.println("Error interno en la pila: " + e.getMessage());
             break;
        }
    }
    return true; 
}


// ==========================================
// --- EJERCICIO 05: Caso Aplicado Inventario ---
// ==========================================

// b. Búsqueda por rango
public void searchRange(E min, E max) {
    System.out.print("Productos en rango [" + min + " - " + max + "]: ");
    searchRangeHelper(this.root, min, max);
    System.out.println();
}

private void searchRangeHelper(Node node, E min, E max) {
    if (node == null) return;

    if (node.data.compareTo(min) > 0) {
        searchRangeHelper(node.left, min, max);
    }
    
    if (node.data.compareTo(min) >= 0 && node.data.compareTo(max) <= 0) {
        System.out.print(node.data + " ");
    }

    if (node.data.compareTo(max) < 0) {
        searchRangeHelper(node.right, min, max);
    }
}

// c. Contar hojas (reutiliza logica, adaptado de iterativo)
public int countLeaves() {
    if (this.root == null) return 0;
    
    int leafCount = 0;
    DequeLink<Node> queue = new DequeLink<>();
    queue.addLast(this.root);

    while (!queue.isEmpty()) {
        try {
            Node current = queue.removeFirst(); 
            
            if (current.left == null && current.right == null) {
                leafCount++;
            }
            if (current.left != null) queue.addLast(current.left);
            if (current.right != null) queue.addLast(current.right);
            
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error al contar hojas: " + e.getMessage());
        }
    }
    return leafCount;
}

// d. Mostrar en orden descendente
public void printDescending() {
    System.out.print("Productos en orden descendente: ");
    printDescendingHelper(this.root);
    System.out.println();
}

private void printDescendingHelper(Node node) {
    if (node == null) return;
    
    printDescendingHelper(node.right);  
    System.out.print(node.data + " ");  
    printDescendingHelper(node.left);   
}