public class Coordenada {

    private double x;
    private double y;

    // constructor por defecto
    public Coordenada() {
        this.x = 0;
        this.y = 0;
    }

    // constructor con parametros
    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // constructor copia
    public Coordenada(Coordenada c) {
        this.x = c.x;
        this.y = c.y;
    }

    // setters
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    // getters
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    // calcula distancia entre esta coordenada y otra
    public double distancia(Coordenada c) {

        return Math.sqrt(
                Math.pow(this.x - c.x, 2) +
                Math.pow(this.y - c.y, 2)
        );
    }

    // metodo estatico para calcular distancia entre dos coordenadas
    public static double distancia(Coordenada c1, Coordenada c2) {

        return Math.sqrt(
                Math.pow(c1.getX() - c2.getX(), 2) +
                Math.pow(c1.getY() - c2.getY(), 2)
        );
    }

    // muestra coordenada
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}