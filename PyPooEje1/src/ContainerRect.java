public class ContainerRect {

    // arreglo para guardar los rectangulos
    private Rectangulo[] rectangulos;

    // arreglo para guardar las distancias
    private double[] distancias;

    // arreglo para guardar las areas
    private double[] areas;

    // capacidad maxima
    private int n;

    // atributo de clase que cuenta cuantos rectangulos se guardaron
    public static int numRec = 0;

    // constructor
    public ContainerRect(int n) {

        this.n = n;

        // creamos los arreglos con tamaño n
        rectangulos = new Rectangulo[n];
        distancias = new double[n];
        areas = new double[n];
    }

    // metodo para agregar un rectangulo al contenedor
    public void addRectangulo(Rectangulo r) {

        // verificamos si aun hay espacio
        if (numRec >= n) {

            System.out.println("No se pueden almacenar mas rectangulos");
            return;
        }

        // guardamos el rectangulo
        rectangulos[numRec] = r;

        // guardamos la distancia entre sus coordenadas
        distancias[numRec] =
                Coordenada.distancia(r.getEsquina1(), r.getEsquina2());

        // guardamos el area
        areas[numRec] = r.calculoArea();

        // aumentamos contador
        numRec++;
    }

    // metodo para mostrar la informacion del contenedor
    public String toString() {

        String resultado = "";

        resultado += "Rectangulo Coordenadas Distancia Area\n";

        for (int i = 0; i < numRec; i++) {

            resultado += (i + 1) + " ";
            resultado += rectangulos[i] + " ";
            resultado += String.format("%.3f", distancias[i]) + " ";
            resultado += String.format("%.2f", areas[i]) + "\n";
        }

        return resultado;
    }
}