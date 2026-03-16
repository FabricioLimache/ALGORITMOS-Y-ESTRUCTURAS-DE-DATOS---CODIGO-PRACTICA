public class ContainerRect {

    private Rectangulo[] rectangulos;
    private double[] distancias;
    private double[] areas;
    private int n;

    public static int numRec = 0;

    public ContainerRect(int n) {
        this.n = n;
        rectangulos = new Rectangulo[n];
        distancias = new double[n];
        areas = new double[n];
    }

    public void addRectangulo(Rectangulo r) {

        if (numRec >= n) {
            System.out.println("No se pueden almacenar más rectángulos.");
            return;
        }

        rectangulos[numRec] = r;

        distancias[numRec] =
                Coordenada.distancia(r.getEsquina1(), r.getEsquina2());

        areas[numRec] = r.calculoArea();

        numRec++;
    }

    public void mostrarResultados() {

        for (int i = 0; i < numRec; i++) {

            System.out.println("Rectangulo " + (i+1));
            System.out.println(rectangulos[i]);

            System.out.println("Distancia euclidiana = " + distancias[i]);
            System.out.println("Area = " + areas[i]);

            System.out.println("---------------------");
        }
    }
}