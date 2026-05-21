
package bstreelinklistinterfgeneric;

import exceptions.*;

public class TestBST {
    
    // Método estático para el Ejercicio 03.c
    public static <E extends Comparable<E>> boolean sameArea(LinkedBST<E> tree1, LinkedBST<E> tree2) {
        return tree1.areaBST() == tree2.areaBST();
    }

    public static void main(String[] args) {
        LinkedBST<Integer> arbol = new LinkedBST<>();

        try {
            //----prueba act. 7-8-9 ------
            System.out.println("\n--- Insertando Nodos ---");
            int[] valores = {400, 100, 700, 50, 200, 75};
            for (int v : valores) {
                arbol.insert(v);
                System.out.println("Insertado: " + v);
            }

            // prueba de recorridos
            System.out.println("\n--- Recorridos ---");
            arbol.inOrder();   // Izq-root-der: 50 75 100 200 400 700
            arbol.preOrder();  // root-Izq-Der: 400 100 50 75 200 700
            arbol.postOrder(); // Izq-der-root: 75 50 200 100 700 400

            // prueba act. 10 mínimo y maximo
            System.out.println("\n--- Minimos y Maximos ---");
            System.out.println("Valor Minimo encontrado: " + arbol.findMinNode());
            System.out.println("Valor Maximo encontrado: " + arbol.findMaxNode());
            
            //Ejercio 2
            System.out.println("\n--- Estadisticas del Arbol ---");
            System.out.println("Total de nodos (countAllNodes): " + arbol.countAllNodes()); 
            System.out.println("Nodos no-hojas (countNodes): " + arbol.countNodes()); 
            
            System.out.println("\n--- Prueba de Altura (Iterativa con Deque) ---");
            int valBusqueda = 100;
            System.out.println("Altura desde el nodo " + valBusqueda + ": " + arbol.height(valBusqueda));
            System.out.println("Altura de un nodo inexistente (999): " + arbol.height(999)); 

            System.out.println("\n--- Prueba de Amplitud ---");
            System.out.println("La amplitud maxima del arbol es: " + arbol.amplitude());

            // ==========================================
            // --- PRUEBAS DE TUS EJERCICIOS (3, 4 y 5) ---
            // ==========================================

            System.out.println("\n--- Ejercicio 03 y 04: Visualizacion y Area ---");
            arbol.drawBST(); 
            System.out.println("Area del arbol (Hojas * Altura): " + arbol.areaBST());

            System.out.println("\nVerificacion de propiedad BST (isValidBST): " + arbol.isValidBST());

            System.out.println("\nComparando area con otro arbol (sameArea):");
            LinkedBST<Integer> arbol2 = new LinkedBST<>();
            arbol2.insert(10); arbol2.insert(5); arbol2.insert(15);
            System.out.println("¿arbol 1 tiene la misma area que arbol 2? : " + sameArea(arbol, arbol2));

            System.out.println("\n--- Ejercicio 05: Caso Aplicado Inventario ---");
            // a. Las inserciones ya se probaron arriba, el arbol de inventario será el mismo.
            // b. Búsqueda por rango
            arbol.searchRange(60, 250);
            // c. Contar hojas
            System.out.println("Numero de productos en hojas: " + arbol.countLeaves());
            // d. Mostrar descendente
            arbol.printDescending();
            
            // ==========================================

            // Prueba Eliminación Total (ejercicio 02.a)
            System.out.println("\n--- Destruyendo Nodos ---");
            arbol.destroyNodes();
            System.out.println(" arbol vacio?: " + arbol.isEmpty());
           

        } catch (ItemDuplicated e) {
            System.out.println("Error de duplicado: " + e.getMessage());
        } catch (ItemNotFound e) {
            System.out.println("Error de búsqueda: " + e.getMessage());
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error de estructura: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}