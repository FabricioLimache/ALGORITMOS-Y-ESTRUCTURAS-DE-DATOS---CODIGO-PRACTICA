package Mineria;

public class Zona {
    private String tipoMineral;
    private double cantidad;
    private double pureza;

    public Zona(String tipoMineral, double cantidad, double pureza) {
        this.tipoMineral = tipoMineral;
        this.cantidad = cantidad;
        this.pureza = pureza;
    }

    // El valor económico se calcula multiplicando cantidad por pureza
    public double getValorEconomico() {
        return cantidad * pureza;
    }

    public String getTipoMineral() {
        return tipoMineral;
    }

    @Override
    public String toString() {
        return "[" + tipoMineral + ", cantidad: " + cantidad + ", pureza: " + pureza + "]";
    }
}