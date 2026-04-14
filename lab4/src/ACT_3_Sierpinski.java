import javax.swing.*;
import java.awt.*;

public class ACT_3_Sierpinski extends JPanel {
    private int nivelDeseado;

    public ACT_3_Sierpinski(int nivel) {
        this.nivelDeseado = nivel;
    }

    public void drawTriangle(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int nivel) {
        if (nivel == 0) { // Caso base nivel de recursión llega a 0
            int[] xPoints = {x1, x2, x3};
            int[] yPoints = {y1, y2, y3};
            g.fillPolygon(xPoints, yPoints, 3);
        } else {
            // Avance recursivo se divide el triángulo en partes mAs pequeñas
            int mx12 = (x1 + x2) / 2;
            int my12 = (y1 + y2) / 2;
            int mx23 = (x2 + x3) / 2;
            int my23 = (y2 + y3) / 2;
            int mx31 = (x3 + x1) / 2;
            int my31 = (y3 + y1) / 2;

            drawTriangle(g, x1, y1, mx12, my12, mx31, my31, nivel - 1);
            drawTriangle(g, mx12, my12, x2, y2, mx23, my23, nivel - 1);
            drawTriangle(g, mx31, my31, mx23, my23, x3, y3, nivel - 1);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTriangle(g, 100, 500, 500, 500, 300, 100, nivelDeseado);
    }

    public static void main(String[] args) {
        // Ejecutamos las pruebas para 4, 6 y 8 niveles
        int[] nivelesPrueba = {4, 6, 8};

        for (int n : nivelesPrueba) {
            JFrame frame = new JFrame("Sierpinski - Nivel " + n);
            ACT_3_Sierpinski panel = new ACT_3_Sierpinski(n);
            frame.add(panel);
            frame.setSize(600, 600);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }
}