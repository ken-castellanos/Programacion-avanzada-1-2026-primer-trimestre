package Dominio;

public class OperacionesTrigonometricas {

    // Convertimos a radianes aquí para encapsular la lógica matemática
    private double aRadianes(double grados) {
        return Math.toRadians(grados);
    }

    public double seno(double grados) {
        return Math.sin(aRadianes(grados));
    }

    public double coseno(double grados) {
        return Math.cos(aRadianes(grados));
    }

    public double tangente(double grados) {
        double tan = Math.tan(aRadianes(grados));
        // Lógica de validación matemática pura
        if (Math.abs(tan) > 1e10) throw new ArithmeticException("Indefinido (tiende a infinito)");
        return tan;
    }

    public double cosecante(double grados) {
        double seno = seno(grados);
        if (Math.abs(seno) < 1e-10) throw new ArithmeticException("Indefinido (seno ≈ 0)");
        return 1.0 / seno;
    }

    public double secante(double grados) {
        double coseno = coseno(grados);
        if (Math.abs(coseno) < 1e-10) throw new ArithmeticException("Indefinido (coseno ≈ 0)");
        return 1.0 / coseno;
    }

    public double cotangente(double grados) {
        double tan = Math.tan(aRadianes(grados));
        if (Math.abs(tan) < 1e-10) throw new ArithmeticException("Indefinido (tangente ≈ 0)");
        return 1.0 / tan;
    }
}