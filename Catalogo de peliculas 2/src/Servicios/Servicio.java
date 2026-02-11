package Servicios;

import Dominio.Pelicula;
import java.util.ArrayList;

public class Servicio implements IServiciosPeliculas
{
    ArrayList<Pelicula> peliculas= new ArrayList();
    @Override
    public void listarPeliculas()
    {
        System.out.println("Listado de Peliculas");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPeliculas(Pelicula pelicula)
    {
        peliculas.add(pelicula);
        System.out.println("Agregando pelicula..."+pelicula+" Agregado");
    }

    @Override
    public void buscarPeliculas(Pelicula nombre) {
        var indice = peliculas.indexOf(peliculas);


        if (indice >= 0){
            System.out.println("Pelicula encontrada en indice [" + indice + "]");
        }
        else
        {
            System.out.println("No se encontro la pelicula");
        }
    }

    @Override
    public void eliminarPeliculas(Pelicula nombre) {

    }

    public static void main (String[] args)
    {
        var pelicula1=new Pelicula("Ted");
        var pelicula2=new Pelicula("X-Men");
        var pelicula3 =new Pelicula("So long world");

        IServiciosPeliculas serviciosPeliculas=new Servicio();
        serviciosPeliculas.agregarPeliculas(pelicula1);
        serviciosPeliculas.agregarPeliculas(pelicula2);
        serviciosPeliculas.agregarPeliculas(pelicula3);
        serviciosPeliculas.listarPeliculas();
        serviciosPeliculas.buscarPeliculas(pelicula1);

        serviciosPeliculas.buscarPeliculas(new Pelicula("Ted"));
    }
}
