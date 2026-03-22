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
                DemoMetodoGenerico.exist(golosinas, new Golosina("Chicle", 5))); //true
        System.out.println("¿Existe caramelo 20g en golosinas? " +
                DemoMetodoGenerico.exist(golosinas, new Golosina("Caramelo", 20))); //false

        System.out.println("---Prueba exist() con Chocolatina---");
        System.out.println("¿Existe Ferrero en chocolatinas? "
                + DemoMetodoGenerico.exist(chocolatinas, new Chocolatina("Ferrero"))); //true
        
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
        
       //Ejercicio 5: pruebas de funcionamiento de lo que se hizo en ejercicios 3, 4 mediante search, delete, toString
        System.out.println("\n--- Ejercicio 5: Cajoneria con search, delete y toString ---");
     
        Cajoneria<Golosina> cajoneria = new Cajoneria<>(5);
        
        cajoneria.add("Blanco",     new Golosina("Chicle", 7));
        cajoneria.add("Amarillo", new Golosina("Caramelo", 4));
        cajoneria.add("Azul",    new Golosina("Gomita", 10));
        cajoneria.add("Negro",     new Golosina("Gomita", 8));
        cajoneria.add("Blanco",   new Golosina("Gomita", 8));

        //msotrar contenido con toString()
        System.out.println(cajoneria);

        //prueba de search con uno que existe y uno que no
        System.out.println("Buscando Gomita 10g:  " + cajoneria.search(new Golosina("Gomita", 10)));
        System.out.println("Buscando Menta 3g:   " + cajoneria.search(new Golosina("Menta", 3)));

        //prueba de delete con uno que existe y uno que no
        System.out.println("\nEliminando Gomita 10g: " + cajoneria.delete(new Golosina("Gomita", 10)));
        System.out.println("Eliminando Menta 3g:   " + cajoneria.delete(new Golosina("Menta", 3)));

        //mostrar contenido después del delete 
        System.out.println("\nCajoneria despues del delete:");
        System.out.println(cajoneria);
        
        //ejercicio 6 prueba de funcionamiento de contar() con Golosina
        System.out.println("--- Ejercicio 5 - prueba metodo contar con Golosina ---");
        System.out.println("Cuantas veces aparece Gomita 5g?   " +
            cajoneria.contar(new Golosina("Gomita", 8)));   
        System.out.println("Cuantas veces aparece Caramelo 10g?  " +
            cajoneria.contar(new Golosina("Gomita", 10)));
        
        
        
    }
}