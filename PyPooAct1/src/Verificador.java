
public class Verificador {

    // Para saber si estan sobrepuestos verificamos que no tengan una area compartida entre ambos
    public static boolean SobrePuestos(Rectangulo r1, Rectangulo r2) {
        // buscamos razones para darnos cuenta que NO se tocan.
        // Si R1 está a la izquierda de R2 o a la derecha o abajo o arriba, entonces NO hay sobreposición.
        if (r1.getEsquina2().getX() <= r2.getEsquina1().getX() ||
                r1.getEsquina1().getX() >= r2.getEsquina2().getX() ||
                r1.getEsquina2().getY() <= r2.getEsquina1().getY() ||
                r1.getEsquina1().getY() >= r2.getEsquina2().getY()) {
            return false;
        }

        // si no se cumple ninguna de las condiciones de separacion, significa que comparten area,
        // entonces estan sobrepuestos
        return true;
    }

    // juntos, pueden tocarse en los bordes pero no invaden al otro rectangulo
    public static boolean Juntos(Rectangulo r1, Rectangulo r2) {
        // primero validamos si se sobre ponen, si ya invaden el area del otro no pueden estar solo juntos
        if (SobrePuestos(r1, r2)) {
            return false;
        }

        // Verificamos contacto en X pero validando que el rango en Y coincida (para que no esten uno lejos del otro)
        boolean tocaX = (r1.getEsquina2().getX() == r2.getEsquina1().getX() || r1.getEsquina1().getX() == r2.getEsquina2().getX());
        boolean rangoY = (r1.getEsquina1().getY() < r2.getEsquina2().getY() && r1.getEsquina2().getY() > r2.getEsquina1().getY());

        // Verificamos contacto en Y pero validando que el rango en X coincida
        boolean tocaY = (r1.getEsquina2().getY() == r2.getEsquina1().getY() || r1.getEsquina1().getY() == r2.getEsquina2().getY());
        boolean rangoX = (r1.getEsquina1().getX() < r2.getEsquina2().getX() && r1.getEsquina2().getX() > r2.getEsquina1().getX());

        // si choca un borde y los rangos del otro eje se cruzan, estan realmente juntos
        return (tocaX && rangoY) || (tocaY && rangoX);//retorna true si alguno de los 2 se cumple
    }

    // disjuntos, no se tocan, no tienen relacion
    public static boolean Disjuntos(Rectangulo r1, Rectangulo r2) {
        // verifica si estan sobrepuestos o juntos
        // si ninguno es verdadero, entonces son disjuntos
        return !SobrePuestos(r1, r2) && !Juntos(r1, r2);//retorna true si no estan sobrepuestos ni juntos
    }
}
