package Servicios;

import Dominio.Pelicula;

public interface IServiciosPeliculas
{
    public void listarPeliculas();
    public void agregarPeliculas(Pelicula nombre);
    public void buscarPeliculas(Pelicula nombre);
    public void eliminarPeliculas(Pelicula nombre);
}
