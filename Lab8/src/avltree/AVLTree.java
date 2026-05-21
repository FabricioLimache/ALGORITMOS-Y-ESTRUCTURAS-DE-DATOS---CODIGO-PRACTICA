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


    private NodeAVL leftChild(NodeAVL node) {
        return (node == null) ? null : (NodeAVL) node.left;
    }

    private NodeAVL rightChild(NodeAVL node) {
        return (node == null) ? null : (NodeAVL) node.right;
    }
    
    //INSERCIÓN
    public void insert(E x) throws ItemDuplicated {
    	this.height = false;
    	this.root = insert(x, (NodeAVL) this.root);
    }
    
    protected Node insert(E x, NodeAVL node) throws ItemDuplicated {
    	NodeAVL fat = node;
    	
    	if(node == null) {
    		this.height = true;
    		fat = new NodeAVL(x);
    	}
    	else {
    		//control de duplicados
    		int resC = node.data.compareTo(x);
    		if(resC==0) throw new ItemDuplicated(x + "Ya se encuentra en el arbol...");
    		
    		if(resC < 0) {// rama derecha
    			fat.right = insert(x, (NodeAVL) node.right);
    			if(this.height)
    				switch(fat.bf) {
	    				case -1: 
	    					fat.bf = 0;
	    					this.height = false;
	    					break;
	    				case 0: 
	    					fat.bf = 1;
	    					this.height = true;
	    					break;
	    				case 1: //bf = 2
	    					//resolver desbalance del arbol derecho
	    					balanceToLeft(fat);
	    					this.height = false;
	    					break;
	    			}
    		}else { //Rama izquierda
    			fat.left = insert(x, (NodeAVL)node.left);
    			if(this.height)
    				switch(fat.bf) {
    				case 1: 
    					fat.bf = 0;
    					this.height = false;
    					break;
    				case 0:
    					fat.bf = -1;
    					this.height = true;
    					break;
    				case -1:
    					//resolver desbalance del arbol izquierdo
    					balanceToRight(fat);
    					this.height = false;
    					break;
    				}
    		}
    	}
    	return fat;
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