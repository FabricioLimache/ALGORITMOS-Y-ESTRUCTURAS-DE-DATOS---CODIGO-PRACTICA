public class Golosina {
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

    /*
     * equals sobreescrito para que exist() EJERCICIO 1 funcione correctamente
        y java no compare referencias de memoria
     * Dos golosinas son iguales si tienen el mismo nombre Y el mismo peso
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Golosina otra = (Golosina) obj;
        return Double.compare(this.peso, otra.peso) == 0
                && this.nombre.equals(otra.nombre);
    }
 
    @Override
    public String toString() {
        return "Golosina{nombre='" + nombre + "', peso=" + peso + "g}";
    }
}
