public class EJERCICIO_1 {
	public static void main(String[] args) {
        // Caso 1: N=5, Arreglo={3, 4, 6, 7, 4}, Objetivo=20 -> Esperado: true
        // 3 y 6 son obligatorios (Suma=9). El 4 inicial está bloqueado por el 6 (par-par)
        // Quedan 7 y el 4 final. Suma: 9 + 7 + 4 = 20.
    	System.out.println("Caso 1, {3, 4, 6, 7, 4}: " + sumSubArray(5, new int[]{3, 4, 6, 7, 4}, 20));    	

        // Caso 2: N=5, Arreglo={3, 4, 6, 7, 8}, Objetivo=18 -> Esperado: false
        // 3 y 6 obligatorios (9). El 4 inicial está bloqueado por el 6
        // Solo quedan {7, 8}. Ninguna combinación (9+7=16, 9+8=17, 9+7+8=24) da 18
    	System.out.println("Caso 2, {3, 4, 6, 7, 8}:" + sumSubArray(5, new int[]{3, 4, 6, 7, 8}, 18));
        

        // Caso 3: N=6, Arreglo={3, 9, 2, 5, 8, 4}, Objetivo=31 -> Esperado: false
    	// multiplos de 3 obligatorios: {3, 9} (Suma=12)
        // El 8 está bloqueado porque le sigue un 4 (ambos pares)
        // Elementos utilizables: {3, 9, 2, 5, 4}. Suma total: 23
        // Es imposible sumar 31 ya que la suma máxima permitida es menor al objetivo
    	System.out.println("Caso 3, {3, 9, 2, 5, 8, 4}: " + sumSubArray(6, new int[]{3, 9, 2, 5, 8, 4}, 31));
    }


    public static boolean sumSubArray(int n, int[] nums, int target) {
        //CASOS BASE
        if (target == 0) return true; // Éxito
        if (n == 0 || target < 0) return false; // Fallo (no quedan elementos o suma excedida)

        // Usamos el índice actual basado en n (n-1 es el último elemento disponible)
        int idx = nums.length - n;
        int actual = nums[idx];
        
        //REGLA: Múltiplos de 3  obligatorios
        boolean esMult3 = (actual % 3 == 0);
        
        //REGLA: No elegir par si el SIGUIENTE también es par
        // El "siguiente" está en idx + 1
        boolean bloqueadoPorPar = (actual % 2 == 0 && (idx + 1) < nums.length && nums[idx + 1] % 2 == 0);

        // OPCIÓN A: Intentar incluir el número
        if (!bloqueadoPorPar) {
            // Reducimos n para avanzar al siguiente elemento
            if (sumSubArray(n - 1, nums, target - actual)) return true;
        }

        // OPCIÓN B: Intentar excluir el número
        // Solo si NO es obligatorio (múltiplo de 3)
        if (!esMult3) {
            if (sumSubArray(n - 1, nums, target)) return true;
        }

        return false;
    }
}
