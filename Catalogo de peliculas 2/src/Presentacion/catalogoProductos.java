package Presentacion;
import java.util.Scanner;

import Dominio.Pelicula;
import Servicios.IServiciosPeliculas;
import Servicios.Servicio;
import Servicios.ServicioPeliculasArchiv0;

public class catalogoProductos {
    public static void main(String[] args) {
        var salir = false;
        var consolas = new Scanner(System.in);
        //IServiciosPeliculas serviciosPeliculas = new Servicio();
        IServiciosPeliculas serviciosPeliculas=new ServicioPeliculasArchiv0();

        while (!salir) {
            try {
                salir = ejectarOpciones(consolas,serviciosPeliculas );
            } catch (Exception e) {
                System.out.println("Ocurrio un error" + e.getMessage());
            }
        }

    }

    private static void mostrarMenu() {
        System.out.println("*** Catalogo de Peliculas ***\n1.Agregar peliculas\n2.Listar peliculas\n3.Buscar peliculas\n4.Eliminar peliculas\n-1.Salir");
    }

    private static boolean ejectarOpciones(Scanner consolas, IServiciosPeliculas serviciosPeliculas) {
        mostrarMenu();
        var opciones = Integer.parseInt(consolas.nextLine());
        var salir = false;

        switch (opciones) {
            case 1 -> {
                System.out.println("Ingresa el nombre de la pelicula");
                var nombrePelicula = consolas.nextLine();
                serviciosPeliculas.agregarPeliculas(new Pelicula(nombrePelicula));
            }
            case 2 -> {
                serviciosPeliculas.listarPeliculas();
            }
            case 3 -> {
                System.out.println("Ingresa el nombre de la pelicula a buscar: ");
                var buscar = consolas.nextLine();
                serviciosPeliculas.buscarPeliculas(new Pelicula(buscar));
            }

            case 4 ->
            {
                System.out.println("Favor ingrese el nombre de la pelicula a eliminar");
                var nombrePelicula = consolas.nextLine();
                serviciosPeliculas.eliminarPeliculas(new Pelicula(nombrePelicula));
            }
            case -1 -> {
                salir = true;
            }
            default -> {
                System.out.println("Favor ingresar numero del 1 al 4 o -1 para salir");
            }
        }
        return salir;
    }
}
