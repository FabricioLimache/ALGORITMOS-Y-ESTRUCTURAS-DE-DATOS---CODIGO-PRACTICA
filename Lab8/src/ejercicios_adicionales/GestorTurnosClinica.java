package ejercicios_adicionales;

import avltree.AVLTree;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;

public class GestorTurnosClinica {
    public static void main(String[] args) {
        AVLTree<Integer> clinica = new AVLTree<>();

        System.out.println("=== SISTEMA DE ATENCION DE TURNOS (AVL) ===");

        // de inserción de turnos
        int[] turnos = {30, 15, 50, 10, 20};
        for (int t : turnos) {
            try {
                clinica.insert(t);
                System.out.println("Turno registrado: " + t);
            } catch (ItemDuplicated e) {
                System.out.println("Turno " + t + " ya existe.");
            }
        }

        //Búsqueda
        try {
            clinica.search(20);
            System.out.println("Turno 20 encontrado.");
        } catch (ItemNotFound e) {
            System.out.println("Turno 20 no encontrado.");
        }

        // Eliminación de turno atendido
        clinica.remove(10);
        System.out.println("Turno 10 eliminado (atendido).");
        
        System.out.println("=== FIN DE GESTIÓN ===");
    }
}