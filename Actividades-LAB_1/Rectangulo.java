public class Rectangulo {

    private Coordenada esquina1; // sera la inferior izquierda
    private Coordenada esquina2; // sera la superior derecha


    public Rectangulo(Coordenada c1, Coordenada c2) {//constructor
        setEsquinas_Ordenadas(c1, c2);
    }

    // metodo que ordena las esquinas, no importa el usuario ingreso incorrectamente las coordenadas siempre las ordenas como esquina1 siempre será la punta inferior-izquierda y esquina2 la superior-derecha
    private void setEsquinas_Ordenadas(Coordenada c1, Coordenada c2) {
        //usaremos la esquina inferior izq y la exquina superior derecha como coordenaras

        // Buscamos los valores mínimos para la esquina inferior izquierda
        double minX = Math.min(c1.getX(), c2.getX());//seleciona el minimo entre ambas X de ambas coordenadas y lo define como minX
        double minY = Math.min(c1.getY(), c2.getY());//seleciona el minimo entre ambas Y de ambas coordenadas y lo define como minY

        // Buscamos los valores máximos para la esquina superior derecha
        double maxX = Math.max(c1.getX(), c2.getX());//seleciona el maximo entre ambas X de ambas coordenadas y lo define como mAxX
        double maxY = Math.max(c1.getY(), c2.getY());//seleciona el maximo entre ambas Y de ambas coordenadas y lo define como mAxY

        //creamos dos nuevas coordenadas, esquina1 siempre será la punta inferior-izquierda y esquina2 la superior-derecha

        this.esquina1 = new Coordenada(minX, minY);//definimos esquina 1 como el minimo de ambas coordendas
        this.esquina2 = new Coordenada(maxX, maxY);//definimos esquina 2 como el maximo de ambas coordenadas
    }


    //setters
    //usamos los setters para cambiar una de las esquinas despues de haber creado el objeto rectangulo

    public void setEsquina1(Coordenada c) {//cambiamos esquina1
        setEsquinas_Ordenadas(c, this.esquina2);
    }

    public void setEsquina2(Coordenada c) {//cambiamos esquina2
        setEsquinas_Ordenadas(this.esquina1, c);
    }

    //getters
    public Coordenada getEsquina1() { return this.esquina1; }
    public Coordenada getEsquina2() { return this.esquina2; }

    public double calculoArea() {
        // como las esquinas ya estan ordenadas simplemente calculamos la base y la altura
        double base = esquina2.getX() - esquina1.getX();
        double altura = esquina2.getY() - esquina1.getY();
        return base * altura;
    }
}
