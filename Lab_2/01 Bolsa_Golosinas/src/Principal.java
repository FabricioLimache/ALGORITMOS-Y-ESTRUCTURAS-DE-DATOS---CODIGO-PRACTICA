public class Principal {
    public static void main(String[] args) {
        // Probamos la bolsa de chocolatinas
        Bolsa<Chocolatina> bolsaCho = new Bolsa<>(3);
        bolsaCho.add(new Chocolatina("milka"));
        bolsaCho.add(new Chocolatina("milka"));
        bolsaCho.add(new Chocolatina("ferrero"));

        System.out.println("Contenido de la bolsa de chocolatinas:");
        for (Chocolatina c : bolsaCho) {
            System.out.println("- " + c.getMarca());
        }

        // Comparamos arreglos genericos
        Integer nums[] = {1, 2, 3, 4, 5};
        Integer nums2[] = {1, 2, 3, 4, 5};

        System.out.println("\n¿Son iguales los arreglos de enteros?: " +
                DemoMetodoGenerico.igualArrays(nums, nums2));


        // Creamos la bolsa y la recorremos igual que con las chocolatinas
        Bolsa<Golosina> bolsaGol = new Bolsa<>(2);
        bolsaGol.add(new Golosina("Caramelo", 5.2));
        bolsaGol.add(new Golosina("Gomita", 10.5));

        System.out.println("\nContenido de la bolsa de golosinas:");
        for (Golosina g : bolsaGol) {
            System.out.println("- " + g.getNombre() + " (" + g.getPeso() + "g)");
        }
    }
}
