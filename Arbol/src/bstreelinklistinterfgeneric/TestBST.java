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
            System.out.println("Valor Mínimo encontrado: " + arbol.findMinNode());
            System.out.println("Valor Máximo encontrado: " + arbol.findMaxNode());

           

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