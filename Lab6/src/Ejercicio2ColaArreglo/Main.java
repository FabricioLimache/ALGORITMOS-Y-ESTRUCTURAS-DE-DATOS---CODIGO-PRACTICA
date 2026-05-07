
public class Main {
    public static void main(String[] args) {
        ColaEnlazada<Integer> colaTienda = new ColaEnlazada<>();

        // Encolamos clientes iniciales
        colaTienda.encolar(101);
        colaTienda.encolar(102);
        colaTienda.encolar(103);
        colaTienda.encolar(104);
        colaTienda.encolar(105);

        // intebamos sobrepasar la capacidad
        colaTienda.encolar(106);

        //atendemos los 2 primeroos clientes
        System.out.println("Atendiendo cliente: " + colaTienda.desencolar()); // 101
        System.out.println("Atendiendo cliente: " + colaTienda.desencolar()); // 102

        // vemos que cliente actual esta alfrente
        System.out.println("Cliente en frente: " + colaTienda.verFrente()); // 103

        // insertamos clientes adicionales
        colaTienda.encolar(106);
        colaTienda.encolar(107);

        //atendemos a todos hasta vaciar la cola
        while (!colaTienda.estaVacia()) {
            System.out.println("Atendiendo cliente: " + colaTienda.desencolar());
        }

        // intentamos desencolar con cola vacia
        colaTienda.desencolar();
    }
}
