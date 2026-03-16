import java.util.*;

public class Coordenada {
    private double x;
    private double y;

    // Constructor por defecto
    public Coordenada() {
        this.x = 0;
        this.y = 0;
    }

    // Constructor con parámetros
    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Constructor de copia (recibe un objeto y lo define como el objeto actual)
    public Coordenada(Coordenada c) {
        this.x = c.x;
        this.y = c.y;
    }

    // setters
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    // getters
    public double getX() { return this.x; }
    public double getY() { return this.y; }



    // Método de instancia(del objeto): calculamos la distancia euclideana
    public double distancia(Coordenada c) {
        return Math.sqrt(Math.pow(this.getX() - c.getX(), 2) + Math.pow(this.getY() - c.getY(), 2));
    }//sirve para calcular la distancia desde una coordenada propia(la actual) a una nueva coordenada
    // (nececitamos una coordenada ya creada(la actual) para poder usarlo)


    // Método estático(de la clase): calculamos la distancia entre dos coordenadas
    public static double distancia(Coordenada c1, Coordenada c2) {
        return Math.sqrt(Math.pow(c1.getX() - c2.getX(), 2) + Math.pow(c1.getY() - c2.getY(), 2));
    }//sirve para calcular la distancia entre 2 coordenadas sin nececidad de depender de un objeto)

    // mostramos la coordenada
    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
