public class Golosina implements Comparable<Golosina>{
    private String nombre;
    private double peso;

    // Constructor para darle identidad a cada golosina con su nombre y peso
    public Golosina(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    // getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    /*conmpareTo sobreescrito para que exist() EJERCICIO 1 funcione correctamente
     Dos golosinas son iguales si tienen el mismo nombre Y el mismo peso
     */
    @Override
    public int compareTo(Golosina otra) {
        // Primero comparar por nombre
        int cmp = this.nombre.compareTo(otra.nombre);

        // Si los nombres son iguales, comparar por peso
        if (cmp == 0) {
            return Double.compare(this.peso, otra.peso);
        }
        return cmp;
    }
 
    @Override
    public String toString() {
        return "Golosina{nombre='" + nombre + "', peso=" + peso + "g}";
    }
}
