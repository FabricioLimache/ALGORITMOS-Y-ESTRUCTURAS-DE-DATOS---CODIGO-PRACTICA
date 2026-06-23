package Ejercicio3y4;

public class Ejercicio3 {
	
	/**
	 * Ejercicio 3: El viaje más barato a través del río (Programación Dinámica)
	 */
	

	    public static int[][] calcularCostosMinimos(int[][] T, int n) {
	        // Matriz C para almacenar los costos mínimos
	        int[][] C = new int[n][n];

	        // 1. Inicializamos la matriz C con los costos directos de la tabla T
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                C[i][j] = T[i][j];
	            }
	        }

	        // 2. Aplicamos programación dinámica bottom-up
	        // 'j' es el destino, 'i' es el origen, 'k' es la escala intermedia
	        for (int j = 1; j < n; j++) {
	            for (int i = j - 1; i >= 0; i--) {
	                for (int k = i + 1; k < j; k++) {
	                    // Si el viaje haciendo escala en 'k' es más barato, actualizamos
	                    if (T[i][k] + C[k][j] < C[i][j]) {
	                        C[i][j] = T[i][k] + C[k][j];
	                    }
	                }
	            }
	        }
	        return C;
	    }

	    public static void main(String[] args) {
	        int INF = 99999; // Representa que no hay ruta directa (infinito)
	        
	        // Matriz de tarifas T (Triangular superior)
	        int[][] T = {
	            {0, 5, 15, INF},
	            {INF, 0, 8, 12},
	            {INF, INF, 0, 3},
	            {INF, INF, INF, 0}
	        };
	        int n = T.length;

	        int[][] C = calcularCostosMinimos(T, n);

	        System.out.println("Matriz de Costos Mínimos (C):");
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (C[i][j] >= 99999) {
	                    System.out.print("INF\t");
	                } else {
	                    System.out.print(C[i][j] + "\t");
	                }
	            }
	            System.out.println();
	        }
	    }
	}



