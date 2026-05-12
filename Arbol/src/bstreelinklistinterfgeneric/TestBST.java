package bstreelinklistinterfgeneric;

import exceptions.*;

public class TestBST {
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
            //Prueba conteo de nodos (ejercicio 02.b y 02.c)
            System.out.println("\n--- Estadisticas del Arbol ---");
            System.out.println("Total de nodos (countAllNodes): " + arbol.countAllNodes()); 
            
            System.out.println("Nodos no-hojas (countNodes): " + arbol.countNodes()); 
            //nodos con hijos: 400, 100, 50. Total: 3

            //Prueba Altura  (ejercicio 02.d)
            System.out.println("\n--- Prueba de Altura (Iterativa con Deque) ---");
            int valBusqueda = 100;
            System.out.println("Altura desde el nodo " + valBusqueda + ": " + arbol.height(valBusqueda));
            //De 100 a 75 hay 2 saltos. Altura: 2
            
            System.out.println("Altura de un nodo inexistente (999): " + arbol.height(999)); // -1
           

            // Prueba Amplitud (ejercicio 02.e)
            System.out.println("\n--- Prueba de Amplitud ---");
            System.out.println("La amplitud maxima del arbol es: " + arbol.amplitude());
            // Nivel 0: [400] (1)
            // Nivel 1: [100, 700] (2)
            // Nivel 2: [50, 200] (2) -> Amplitud máxima: 2

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