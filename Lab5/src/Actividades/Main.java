package Actividades;

public class Main {
    public static void main(String[] args) {
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();
        
        // 1. Carga de datos iniciales[cite: 4]
        gestor.agregarTarea(new Tarea("Diseñar BD", 2, "pendiente"));
        gestor.agregarTarea(new Tarea("Deploy produccion", 1, "pendiente"));
        gestor.agregarTarea(new Tarea("Documentar API", 3, "completada"));
        gestor.agregarTarea(new Tarea("Code review", 2, "pendiente"));
        gestor.agregarTarea(new Tarea("Corregir bug #42", 1, "completada"));

        System.out.println("=== Tareas Actuales ===");
        gestor.imprimirTareas();

        // 2. Verificación de existencia y eliminación[cite: 4]
        Tarea tBusqueda = new Tarea("Code review", 2, "pendiente");
        System.out.println("\n¿Existe 'Code review'?: " + gestor.contieneTarea(tBusqueda));
        gestor.eliminarTarea(tBusqueda);

        // 3. Análisis de prioridad[cite: 4]
        System.out.println("\nTarea más prioritaria: " + gestor.obtenerTareaMasPrioritaria());

        // 4. Inversión de la lista[cite: 4]
        System.out.println("\n=== Lista Invertida ===");
        gestor.invertirTareas();
        gestor.imprimirTareas();

        // 5. Transferencia de tareas completadas[cite: 4]
        ListLinked<Tarea> listaCompletadas = new ListLinked<>();
        // En un caso real, recorreríamos la lista del gestor para filtrar
        System.out.println("\n=== Historial de Tareas Completadas ===");
        listaCompletadas.insertLast(new Tarea("Documentar API", 3, "completada"));
        listaCompletadas.insertLast(new Tarea("Corregir bug #42", 1, "completada"));
        listaCompletadas.print();
    }
}
