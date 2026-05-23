package avltree;

import bstree.BSTree;
import exceptions.*;

public class AVLTree<E extends Comparable<E>> extends BSTree<E> {

    //flag
    private boolean height; 

    protected class NodeAVL extends Node {
        protected int bf; 

        public NodeAVL(E data) {
            super(data);
            this.bf = 0;
        }

        @Override
        public String toString() {
            return data + "(bf=" + bf + ")";
        }
    }

    public AVLTree() {
        super();
        this.height = false; // inicialmente sin cambio de altura
    }
    
    //INSERCIÓN
    public void insert(E x) throws ItemDuplicated {
    	this.height = false;
    	this.root = insert(x, (NodeAVL) this.root);
    }
    
    protected Node insert(E x, NodeAVL node) throws ItemDuplicated {
        if (node == null) {
            this.height = true;
            return new NodeAVL(x); // Retornamos el nuevo nodo directamente
        }
        
        int resC = node.data.compareTo(x);
        if (resC == 0) throw new ItemDuplicated(x + " ya está en el árbol");
        
        if (resC < 0) { // Derecha
            node.right = insert(x, (NodeAVL) node.right);
            if (this.height) {
                switch (node.bf) {
                    case -1: node.bf = 0; this.height = false; break;
                    case 0:  node.bf = 1; this.height = true; break;
                    case 1:  node = balanceToLeft(node); this.height = false; break;
                }
            }
        } else { // Izquierda
            node.left = insert(x, (NodeAVL) node.left);
            if (this.height) {
                switch (node.bf) {
                    case 1:  node.bf = 0; this.height = false; break;
                    case 0:  node.bf = -1; this.height = true; break;
                    case -1: node = balanceToRight(node); this.height = false; break;
                }
            }
        }
        return node; // Retornamos el nodo
    }
    
    // implementacion de metodos de balanceo
    private NodeAVL balanceToLeft(NodeAVL node) {
    	NodeAVL hijo = (NodeAVL)node.right;
    	switch(hijo.bf) {
    		case 1: // Caso Derecha-Derecha (Línea recta)
    			node.bf = 0;
    			hijo.bf = 0;
    			node = rotateSL(node);// Una sola rotación izquierda
    			break;
    		case -1:// Caso Derecha-Izquierda (Forma de zigzag, doble rotación)
    			NodeAVL nieto = (NodeAVL)hijo.left;
    			switch(nieto.bf) {
    			case -1:
    				node.bf = 0;
    				hijo.bf = 1; 
    				break;
    			case 0:
    				node.bf = 0;
    				hijo.bf = 0;
    				break;
    			case 1://nieto inclinado
    				node.bf = -1;
    				hijo.bf = 0;
    				break;
    			}
    			nieto.bf = 0; //nieto sube 
    			node.right = rotateSR(hijo);//rotacion derecha en el hijo
    			node = rotateSL(node);//rotacion izquierda en el padre
    	}		
    	return node;
    }
    
    private NodeAVL balanceToRight(NodeAVL node) {
        NodeAVL hijo = (NodeAVL) node.left; 
        
        switch(hijo.bf) {
            case -1: // Caso Izquierda-Izquierda (Línea recta)
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSR(node); //una sola rotación derecha lo equilibra
                break;
                
            case 1: // Caso Izquierda-Derecha (Zigzag izquierdo, requiere doble rotación)
                NodeAVL nieto = (NodeAVL) hijo.right;
                
                // Ajuste simétrico de factores de equilibrio para el espejo izquierdo
                switch(nieto.bf) {
                    case 1:
                        node.bf = 0;
                        hijo.bf = -1;
                        break;
                    case 0:
                        node.bf = 0;
                        hijo.bf = 0;
                        break;
                    case -1:
                        node.bf = 1;
                        hijo.bf = 0;
                        break;
                }
                nieto.bf = 0; // El nieto subirá a la cima del subárbol y queda en 0
                
                // Doble rotación simétrica:
                node.left = rotateSL(hijo); // Rotación izquierda en el hijo para alinearlo
                node = rotateSR(node);      // Rotación derecha en el padre para equilibrar todo
                break;
        }
        return node;
    }
    
    
    
    // rotacion es simples
    //RSL
    private NodeAVL rotateSL(NodeAVL node) {
    	NodeAVL p = (NodeAVL)node.right;
    	node.right = p.left;
    	p.left = node;
    	node = p;
    	return node;
    }
    //RSR
    private NodeAVL rotateSR(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.left;  
        node.left = p.right;             
        p.right = node;                  
        node = p;                        
        return node;
    }
    
    //ELIMINACIÓN
    public void remove(E x) {
        this.height = false; 
        this.root = remove(x, (NodeAVL) this.root);
    }

    protected Node remove(E x, NodeAVL node) {
        if (node == null) return null;

        int resC = node.data.compareTo(x);
        NodeAVL fat = node;

        if (resC > 0) { // Izquierda
            fat.left = (NodeAVL) remove(x, (NodeAVL) node.left);
            if (this.height) { // Si la altura de la izquierda cambió
                switch (fat.bf) {
                    case -1: fat.bf = 0; this.height = true; break;
                    case 0:  fat.bf = 1; this.height = false; break;
                    case 1:  fat = balanceToLeft(fat); this.height = true; break;
                }
            }
        } else if (resC < 0) { // Derecha
            fat.right = (NodeAVL) remove(x, (NodeAVL) node.right);
            if (this.height) { // Si la altura de la derecha cambió
                switch (fat.bf) {
                    case 1:  fat.bf = 0; this.height = true; break;
                    case 0:  fat.bf = -1; this.height = false; break;
                    case -1: fat = balanceToRight(fat); this.height = true; break;
                }
            }
        } else { // Nodo encontrado
            if (node.left == null) { this.height = true; return (NodeAVL) node.right; }
            if (node.right == null) { this.height = true; return (NodeAVL) node.left; }
            
            // Dos hijos: sucesor
            NodeAVL successor = (NodeAVL) minRecover(node.right); // Usando método de BSTree
            fat.data = successor.data;
            
            //Al borrar el sucesor, estamos modificando el lado derecho.
            // Por lo tanto, debemos aplicar la misma lógica de balanceo que usamos para "Derecha"
            fat.right = (NodeAVL) remove(successor.data, (NodeAVL) node.right);
            
            // REBALANCEO: Ahora aplicamos la lógica de reducción de altura por la DERECHA
            if (this.height) {
                switch (fat.bf) {
                    case 1:  fat.bf = 0; this.height = true; break;
                    case 0:  fat.bf = -1; this.height = false; break;
                    case -1: fat = balanceToRight(fat); this.height = true; break;
                }
            }
        }
        return fat;
    }

    public void printTree() {
        if (this.root == null) {
            System.out.println("[Arbol Vacio]");
        } else {
           
            printTree(this.root, "", true);
        }
    }

    private void printTree(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            
            NodeAVL current = (NodeAVL) node;

            System.out.println(prefix + (isLeft ? "+-- " : "\\-- ") + current.data + " (bf=" + current.bf + ")");
           
            if (node.left != null || node.right != null) {
                printTree((NodeAVL) node.left, prefix + (isLeft ? "|   " : "    "), true);
                printTree((NodeAVL) node.right, prefix + (isLeft ? "|   " : "    "), false);
            }
        }
    }
    
}