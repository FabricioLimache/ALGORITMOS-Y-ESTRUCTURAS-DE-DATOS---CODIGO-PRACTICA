package EjercicioPilaLista;
import Actividad1.ExceptionIsEmpty;
public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty {
        Stack<String> pila = new StackLink<>();

        pila.push("A");
        pila.push("B");
        pila.push("C");
        pila.push("D");

        System.out.println("Stack: " + pila); //D-> C -> B-> A
        System.out.println("Top: " + pila.top()); //D

        System.out.println("Pop: " + pila.pop()); //elimina D
        System.out.println("Stack despues de pop: " + pila); // C ->B -> A
    }
}
