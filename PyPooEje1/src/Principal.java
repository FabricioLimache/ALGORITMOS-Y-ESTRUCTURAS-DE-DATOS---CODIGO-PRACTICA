import java.util.*;

public class Principal {

    // Método para hallar el rectángulo formado por la intersección.
    //La intersección usa el máximo de los inicios y el mínimo de los finales
    // para retornar el rectángulo correspondiente al área de sobreposición
    // la manera de funcionar es que la esquina inferior-izq del choque es el MAXIMO de las mínimas,
    // y la esquina superior-der es el MINIMO de las máximas.
    public static Rectangulo rectanguloSobre(Rectangulo r1, Rectangulo r2) {

        double nuevoMinX = Math.max(r1.getEsquina1().getX(), r2.getEsquina1().getX());
        double nuevoMinY = Math.max(r1.getEsquina1().getY(), r2.getEsquina1().getY());

        double nuevoMaxX = Math.min(r1.getEsquina2().getX(), r2.getEsquina2().getX());
        double nuevoMaxY = Math.min(r1.getEsquina2().getY(), r2.getEsquina2().getY());

        Coordenada cMin = new Coordenada(nuevoMinX, nuevoMinY);
        Coordenada cMax = new Coordenada(nuevoMaxX, nuevoMaxY);

        return new Rectangulo(cMin, cMax);
    }

    public static String mostrarRectangulo(Rectangulo r) {//muestra la informacion de un triangulo
        return r.toString();
    }
    
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        // entrada de datos del rectangulo A (primer rectangulo)
        System.out.println(">>> CONFIGURACIÓN DEL RECTÁNGULO A");
        System.out.println("Ingrese la primera esquina:");
        System.out.print("Punto X: ");
        double x1A = lector.nextDouble();
        System.out.print("Punto Y: ");
        double y1A = lector.nextDouble();
        Coordenada c1A = new Coordenada(x1A, y1A);

        System.out.println("Ingrese la esquina opuesta:");
        System.out.print("Punto X: ");
        double x2A = lector.nextDouble();
        System.out.print("Punto Y: ");
        double y2A = lector.nextDouble();
        Coordenada c2A = new Coordenada(x2A, y2A);

        Rectangulo recA = new Rectangulo(c1A, c2A);

        // entrada de datos del rectangulo B (segundo rectangulo)
        System.out.println("\n>>> CONFIGURACIÓN DEL RECTÁNGULO B");
        System.out.println("Ingrese la primera esquina:");
        System.out.print("Punto X: ");
        double x1B = lector.nextDouble();
        System.out.print("Punto Y: ");
        double y1B = lector.nextDouble();
        Coordenada c1B = new Coordenada(x1B, y1B);

        System.out.println("Ingrese la esquina opuesta:");
        System.out.print("Punto X: ");
        double x2B = lector.nextDouble();
        System.out.print("Punto Y: ");
        double y2B = lector.nextDouble();
        Coordenada c2B = new Coordenada(x2B, y2B);

        Rectangulo recB = new Rectangulo(c1B, c2B);

        // Mostramos la informacion de cada rectangulo
        //usamos la esquina inferior izquierda y la esquina superior derecha

        System.out.println("\n========================================");
        System.out.println("Rectangulo A = " + mostrarRectangulo(recA) );
        System.out.println("Rectangulo B = " + mostrarRectangulo(recB) );

        // verificamos los casos
        if (Verificador.SobrePuestos(recA, recB)) {
            System.out.println("Los rectangulos A y B se sobreponen.");

            // calculamos el area de la sobreposicion
            Rectangulo areaChoque = rectanguloSobre(recA, recB);
            System.out.println("Area de sobreposicion = " + areaChoque.calculoArea());

        } else if (Verificador.Juntos(recA, recB)) {
            System.out.println("Los rectangulos A y B se juntan.");

        } else if (Verificador.Disjuntos(recA, recB)) {
            System.out.println("Los rectangulos A y B son disjuntos.");
        }


    }

}
