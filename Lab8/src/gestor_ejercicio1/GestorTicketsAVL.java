package gestor_ejercicio1; 

import avltree.AVLTree;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;

public class GestorTicketsAVL {
    public static void main(String[] args) {
        AVLTree<Integer> gestor = new AVLTree<>();

        System.out.println("=== SISTEMA GESTOR DE TICKETS URGENTES (AVL) ===");

        // 1. INSERCIONES
        int[] ticketsAInsertar = {30, 10, 20, 40, 50, 25};
        for (int ticket : ticketsAInsertar) {
            System.out.println("\n--- Insertando ticket: " + ticket + " ---");
            try {
                gestor.insert(ticket);
            } catch (ItemDuplicated e) {
                System.out.println("Error: " + e.getMessage());
            }
            gestor.printTree();
        }
        
        // 2. BÚSQUEDAS
        System.out.println("\n=== BUSCANDO TICKETS ===");
        int[] ticketsABuscar = {20, 60};
        for (int t : ticketsABuscar) {
            try {
                gestor.search(t);
                System.out.println("Buscando ticket " + t + ": Encontrado");
            } catch (ItemNotFound e) {
                System.out.println("Buscando ticket " + t + ": No existe");
            }
        }

        // 3. RECORRIDO INORDEN (Para mostrar el orden actual)
        System.out.println("\n=== RECORRIDO INORDEN (Tickets ordenados) ===");
        gestor.inOrder(); 

        // 4. ELIMINACIONES
        // Nota: Solo funcionará si ya tienes implementado el método remove() en tu clase base BSTree
        int[] ticketsAEliminar = {10, 40, 30};
        for (int t : ticketsAEliminar) {
            System.out.println("\n--- Eliminando ticket: " + t + " ---");
            gestor.remove(t); 
            gestor.printTree();
        }
        
        System.out.println("\n === GESTOR FINALIZADA ===");
    }
}