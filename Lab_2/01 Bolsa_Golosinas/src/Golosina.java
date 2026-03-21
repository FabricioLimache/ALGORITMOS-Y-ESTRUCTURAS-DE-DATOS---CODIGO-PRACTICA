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
}
