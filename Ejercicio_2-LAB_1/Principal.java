package Mineria;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnalizadorMinero analizador = new AnalizadorMinero();
        
        // Lee el archivo que tienes en la raíz del proyecto
        analizador.cargarDatos("terreno.txt"); 

        System.out.print("Ingrese el tamaño k para la subregión (ej. 2): ");
        int k = scanner.nextInt();

        analizador.analizarTerreno(k);
        
        scanner.close();
    }
}