package powerstation;

public class TestEstacion {

    public static void main(String[] args) {

        // ── ZONA CELULARES ─────────────────────────────────────────────
        System.out.println("=== ZONA CELULARES (PowerStation<Smartphone>) ===\n");

        PowerStation<Smartphone> zonaCelulares = new PowerStation<>();

        Smartphone s1 = new Smartphone("iPhone 15",   20.5);
        Smartphone s2 = new Smartphone("Galaxy S24",  25.0);
        Smartphone s3 = new Smartphone("Pixel 8",     18.0);
        Smartphone s4 = new Smartphone("Xiaomi 14",   22.0);

        zonaCelulares.conectar(s1);
        zonaCelulares.conectar(s2);
        zonaCelulares.conectar(s3);
        zonaCelulares.conectar(s4);

        System.out.println("\n-- Reporte inicial --");
        zonaCelulares.mostrarReporte();

        zonaCelulares.cargarTodos(30);

        System.out.println("\n-- Reporte tras carga --");
        zonaCelulares.mostrarReporte();

        System.out.println("-- Buscar Galaxy S24 --");
        int pos = zonaCelulares.buscarDispositivo(new Smartphone("Galaxy S24", 25.0));
        System.out.println("Galaxy S24 -> posicion: " + (pos != -1 ? pos : "no encontrado"));

        System.out.println("\n-- Desconectar Pixel 8 --");
        Smartphone desc = zonaCelulares.desconectar(s3);
        System.out.println("Desconectado: " + (desc != null ? desc : "no encontrado"));

        System.out.println("\n-- Reporte final celulares --");
        zonaCelulares.mostrarReporte();

        // ── ZONA LAPTOPS ───────────────────────────────────────────────
        System.out.println("=== ZONA LAPTOPS (PowerStation<Laptop>) ===\n");

        PowerStation<Laptop> zonaLaptops = new PowerStation<>();

        zonaLaptops.conectar(new Laptop("MacBook Pro",  65.0));
        zonaLaptops.conectar(new Laptop("Dell XPS 15",  90.0));
        zonaLaptops.conectar(new Laptop("ThinkPad X1",  45.0));

        zonaLaptops.mostrarReporte();
        zonaLaptops.cargarTodos(50);

        System.out.println("\n-- Reporte final laptops --");
        zonaLaptops.mostrarReporte();

        // La siguiente línea causaría ERROR de compilación (seguridad de tipos):
        // zonaLaptops.conectar(s1);  // Smartphone no es Laptop
    }
}
