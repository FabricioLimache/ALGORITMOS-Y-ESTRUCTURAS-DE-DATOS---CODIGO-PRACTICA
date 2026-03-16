public class Verificador {

    // Caso 1: Los rectángulos se sobreponen (comparten área positiva)
    public static boolean esSobrePos(Rectangulo r1, Rectangulo r2) {
        double xIzq = Math.max(r1.getEsquina1().getX(), r2.getEsquina1().getX());
        double yInf = Math.max(r1.getEsquina1().getY(), r2.getEsquina1().getY());
        double xDer = Math.min(r1.getEsquina2().getX(), r2.getEsquina2().getX());
        double ySup = Math.min(r1.getEsquina2().getY(), r2.getEsquina2().getY());

        return (xIzq < xDer) && (yInf < ySup);
    }

    // Caso 2: Los rectángulos están juntos (se tocan pero no comparten área)
    public static boolean esJunto(Rectangulo r1, Rectangulo r2) {
        if (esSobrePos(r1, r2)) {
            return false;
        }

        double x1Min = r1.getEsquina1().getX();
        double y1Min = r1.getEsquina1().getY();
        double x1Max = r1.getEsquina2().getX();
        double y1Max = r1.getEsquina2().getY();

        double x2Min = r2.getEsquina1().getX();
        double y2Min = r2.getEsquina1().getY();
        double x2Max = r2.getEsquina2().getX();
        double y2Max = r2.getEsquina2().getY();

        // Se tocan verticalmente: un lado derecho con un lado izquierdo
        boolean toqueVertical = (x1Max == x2Min || x2Max == x1Min) &&
                (Math.max(y1Min, y2Min) <= Math.min(y1Max, y2Max));

        // Se tocan horizontalmente: un lado superior con un lado inferior
        boolean toqueHorizontal = (y1Max == y2Min || y2Max == y1Min) &&
                (Math.max(x1Min, x2Min) <= Math.min(x1Max, x2Max));

        return toqueVertical || toqueHorizontal;
    }

    // Caso 3: Son disjuntos
    public static boolean esDisJunto(Rectangulo r1, Rectangulo r2) {
        return !esSobrePos(r1, r2) && !esJunto(r1, r2);
    }
}