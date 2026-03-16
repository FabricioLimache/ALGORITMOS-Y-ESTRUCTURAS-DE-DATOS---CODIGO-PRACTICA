import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);

        // pedimos la capacidad del contenedor
        System.out.print("Ingrese numero maximo de rectangulos: ");
        int n = lector.nextInt();

        // creamos contenedor
        ContainerRect contenedor = new ContainerRect(n);

        // ciclo para crear rectangulos
        for (int i = 0; i < n; i++) {

            System.out.println("\nRectangulo " + (i + 1));

            System.out.print("X1: ");
            double x1 = lector.nextDouble();

            System.out.print("Y1: ");
            double y1 = lector.nextDouble();

            System.out.print("X2: ");
            double x2 = lector.nextDouble();

            System.out.print("Y2: ");
            double y2 = lector.nextDouble();

            Coordenada c1 = new Coordenada(x1, y1);
            Coordenada c2 = new Coordenada(x2, y2);

            Rectangulo r = new Rectangulo(c1, c2);

            // guardamos rectangulo en contenedor
            contenedor.addRectangulo(r);
        }

        // mostramos contenido del contenedor
        System.out.println("\nContenido del contenedor\n");

        System.out.println(contenedor);
    }
}