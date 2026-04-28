package ejercicio8;

public class Main {
    public static void main(String[] args) {
        ColaReproduccion<Cancion> cola = new ColaReproduccion<>();

        // Agregando 6 canciones
        cola.agregarCancion(new Cancion("Bohemian Rhapsody", "Queen", 354));
        cola.agregarCancion(new Cancion("Blinding Lights", "The Weeknd", 200));
        cola.agregarCancion(new Cancion("Shape of You", "Ed Sheeran", 234));
        cola.agregarCancion(new Cancion("Hotel California", "Eagles", 390));
        cola.agregarCancion(new Cancion("Billie Jean", "Michael Jackson", 294));
        cola.agregarCancion(new Cancion("Smells Like Teen Spirit", "Nirvana", 301));

        System.out.println("=== Cola de Reproducción Inicial ===");
        cola.mostrarCola();

        System.out.println("\n=== Avanzando 3 canciones ===");
        System.out.println("Siguiente: " + cola.reproducirSiguiente());
        System.out.println("Siguiente: " + cola.reproducirSiguiente());
        System.out.println("Siguiente: " + cola.reproducirSiguiente());

        System.out.println("\n=== Retrocediendo 1 canción ===");
        System.out.println("Anterior: " + cola.reproducirAnterior());

        System.out.println("\n=== Mezclando... ===");
        cola.mezclar();
        cola.mostrarCola();

        // Mostrar duración total formateada
        int totalSeg = cola.duracionTotal();
        int min = totalSeg / 60;
        int seg = totalSeg % 60;
        System.out.printf("\nDuración total: %02d:%02d\n", min, seg);
    }
}