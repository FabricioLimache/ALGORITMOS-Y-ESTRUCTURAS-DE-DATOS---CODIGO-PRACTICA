public class Verificador {

    // verifica si se sobreponen
    public static boolean SobrePuestos(Rectangulo r1, Rectangulo r2) {

        if (r1.getEsquina2().getX() <= r2.getEsquina1().getX())
            return false;

        if (r1.getEsquina1().getX() >= r2.getEsquina2().getX())
            return false;

        if (r1.getEsquina2().getY() <= r2.getEsquina1().getY())
            return false;

        if (r1.getEsquina1().getY() >= r2.getEsquina2().getY())
            return false;

        return true;
    }

    // verifica si solo se tocan
    public static boolean Juntos(Rectangulo r1, Rectangulo r2) {

        if (SobrePuestos(r1, r2))
            return false;

        if (r1.getEsquina2().getX() == r2.getEsquina1().getX())
            return true;

        if (r1.getEsquina1().getX() == r2.getEsquina2().getX())
            return true;

        if (r1.getEsquina2().getY() == r2.getEsquina1().getY())
            return true;

        if (r1.getEsquina1().getY() == r2.getEsquina2().getY())
            return true;

        return false;
    }

    // no tienen contacto
    public static boolean Disjuntos(Rectangulo r1, Rectangulo r2) {
        return !SobrePuestos(r1, r2) && !Juntos(r1, r2);
    }
}