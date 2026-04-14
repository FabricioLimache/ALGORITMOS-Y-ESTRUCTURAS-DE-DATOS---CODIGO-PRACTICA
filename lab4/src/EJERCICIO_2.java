public class EJERCICIO_2 {
	// particion en orden descendente, mayores a la izquierda del pivote
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] >= pivot) {
                i++;
                int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1]; arr[i + 1] = arr[right]; arr[right] = tmp;
        return i + 1;
    }
 
    // divide y venceras, solo se recursa en la mitad relevante
    private static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) return arr[left];
        int pivotIdx = partition(arr, left, right);
        if (k == pivotIdx)        return arr[pivotIdx];
        else if (k < pivotIdx)    return quickSelect(arr, left, pivotIdx - 1, k);
        else                      return quickSelect(arr, pivotIdx + 1, right, k);
    }
 
    // k=1 mayor, k=n menor
    public static int kthLargest(int[] arr, int k) {
        if (k < 1 || k > arr.length)
            throw new IllegalArgumentException("k fuera de rango");
        int[] copy = arr.clone();
        return quickSelect(copy, 0, copy.length - 1, k - 1);
    }
 
    // Pruebas con los casos del enunciado
    public static void main(String[] args) {
        int[][][] casos = {
            {{4,2,7,10,4,17}, {3,7}},
            {{4,2,7,10,4,1,6}, {5,4}},
            {{4,2,7,1,4,6}, {1,7}},
            {{9,2,7,1,7}, {4,2}}
        };
        System.out.printf("%-30s %3s  %8s  %8s%n",
                          "Arreglo", "k", "Esperado", "Obtenido");
        System.out.println("-".repeat(50));
        for (int[][] c : casos) {
            int[] arr = c[0];
            int k = c[1][0], esperado = c[1][1];
            int resultado = kthLargest(arr, k);
            System.out.printf("%-30s %3d  %8d  %8d%n",
                java.util.Arrays.toString(arr), k, esperado, resultado);
        }
    }
}
