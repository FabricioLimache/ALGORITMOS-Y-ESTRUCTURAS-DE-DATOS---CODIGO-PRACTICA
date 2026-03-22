public class TestGen {
        public static void main(String[] args) {
                // ejemplo dados en guia
                String[] v = { "Perez", "Sanchez", "Rodriguez" };
                Integer[] w = { 12, 34, 56 };

                System.out.println("--Prueba exist() con String e Integer--");
                System.out.println(DemoMetodoGenerico.exist(v, "Sanchez")); // true
                System.out.println(DemoMetodoGenerico.exist(w, 34)); // true
                // System.out.println(DemoMetodoGenerico.exist(w, "Salas")); //error intencional

                // Prueba con arreglos de objetos Golosina y Chocolatina
                Golosina[] golosinas = {
                                new Golosina("Caramelo", 10),
                                new Golosina("Chicle", 5),
                                new Golosina("Gomita", 15)
                };
                Chocolatina[] chocolatinas = {
                                new Chocolatina("Milka"),
                                new Chocolatina("Ferrero"),
                                new Chocolatina("Hershey's")
                };
                System.out.println("\n---Prueba exist() con Golosina---");
                System.out.println("¿Existe chicle 5g en golosinas? " +
                                DemoMetodoGenerico.exist(golosinas, new Golosina("Chicle", 5))); // true
                System.out.println("¿Existe caramelo 20g en golosinas? " +
                                DemoMetodoGenerico.exist(golosinas, new Golosina("Caramelo", 20))); // false

                System.out.println("---Prueba exist() con Chocolatina---");
                System.out.println("¿Existe Ferrero en chocolatinas? "
                                + DemoMetodoGenerico.exist(chocolatinas, new Chocolatina("Ferrero"))); // true

                // Ejercicio 2: imprimirBolsa()
                System.out.println("\n--- imprimirBolsa() con Chocolatinas ---");
                Bolsa<Chocolatina> bolsaCho = new Bolsa<>(3);
                bolsaCho.add(new Chocolatina("Milka"));
                bolsaCho.add(new Chocolatina("Ferrero"));
                bolsaCho.add(new Chocolatina("Hershey's"));
                DemoMetodoGenerico.imprimirBolsa(bolsaCho);

                System.out.println("\n--- imprimirBolsa() con Golosinas ---");
                Bolsa<Golosina> bolsaGol = new Bolsa<>(3);
                bolsaGol.add(new Golosina("Caramelo", 10));
                bolsaGol.add(new Golosina("Chicle", 5));
                bolsaGol.add(new Golosina("Gomita", 15));
                DemoMetodoGenerico.imprimirBolsa(bolsaGol);

        }
}