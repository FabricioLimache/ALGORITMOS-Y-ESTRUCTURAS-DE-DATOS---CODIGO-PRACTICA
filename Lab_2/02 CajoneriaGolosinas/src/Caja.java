
//clase genérica que tiene un color y almacena un objeto de cualquier tipo
public class Caja<T> {
    private String color;
    private T obj; //Golosina, Chocolatina ..

    public Caja(String color, T obj) {
        this.color = color;
        this.obj = obj;
    }

    //getters y setters
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public T getObjeto() { return obj; }
    public void setObjeto(T objeto) { this.obj = objeto; }

    @Override
    public String toString() {
        return "Caja{color='" + color + "', objeto=" + obj + "}";
    }
}