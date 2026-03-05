public class Funcion {

    public static double f(double x, double a, double b, double c){
        return a*x*x + b*x + c;
    }

    public static String metodoBiseccion(double coefA, double coefB, double coefC,
                                         double a, double b, double errorPermitido){

        double m = 0;
        double mAnterior = 0;
        double errorActual = 100;
        int iteracion = 0;

        if (f(a,coefA,coefB,coefC) * f(b,coefA,coefB,coefC) > 0) {
            return "No existe raíz en ese intervalo.";
        }

        do {
            m = (a + b) / 2;

            if (iteracion > 0) {
                errorActual = Math.abs(m - mAnterior);
            }

            if (f(a,coefA,coefB,coefC) * f(m,coefA,coefB,coefC) < 0) {
                b = m;
            } else {
                a = m;
            }

            mAnterior = m;
            iteracion++;

        } while (errorActual > errorPermitido);

        return 
               "Iteraciones realizadas: " + iteracion +
               "\nRaíz aproximada: " + m +
               "\nError final: " + errorActual;
    }
}