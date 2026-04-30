package Actividades;

public class Tarea implements Comparable<Tarea> {
    private String titulo;
    private int prioridad; // 1 = alta, 2 = media, 3 = baja
    private String estado; // pendiente o completada

    public Tarea(String titulo, int prioridad, String estado) {
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.estado = estado;
    }

    @Override
    public int compareTo(Tarea otra) {
        // La prioridad mas baja es la más importante
        return Integer.compare(this.prioridad, otra.prioridad);
    }

    @Override
    public String toString() {
        return "[" + titulo + " | Prioridad: " + prioridad + " | Estado: " + estado + "]";
    }
    
    public String getEstado() { return estado; }
}
