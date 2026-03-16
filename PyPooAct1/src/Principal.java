import java.util.*;

public class Principal {

    // método que muestra cualquier rectángulo con su nombre
    public static void mostrarRectangulo(String nombre, Rectangulo r) {
        System.out.println("Rectangulo " + nombre + " = (" + r.toString() + ")");
    }

    // retorna el rectángulo correspondiente al área de sobreposición
    public static Rectangulo rectanguloSobre(Rectangulo r1, Rectangulo r2) {
        double xIzq = Math.max(r1.getEsquina1().getX(), r2.getEsquina1().getX());
        double yInf = Math.max(r1.getEsquina1().getY(), r2.getEsquina1().getY());
        double xDer = Math.min(r1.getEsquina2().getX(), r2.getEsquina2().getX());
        double ySup = Math.min(r1.getEsquina2().getY(), r2.getEsquina2().getY());

        Coordenada c1 = new Coordenada(xIzq, yInf);
        Coordenada c2 = new Coordenada(xDer, ySup);

        return new Rectangulo(c1, c2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una esquina del 1er rectángulo:");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.println("Ingrese la esquina opuesta del 1er rectángulo:");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        System.out.println("Ingrese una esquina del 2do rectángulo:");
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();

        System.out.println("Ingrese la esquina opuesta del 2do rectángulo:");
        double x4 = sc.nextDouble();
        double y4 = sc.nextDouble();

        Coordenada a1 = new Coordenada(x1, y1);
        Coordenada a2 = new Coordenada(x2, y2);
        Coordenada b1 = new Coordenada(x3, y3);
        Coordenada b2 = new Coordenada(x4, y4);

        Rectangulo A = new Rectangulo(a1, a2);
        Rectangulo B = new Rectangulo(b1, b2);

        System.out.println();
        mostrarRectangulo("A", A);
        mostrarRectangulo("B", B);

        if (Verificador.esSobrePos(A, B)) {
            System.out.println("Rectangulos A y B se sobreponen.");

            Rectangulo sobre = rectanguloSobre(A, B);
            System.out.println("Area de sobreposicion = " + sobre.calculoArea());
        } else if (Verificador.esJunto(A, B)) {
            System.out.println("Rectangulos A y B se juntan");
        } else if (Verificador.esDisJunto(A, B)) {
            System.out.println("Rectangulos A y B son disjuntos");
        }

        sc.close();
    }
}