package Servicios;

import Dominio.OperacionesAritmeticas;
import Dominio.OperacionesLogaritmicas;
import Dominio.OperacionesTrigonometricas;

public class Servicio
{

    // Instancias del dominio
    private final OperacionesAritmeticas aritmetica = new OperacionesAritmeticas();
    private final OperacionesTrigonometricas trigonometrica = new OperacionesTrigonometricas();
    private final OperacionesLogaritmicas logaritmica = new OperacionesLogaritmicas();

    // Métodos Aritméticos
    public double calcularSuma(double a, double b) { return aritmetica.sumar(a, b); }
    public double calcularResta(double a, double b) { return aritmetica.restar(a, b); }
    public double calcularMultiplicacion(double a, double b) { return aritmetica.multiplicar(a, b); }
    public double calcularDivision(double a, double b) { return aritmetica.dividir(a, b); }

    // Métodos Trigonométricos
    public double calcularSeno(double g) { return trigonometrica.seno(g); }
    public double calcularCoseno(double g) { return trigonometrica.coseno(g); }
    public double calcularTangente(double g) { return trigonometrica.tangente(g); }
    public double calcularCosecante(double g) { return trigonometrica.cosecante(g); }
    public double calcularSecante(double g) { return trigonometrica.secante(g); }
    public double calcularCotangente(double g) { return trigonometrica.cotangente(g); }

    // Métodos Logarítmicos
    public double calcularLogNatural(double x) { return logaritmica.logNatural(x); }
    public double calcularLogBase10(double x) { return logaritmica.logBase10(x); }
}