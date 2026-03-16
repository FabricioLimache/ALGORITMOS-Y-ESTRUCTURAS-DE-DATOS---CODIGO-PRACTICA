import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);

        System.out.print("Capacidad del contenedor: ");
        int n = lector.nextInt();

        ContainerRect cont = new ContainerRect(n);

        for (int i = 0; i < n; i++) {

            System.out.println("\nRectangulo " + (i+1));

            System.out.print("X1: ");
            double x1 = lector.nextDouble();

            System.out.print("Y1: ");
            double y1 = lector.nextDouble();

            System.out.print("X2: ");
            double x2 = lector.nextDouble();

            System.out.print("Y2: ");
            double y2 = lector.nextDouble();

            Coordenada c1 = new Coordenada(x1,y1);
            Coordenada c2 = new Coordenada(x2,y2);

            Rectangulo r = new Rectangulo(c1,c2);

            cont.addRectangulo(r);
        }

        System.out.println("\nRESULTADOS");
        cont.mostrarResultados();
    }
}