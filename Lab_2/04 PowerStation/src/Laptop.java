package powerstation;

import java.util.Objects;

public class Laptop implements Cargable {

    private String marca;
    private double consumoVatios;
    private int nivelBateria;

    public Laptop(String marca, double consumoVatios) {
        this.marca         = marca;
        this.consumoVatios = consumoVatios;
        this.nivelBateria  = 0;
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setConsumoVatios(double consumoVatios) {
        this.consumoVatios = consumoVatios;
    }

    @Override
    public double getConsumoVatios() { return consumoVatios; }

    @Override
    public int getNivelBateria() { return nivelBateria; }

    @Override
    public void cargar(int cantidad) {
        nivelBateria = Math.min(100, nivelBateria + cantidad);
        System.out.println("[Laptop] " + marca
                + " cargada. Batería actual: " + nivelBateria + "%");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laptop)) return false;
        Laptop l = (Laptop) o;
        return Double.compare(l.consumoVatios, consumoVatios) == 0
                && Objects.equals(marca, l.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, consumoVatios);
    }

    @Override
    public String toString() {
        return "Laptop{marca='" + marca
                + "', consumo=" + consumoVatios + "W"
                + ", batería=" + nivelBateria + "%}";
    }
}