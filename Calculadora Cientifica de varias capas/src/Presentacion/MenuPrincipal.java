package Presentacion;

import Servicios.Servicio;
import java.util.Scanner;

public class MenuPrincipal {

    private final Scanner sc;
    private final Servicio servicio;

    public MenuPrincipal() {
        this.sc = new Scanner(System.in);
        this.servicio = new Servicio();
    }

    public void iniciar() {
        int menu = 0;
        while (menu != -1) {
            System.out.println("\n=== Calculadora Científica (Capas) ===");
            System.out.println("1: Operaciones Aritméticas");
            System.out.println("2: Operaciones Trigonométricas");
            System.out.println("3: Operaciones Logarítmicas");
            System.out.println("-1: Salir");
            System.out.print("Elija una opción: ");

            if (sc.hasNextInt()) {
                menu = sc.nextInt();
                switch (menu) {
                    case 1 -> menuAritmetico();
                    case 2 -> menuTrigonometrico();
                    case 3 -> menuLogaritmico();
                    case -1 -> System.out.println("Gracias por usar la calculadora.");
                    default -> System.out.println("Opción no válida");
                }
            } else {
                System.out.println("Por favor ingrese un número.");
                sc.next();
            }
        }
        sc.close();
    }

    private void menuAritmetico() {
        int submenu = 0;
        while (submenu != -1) {
            System.out.println("\n--- Operaciones Aritméticas ---");
            System.out.println("1: Suma | 2: Resta | 3: Multi | 4: Div | -1: Volver");
            System.out.print("Opción: ");
            submenu = sc.nextInt();

            if (submenu == -1) break;
            if (submenu < 1 || submenu > 4) {
                System.out.println("Opción inválida");
                continue;
            }

            double a = pedirNumero("Ingrese primer número: ");
            double b = pedirNumero("Ingrese segundo número: ");

            try {
                double res = 0;
                switch (submenu) {
                    case 1 -> res = servicio.calcularSuma(a, b);
                    case 2 -> res = servicio.calcularResta(a, b);
                    case 3 -> res = servicio.calcularMultiplicacion(a, b);
                    case 4 -> res = servicio.calcularDivision(a, b);
                }
                System.out.println("Resultado: " + res);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void menuTrigonometrico() {
        int submenu = 0;
        while (submenu != -1) {
            System.out.println("\n--- Operaciones Trigonométricas ---");
            System.out.println("1: Sen | 2: Cos | 3: Tan | 4: Csc | 5: Sec | 6: Cot | -1: Volver");
            System.out.print("Opción: ");
            submenu = sc.nextInt();

            if (submenu == -1) break;
            if (submenu < 1 || submenu > 6) {
                System.out.println("Opción inválida");
                continue;
            }

            double angulo = pedirNumero("Ingrese ángulo en grados: ");

            try {
                double res = 0;
                switch (submenu) {
                    case 1 -> res = servicio.calcularSeno(angulo);
                    case 2 -> res = servicio.calcularCoseno(angulo);
                    case 3 -> res = servicio.calcularTangente(angulo);
                    case 4 -> res = servicio.calcularCosecante(angulo);
                    case 5 -> res = servicio.calcularSecante(angulo);
                    case 6 -> res = servicio.calcularCotangente(angulo);
                }
                System.out.println("Resultado: " + res);
            } catch (Exception e) {
                System.out.println("Error matemático: " + e.getMessage());
            }
        }
    }

    private void menuLogaritmico() {
        int submenu = 0;
        while (submenu != -1) {
            System.out.println("\n--- Operaciones Logarítmicas ---");
            System.out.println("1: LogNatural | 2: Log10 | -1: Volver");
            System.out.print("Opción: ");
            submenu = sc.nextInt();

            if (submenu == -1) break;
            if (submenu < 1 || submenu > 2) {
                System.out.println("Opción inválida");
                continue;
            }

            double x = pedirNumero("Ingrese número positivo: ");

            try {
                double res = 0;
                switch (submenu) {
                    case 1 -> res = servicio.calcularLogNatural(x);
                    case 2 -> res = servicio.calcularLogBase10(x);
                }
                System.out.println("Resultado: " + res);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private double pedirNumero(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextDouble()) {
            System.out.println("Entrada inválida. Ingrese un número.");
            sc.next();
        }
        return sc.nextDouble();
    }
}