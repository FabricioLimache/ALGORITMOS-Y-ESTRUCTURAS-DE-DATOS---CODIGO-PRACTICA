public class Rectangulo {

    private Coordenada esquina1;
    private Coordenada esquina2;

    public Rectangulo(Coordenada c1, Coordenada c2) {
        setEsquinasOrdenadas(c1, c2);
    }

    private void setEsquinasOrdenadas(Coordenada c1, Coordenada c2) {

        double minX = Math.min(c1.getX(), c2.getX());
        double minY = Math.min(c1.getY(), c2.getY());

        double maxX = Math.max(c1.getX(), c2.getX());
        double maxY = Math.max(c1.getY(), c2.getY());

        this.esquina1 = new Coordenada(minX, minY);
        this.esquina2 = new Coordenada(maxX, maxY);
    }

    public void setEsquina1(Coordenada c) {
        setEsquinasOrdenadas(c, this.esquina2);
    }

    public void setEsquina2(Coordenada c) {
        setEsquinasOrdenadas(this.esquina1, c);
    }

    public Coordenada getEsquina1() { return this.esquina1; }
    public Coordenada getEsquina2() { return this.esquina2; }

    public double calculoArea() {
        double base = esquina2.getX() - esquina1.getX();
        double altura = esquina2.getY() - esquina1.getY();
        return base * altura;
    }

    public double Perimetro() {
        double base = esquina2.getX() - esquina1.getX();
        double altura = esquina2.getY() - esquina1.getY();
        return 2 * (base + altura);
    }

    @Override
    public String toString() {
        return "Rectangulo [Esquina1=" + esquina1 + ", Esquina2=" + esquina2 + "]";
    }
}