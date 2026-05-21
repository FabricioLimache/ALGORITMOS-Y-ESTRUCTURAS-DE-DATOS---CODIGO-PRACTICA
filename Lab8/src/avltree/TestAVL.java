package avltree;
import exceptions.ItemDuplicated;

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

        

        } catch (ItemDuplicated e) {
            System.out.println("Error en la prueba: " + e.getMessage());
        }

	}

}
