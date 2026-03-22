package powerstation;

import java.util.Objects;

public class Smartphone implements Cargable {

    private String modelo;
    private double consumoVatios;
    private int nivelBateria;

    public Smartphone(String modelo, double consumoVatios) {
        this.modelo        = modelo;
        this.consumoVatios = consumoVatios;
        this.nivelBateria  = 0;
    }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
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
        System.out.println("[Smartphone] " + modelo
                + " cargado. Batería actual: " + nivelBateria + "%");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Smartphone)) return false;
        Smartphone s = (Smartphone) o;
        return Double.compare(s.consumoVatios, consumoVatios) == 0
                && Objects.equals(modelo, s.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo, consumoVatios);
    }

    @Override
    public String toString() {
        return "Smartphone{modelo='" + modelo
                + "', consumo=" + consumoVatios + "W"
                + ", batería=" + nivelBateria + "%}";
    }
}