package avltree;

import exceptions.ItemDuplicated;
import exceptions.ExceptionIsEmpty;

public class TestAVL {

	public static void main(String[] args) {
		AVLTree<Integer> arbol = new AVLTree<>();

        try {
            // PRUEBA 1: Inserción inicial sin rotaciones
            System.out.println("\n1. Insertando 50 y 40 (Sin rotacion)...");
            arbol.insert(50);
            arbol.insert(40);
            arbol.printTree();

            // PRUEBA 2: Provocando Caso Izquierda-Izquierda (RSR)
            System.out.println("\n2. Insertando 30 -> Debe provocar RSR (Simple Derecha)...");
            arbol.insert(30);
            arbol.printTree();

            // PRUEBA 3: Provocando Caso Derecha-Derecha (RSL)
            System.out.println("\n3. Insertando 60 y 70 -> Debe provocar RSL (Simple Izquierda)...");
            arbol.insert(60);
            arbol.insert(70);
            arbol.printTree();

            // PRUEBA 4: Provocando Caso Derecha-Izquierda (RDL)
            System.out.println("\n4. Insertando 80 y 75 -> Debe provocar RDL (Doble Izquierda)...");
            arbol.insert(80);
            arbol.insert(75);
            arbol.printTree();

            // PRUEBA 5: Provocando Caso Izquierda-Derecha (RDR)
            System.out.println("\n5. Insertando 20 y 25 -> Debe provocar RDR (Doble Derecha)...");
            arbol.insert(20);
            arbol.insert(25);
            arbol.printTree();

            // PRUEBA 6: Provocando Segunda RSR
            System.out.println("\n6. Insertando 10 -> Debe provocar Segunda RSR...");
            arbol.insert(10);
            arbol.printTree();

            // PRUEBA 7: Provocando Segunda RDL (Derecha-Izquierda)
            // Insertamos 85 para forzar un nuevo desbalance RDL en el subárbol derecho
            System.out.println("\n7. Insertando 85 -> Provocando segunda RDL...");
            arbol.insert(85);
            arbol.printTree();

            // PRUEBA 8: Provocando Segunda RDR (Izquierda-Derecha)
            // Insertamos 15 para forzar un nuevo desbalance RDR en el subárbol izquierdo
            System.out.println("\n8. Insertando 15 -> Provocando segunda RDR...");
            arbol.insert(15);
            arbol.printTree();


            // prueba ejercicio 2
            bstree.BSTree<Integer> arbolBST = new bstree.BSTree<>();
            int[] secuenciaOrdenada = {10, 20, 30, 40, 50};
            
            for (int valor : secuenciaOrdenada) {
                arbolBST.insert(valor);
            }
            
            System.out.println("\n--- COMPARACIÓN DE ESTRUCTURAS ---");
            System.out.print("Recorrido In-Order BST: ");
            arbolBST.inOrder();


            // prueba ejercicio 7
            System.out.println("\n--- TRAZAS DE RECORRIDOS AVL ---");
            arbol.inOrder(); 
            arbol.preOrder(); 
            System.out.print("Recorrido por Amplitud:  ");
            arbol.breadthFirstSearch(); 

            System.out.println("\nEliminando nodo hoja (10)...");
            arbol.delete(10);
            arbol.printTree();

            System.out.println("\nEliminando nodo con un hijo (60)...");
            arbol.delete(60);
            arbol.printTree();

            System.out.println("\nEliminando nodo raíz principal (50)...");
            arbol.delete(50);
            arbol.printTree();

        } catch (ItemDuplicated e) {
            System.out.println("Error en la prueba: " + e.getMessage());
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error de estructura vacía: " + e.getMessage());
        }

	}

}
