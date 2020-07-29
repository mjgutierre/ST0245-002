public class Main {

    public static void main(String[] args) {
        Contador c = new Contador(" test ");
        for (int i = 0; i < 10; ++i)
            c.incrementar();
        // 10
        System.out.println(c);

        System.out.println();

        Punto p = new Punto(10, 20);
        // 0,0
        System.out.printf("Punto: {%f, %f}\n", p.x(), p.y());
        // 1*sqrt(2)
        System.out.println("Radio Polar: " + p.radioPolar());
        // -45
        System.out.println("Angulo Polar: " + Math.toDegrees(p.anguloPolar()));
        // 2
        System.out.println("Distancia Euclidiana: " + p.distanciaEuclidiana(new Punto(0, 0)));
       
    }
}