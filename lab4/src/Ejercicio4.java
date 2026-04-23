package Ejercicio3y4;

public class Ejercicio4 {

	
	/**
	 * Ejercicio 4: Búsqueda de camino en un Laberinto (Backtracking)
	 */
	    private int[][] laberinto;
	    private int[][] solucion;
	    private int N, M;

	    public Ejercicio4(int[][] laberinto) {
	        this.laberinto = laberinto;
	        this.N = laberinto.length;
	        this.M = laberinto[0].length;
	        this.solucion = new int[N][M]; // Matriz para marcar el camino
	    }

	    // Función auxiliar para verificar si es seguro moverse a x, y
	    private boolean esSeguro(int x, int y) {
	        // Dentro de límites, la celda es 0 (camino libre) y no ha sido visitada en la matriz solución
	        return (x >= 0 && x < N && y >= 0 && y < M && laberinto[x][y] == 0 && solucion[x][y] == 0);
	    }

	    public boolean resolverLaberinto() {
	        if (!resolverUtil(0, 0)) {
	            System.out.println("Salida: false (No hay camino posible)");
	            return false;
	        }
	        System.out.println("Salida: true (Camino encontrado):");
	        imprimirSolucion();
	        return true;
	    }

	    private boolean resolverUtil(int x, int y) {
	        // Caso base: Si llegamos a la esquina inferior derecha
	        if (x == N - 1 && y == M - 1 && laberinto[x][y] == 0) {
	            solucion[x][y] = 1;
	            return true;
	        }

	        if (esSeguro(x, y)) {
	            // 1. Elegir: Marcamos la celda como parte de la solución
	            solucion[x][y] = 1;

	            // 2. Explorar (Abajo, Derecha, Arriba, Izquierda)
	            if (resolverUtil(x + 1, y)) return true; // Abajo
	            if (resolverUtil(x, y + 1)) return true; // Derecha
	            if (resolverUtil(x - 1, y)) return true; // Arriba
	            if (resolverUtil(x, y - 1)) return true; // Izquierda

	            // 3. Backtracking: Deshacer si ninguna dirección funcionó
	            solucion[x][y] = 0;
	            return false;
	        }
	        return false;
	    }

	    private void imprimirSolucion() {
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < M; j++) {
	                System.out.print(solucion[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }

	    public static void main(String[] args) {
	        // Ejemplo 1 del PDF
	        int[][] matrizEjemplo1 = {
	            {0, 0, 1},
	            {1, 0, 1},
	            {1, 0, 0}
	        };
	        
	        System.out.println("Prueba - Ejemplo 1:");
	        Ejercicio4 lab1 = new Ejercicio4(matrizEjemplo1);
	        lab1.resolverLaberinto();
	        
	        System.out.println("\n-------------------\n");

	        // Ejemplo 2 del PDF
	        int[][] matrizEjemplo2 = {
	            {0, 1},
	            {1, 0}
	        };
	        
	        System.out.println("Prueba - Ejemplo 2:");
	        Ejercicio4 lab2 = new Ejercicio4(matrizEjemplo2);
	        lab2.resolverLaberinto();
	    }
	}

