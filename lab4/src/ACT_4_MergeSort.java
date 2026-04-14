import java.util.Arrays;
import java.util.Random;

public class ACT_4_MergeSort {

    // Método principal basado en la estrategia de dividir y conquistar
    public static void ordenar(int[] arr, int izq, int der) {
        if (izq < der) { // Caso recursivo
            int medio = (izq + der) / 2; // Dividir el arreglo en dos mitades

            ordenar(arr, izq, medio);
            ordenar(arr, medio + 1, der);

            merge(arr, izq, medio, der); // Mezclar las mitades ordenadas
        }
    }

    private static void merge(int[] arr, int izq, int medio, int der) {
        int n1 = medio - izq + 1;
        int n2 = der - medio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[izq + i];
        for (int j = 0; j < n2; j++) R[j] = arr[medio + 1 + j];

        int i = 0, j = 0, k = izq;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) { arr[k] = L[i]; i++; k++; }
        while (j < n2) { arr[k] = R[j]; j++; k++; }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        // ORDENAMOS Arreglos de 5, 8 y 10 elementos
        int[] tamaños = {5, 8, 10};

        for (int t : tamaños) {
            int[] arreglo = new int[t];
            for (int i = 0; i < t; i++) arreglo[i] = rand.nextInt(100); // USAMOS NUMEROS ALEATORIOS PARA LOS ARREEGLOS

            System.out.println("\n--- PRUEBA CON " + t + " ELEMENTOS ---");
            System.out.println("Antes:  " + Arrays.toString(arreglo));

            ordenar(arreglo, 0, arreglo.length - 1);

            System.out.println("Después: " + Arrays.toString(arreglo));
        }
    }
}