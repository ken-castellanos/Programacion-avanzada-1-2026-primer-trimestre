package Dominio;

public class OperacionesLogaritmicas
    {
    public double logNatural(double x) {
        if (x <= 0) throw new ArithmeticException("Los logaritmos solo definidos para positivos.");
        return Math.log(x);
    }

    public double logBase10(double x)
    {
        if (x <= 0) throw new ArithmeticException("Los logaritmos solo definidos para positivos.");
        return Math.log10(x);
    }
}