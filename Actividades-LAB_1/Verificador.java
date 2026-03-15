public class Verificador {

    //Para saber si estan sobrepuestos verificamos que no tengan una area compartida entre ambos
    public static boolean SobrePuestos(Rectangulo r1, Rectangulo r2) {

        //buscamos razones para darnos cuentas que no se tocan(que estan separados), asi si no se cumple ninguna
        //significa que estan sobrepuestos

        // ¿R1 está totalmente a la izquierda de R2?
        double derechaR1 = r1.getEsquina2().getX();
        double izquierdaR2 = r2.getEsquina1().getX();
        if (derechaR1 <= izquierdaR2) {
            return false;
        }

        // ¿R1 está totalmente a la derecha de R2?
        double izquierdaR1 = r1.getEsquina1().getX();
        double derechaR2 = r2.getEsquina2().getX();
        if (izquierdaR1 >= derechaR2) {
            return false;
        }

        // ¿R1 está totalmente abajo de R2?
        double techoR1 = r1.getEsquina2().getY();
        double sueloR2 = r2.getEsquina1().getY();
        if (techoR1 <= sueloR2) {
            return false;
        }

        // ¿R1 está totalmente arriba de R2?
        double sueloR1 = r1.getEsquina1().getY();
        double techoR2 = r2.getEsquina2().getY();
        if (sueloR1 >= techoR2) {
            return false;
        }


        //si no se cumple ninguno de los if, es xq no encontro ninguna formad e decir que estaban separados,
        //entonces estan sobrepuestos

        return true;
    }

    // juntos, pueden tocarse en los bordes pero no invaden al otro rectangulo
    public static boolean Juntos(Rectangulo r1, Rectangulo r2) {
        // primero validamos si se sobre ponen
        if (SobrePuestos(r1, r2) == true) {
            return false;
        }

        // verificamos contacto en X (si bordes verticales se tocan)
        if (r1.getEsquina2().getX() == r2.getEsquina1().getX()) {
            return true;
        }
        if (r1.getEsquina1().getX() == r2.getEsquina2().getX()) {
            return true;
        }

        // verificamos contacto en Y (si bordes horizontales se tocan)
        if (r1.getEsquina2().getY() == r2.getEsquina1().getY()) {
            return true;
        }
        if (r1.getEsquina1().getY() == r2.getEsquina2().getY()) {
            return true;
        }

        // si no se cumple ningun if, significa que no se tocan en ningun punto
        return false;
    }

    // disjuntos, no se tocan, no tienen relacion
    public static boolean Disjuntos(Rectangulo r1, Rectangulo r2) {
        boolean sobre = SobrePuestos(r1, r2);
        boolean junto = Juntos(r1, r2);

        //verifica si estan sobrepuestos o juntos, si ninguno es verdadero entonces son disjuntos
        //pero si se tocan, no son disjuntos

        if (sobre == false) {
            if (junto == false) {
                return true; // No están chocando ni tocándose
            }
        }
        return false;
    }
}
