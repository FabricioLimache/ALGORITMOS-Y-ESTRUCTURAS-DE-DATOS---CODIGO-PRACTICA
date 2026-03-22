public class Chocolatina {
    private String marca;

    // Solo necesitamos la marca para diferenciar estas piezas
    public Chocolatina(String marca) {
        this.marca = marca;
    }

    // getters y setters
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    /*
     * Modificar equals() para el metodo exist() de EJERCICIO 1
     * equals sobreescrito, dos chocolatinas son iguales si tienen la misma marca
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Chocolatina otra = (Chocolatina) obj;
        return this.marca.equals(otra.marca);
    }

    @Override
    public String toString() {
        return "Chocolatina{marca='" + marca + "'}";
    }
}
