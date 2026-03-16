public class Rectangulo {

    private Coordenada esquina1; // esquina inferior izquierda
    private Coordenada esquina2; // esquina superior derecha

    // constructor
    public Rectangulo(Coordenada c1, Coordenada c2) {

        // siempre ordenamos las esquinas
        setEsquinasOrdenadas(c1, c2);
    }

    // metodo que ordena las esquinas sin importar como las ingrese el usuario
    private void setEsquinasOrdenadas(Coordenada c1, Coordenada c2) {

        double minX = Math.min(c1.getX(), c2.getX());
        double minY = Math.min(c1.getY(), c2.getY());

        double maxX = Math.max(c1.getX(), c2.getX());
        double maxY = Math.max(c1.getY(), c2.getY());

        // esquina inferior izquierda
        this.esquina1 = new Coordenada(minX, minY);

        // esquina superior derecha
        this.esquina2 = new Coordenada(maxX, maxY);
    }

    // getters
    public Coordenada getEsquina1() {
        return esquina1;
    }

    public Coordenada getEsquina2() {
        return esquina2;
    }

    // calcula area del rectangulo
    public double calculoArea() {

        double base = esquina2.getX() - esquina1.getX();
        double altura = esquina2.getY() - esquina1.getY();

        return base * altura;
    }

    // calcula perimetro
    public double perimetro() {

        double base = esquina2.getX() - esquina1.getX();
        double altura = esquina2.getY() - esquina1.getY();

        return 2 * (base + altura);
    }

    public String toString() {

        return "(" + esquina1 + ", " + esquina2 + ")";
    }
}