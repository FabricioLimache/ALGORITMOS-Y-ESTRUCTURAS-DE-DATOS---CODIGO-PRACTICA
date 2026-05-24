package ejercicios_adicionales;

import avltree.AVLTree;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;

public class ProductosAlmacen {
    public static void main(String[] args) {
        // Inicializamos el árbol AVL para códigos de producto (Integer)
        AVLTree<Integer> almacen = new AVLTree<>();

        System.out.println("=== SISTEMA GESTOR DE PRODUCTOS (AVL) ===");

        // 1. Inserción de productos
        int[] productos = {30, 15, 20, 50, 40, 60, 70, 10, 25, 45, 55, 65, 75};
        for (int codigo : productos) {
            System.out.println("\nRegistrando producto: " + codigo);
            try {
                almacen.insert(codigo);
            } catch (ItemDuplicated e) {
                System.out.println("Error: El producto " + codigo + " ya existe.");
            }
            almacen.printTree();
        }

        // 2. Búsqueda de productos
        System.out.println("\n=== BUSQUEDA DE PRODUCTOS ===");
        int[] busquedas = {400, 999}; 
        for (int codigo : busquedas) {
            try {
                almacen.search(codigo);
                System.out.println("Producto " + codigo + ": Encontrado en el almacen.");
            } catch (ItemNotFound e) {
                System.out.println("Producto " + codigo + ": No existe en el almacen.");
            }
        }

        // 3. Recorrido inorden (Lista de productos ordenados)
        System.out.println("\n=== LISTADO DE PRODUCTOS ORDENADOS ===");
        almacen.inOrder();

        // 4. Eliminación de productos
        System.out.println("\n=== ELIMINACION DE PRODUCTOS ===");
        almacen.remove(300);
        System.out.println("Producto 300 eliminado.");
        almacen.printTree();
        
        System.out.println("\n=== GESTION FINALIZADA ===");
    }
}