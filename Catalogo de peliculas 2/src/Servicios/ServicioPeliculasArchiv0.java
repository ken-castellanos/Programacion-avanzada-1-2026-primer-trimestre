package Servicios;

import Dominio.Pelicula;

import java.io.*;
import java.nio.channels.ScatteringByteChannel;

public class ServicioPeliculasArchiv0 implements IServiciosPeliculas
{
    private final String NOMBRE_ARCHIVO="Peliculas.txt";

    public ServicioPeliculasArchiv0()
    {

        var archivo=new File(NOMBRE_ARCHIVO);
        try
        {
            if(archivo.exists())
            {
                System.out.println("YA EXISTE EL ARCHIVO");
            }
            else
            {
                var salida=new PrintWriter(new FileWriter(archivo));
            }
        }
        catch(IOException e)
        {
            System.out.println("ERROR CON EL ARCHIVO, MENSAJE: "+ (e.getMessage()));
        }
    }

    @Override
    public void listarPeliculas() {
        var archivo = new File(NOMBRE_ARCHIVO);
        try
        {
            if (archivo.exists())
            {
                System.out.println("Listando peliculas:");
                var entrada = new BufferedReader(new FileReader(archivo));
                String linea = entrada.readLine();

                while (linea != null)
                {
                    var pelicula = new Pelicula(linea);
                    System.out.println(pelicula);
                    linea = entrada.readLine();
                }
                entrada.close();
            }
            else
            {
                System.out.println("El archivo de películas aún no existe.");
            }
        } catch (Exception e)
        {
            System.out.println("Error al listar películas: " + e.getMessage());
        }
    }

    @Override
    public void agregarPeliculas(Pelicula pelicula) {
        File archivo = new File(NOMBRE_ARCHIVO);

        try
        {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            String nuevaPelicula = pelicula.getNombre();
            if (nuevaPelicula != null && !nuevaPelicula.isEmpty()) {
                salida.println(nuevaPelicula);
                System.out.println("Pelicula: " + nuevaPelicula + " agregada correctamente al archivo.");
            }
            else
            {
                System.out.println("Error: La película no tiene nombre válido.");
            }
            salida.close();
        }
        catch (Exception e)
        {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    @Override
    public void buscarPeliculas(Pelicula pelicula)
    {
        File archivo = new File(NOMBRE_ARCHIVO);

        try
        {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto = entrada.readLine();
            int indice = 1;
            boolean encontrada = false;

            for(String peliculaBuscar = pelicula.getNombre(); lineaTexto != null; ++indice)
            {
                if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto))
                {
                    encontrada = true;
                    break;
                }

                lineaTexto = entrada.readLine();
            }

            if (encontrada)
            {
                System.out.println("Pelicula " + lineaTexto + " esta en la linea " + indice);
            }
            else
            {
                System.out.println("Pelicula " + pelicula.getNombre() + " no encontrado");
            }

            entrada.close();
        }
        catch (Exception e)
        {
            System.out.println("Error al buscar el archivo" + e.getMessage());
        }
}

    @Override
    public void eliminarPeliculas(Pelicula pelicula)
    {
        File archivoOriginal = new File(NOMBRE_ARCHIVO);
        File archivoTemp = new File("peliculas_temp.txt");

        try
        {
            BufferedReader entrada = new BufferedReader(new FileReader(archivoOriginal));
            PrintWriter salida = new PrintWriter(new FileWriter(archivoTemp));

            String lineaTexto = entrada.readLine();
            String peliculaBorrar = pelicula.getNombre();
            boolean encontrada = false;

            while (lineaTexto != null)
            {
                if (peliculaBorrar != null && !peliculaBorrar.equalsIgnoreCase(lineaTexto))
                {
                    salida.println(lineaTexto);
                }
                else
                {
                    encontrada = true;
                    System.out.println("Pelicula " + lineaTexto + " eliminada de la lista.");
                }
                lineaTexto = entrada.readLine();
            }
            entrada.close();
            salida.close();

            if (encontrada)
            {
                if (archivoOriginal.delete())
                {
                    archivoTemp.renameTo(archivoOriginal);
                }
                else
                {
                    System.out.println("No se pudo borrar el archivo original.");
                }
            }
            else
            {
                System.out.println("La película no existe, no se ha borrado nada.");
                archivoTemp.delete();
            }

        }
        catch (Exception e)
        {
            System.out.println("Error al eliminar la película: " + e.getMessage());
        }
    }
}
