public class Rectangulo {

    private Coordenada esquina1; // esquina inferior izquierda
    private Coordenada esquina2; // esquina superior derecha

    // Constructor
    public Rectangulo(Coordenada c1, Coordenada c2) {
        // ordenamos las esquinas para trabajar siempre con:
        // esquina1 = inferior izquierda
        // esquina2 = superior derecha
        double minX = Math.min(c1.getX(), c2.getX());
        double minY = Math.min(c1.getY(), c2.getY());
        double maxX = Math.max(c1.getX(), c2.getX());
        double maxY = Math.max(c1.getY(), c2.getY());

        this.esquina1 = new Coordenada(minX, minY);
        this.esquina2 = new Coordenada(maxX, maxY);
    }

    public void setEsquina1(Coordenada coo) {
        this.esquina1 = new Coordenada(coo);
    }

    public void setEsquina2(Coordenada coo) {
        this.esquina2 = new Coordenada(coo);
    }

    public Coordenada getEsquina1() {
        return this.esquina1;
    }

    public Coordenada getEsquina2() {
        return this.esquina2;
    }

    // método de instancia que calcula el área del rectángulo
    public double calculoArea() {
        double base = this.esquina2.getX() - this.esquina1.getX();
        double altura = this.esquina2.getY() - this.esquina1.getY();
        return base * altura;
    }

    @Override
    public String toString() {
        return "[" + esquina1.getX() + ", " + esquina1.getY() + "], [" + esquina2.getX() + ", " + esquina2.getY() + "]";
    }
}