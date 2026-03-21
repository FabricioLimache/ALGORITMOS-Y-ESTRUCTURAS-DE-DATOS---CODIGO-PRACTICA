public class Chocolatina {
    private String marca;

    // Solo necesitamos la marca para diferenciar estas piezas
    public Chocolatina(String marca) {
        this.marca = marca;
    }

    // getters y setters
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
}
