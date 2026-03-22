package powerstation;

import java.util.ArrayList;

public class PowerStation<T extends Cargable> {

    private ArrayList<T> dispositivos;

    public PowerStation() {
        this.dispositivos = new ArrayList<>();
    }

    public void conectar(T dispositivo) {
        dispositivos.add(dispositivo);
        System.out.println("Conectado: " + dispositivo);
    }

    public double calcularConsumoTotal() {
        double total = 0.0;
        for (T d : dispositivos) {
            total += d.getConsumoVatios();
        }
        return total;
    }

    public int buscarDispositivo(T prototipo) {
        for (int i = 0; i < dispositivos.size(); i++) {
            if (dispositivos.get(i).equals(prototipo)) {
                return i + 1;
            }
        }
        return -1;
    }

    public void mostrarReporte() {
        String linea = "+----------+-----------------------------+-----------+-----------+";
        System.out.println(linea);
        System.out.printf("| %-8s | %-27s | %-9s | %-9s |%n",
                "Posición", "Dispositivo", "Vatios", "Batería");
        System.out.println(linea);
        for (int i = 0; i < dispositivos.size(); i++) {
            T d = dispositivos.get(i);
            String desc = d.toString();
            if (desc.length() > 27) desc = desc.substring(0, 24) + "...";
            System.out.printf("| %-8d | %-27s | %-9.1f | %-8d%% |%n",
                    i + 1, desc, d.getConsumoVatios(), d.getNivelBateria());
        }
        System.out.println(linea);
        System.out.printf("  Consumo total: %.2f W%n%n", calcularConsumoTotal());
    }

    public void cargarTodos(int cantidad) {
        System.out.println("\n-- Cargando todos los dispositivos --");
        for (T d : dispositivos) {
            d.cargar(cantidad);
        }
    }

    public T desconectar(T prototipo) {
        for (int i = 0; i < dispositivos.size(); i++) {
            if (dispositivos.get(i).equals(prototipo)) {
                return dispositivos.remove(i);
            }
        }
        return null;
    }

    public int size() { return dispositivos.size(); }
}