public class Principal {
    public static void main(String[] args) {

        // Probamos con string
        String[] nombres = {"A", "B", "C", "D"};
        System.out.println("Arreglo original: ");
        MetodoIntercambio.imprimirArreglo(nombres);

        // Intercambiamos posición 1 (b) con la 3 (d)
        MetodoIntercambio.swap(nombres, 1, 3);
        System.out.println("Después del swap (1, 3) (intercambio): ");
        MetodoIntercambio.imprimirArreglo(nombres);

        System.out.println("\n----------------------------\n");

        // Probamos con Interger
        Integer[] numeros = {10, 20, 30, 40};
        System.out.println("Arreglo original: ");
        MetodoIntercambio.imprimirArreglo(numeros);

        // Intercambiamos posición 0 (10) con la 2 (30)
        MetodoIntercambio.swap(numeros, 0, 2);
        System.out.println("Después del swap (0, 2) (intercambio): ");
        MetodoIntercambio.imprimirArreglo(numeros);
    }
}
