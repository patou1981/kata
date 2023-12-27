package codewars;

public class Geometry {
    public static double squareArea(double a) {

        final double rayon = 2 * a / Math.PI;
        return Math.round(rayon * rayon* 100.0)/ 100.0;
    }
}
