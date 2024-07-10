package com.fumoliteratura.literatura.principal;

import com.fumoliteratura.literatura.models.*;
import com.fumoliteratura.literatura.repository.AutorRepository;
import com.fumoliteratura.literatura.repository.LibroRepository;
import com.fumoliteratura.literatura.service.ConsumoAPI;
import com.fumoliteratura.literatura.service.ConversorDatos;

import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner keyboard = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    private ConversorDatos conversor=new ConversorDatos();
    private LibroRepository libroRepository;
    private AutorRepository autorRepository;

    public Principal(LibroRepository libroRepository,AutorRepository autorRepository){
        this.libroRepository=libroRepository;
        this.autorRepository=autorRepository;
    }


    public void mostrarMenu() {

        var opcion = -1;
        var menu = """
                1. Buscar Libro Por Título
                2. Listar Libros Registrados
                3. Listar Autores Registrados
                4. Listar Autores Vivos En Un Determinado Año
                5. Listar Libros Por Idioma
                                          
                0. Salir
                """;
        while (opcion != 0) {
            System.out.println(menu);
            opcion = Integer.parseInt(keyboard.nextLine());

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    listarAutoresVivosAño();
                    break;
                case 5:
                    listarLibrosIdioma();
                    break;
                case 0:
                    System.out.println("Gracias por usar la aplicación...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }

    //Obtener resultado de busqueda
    private DatosResultadoBusqueda getResultadoBusqueda() {
        System.out.println("Por favor escribe el nombre del libro que desea buscar");
        var nombreLibro = keyboard.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE+"?search="+nombreLibro.replace(" ","+"));
        var datos = conversor.obtenerDatos(json, DatosResultadoBusqueda.class);
        return datos;
    }
    private void buscarLibroPorTitulo() {
        DatosResultadoBusqueda busqueda=getResultadoBusqueda();
        //Verificar que se obtuvieron resultados
        if (busqueda.datosLibros().size()>0){
            //Almacenar resultados
            DatosLibro librodatos=busqueda.datosLibros().get(0);
            DatosAutor autordatos=librodatos.autores().get(0);
            //Verificar que el libro se encuentre en la DB
            var tituloObtenido=libroRepository.findLibroByTitulo(librodatos.titulo());
            if (tituloObtenido!=null){
                System.out.println("El libro ya se encuentra registrado en la base de datos.");
            }
            else {
                //
                var autorLibro=autorRepository.findAutorByNombreIgnoreCase(autordatos.nombre());
                Libro libro;
                if (autorLibro!=null){
                    libro=new Libro(librodatos,autorLibro);
                }
                else {
                    Autor autor=new Autor(autordatos);
                    autorRepository.save(autor);
                    libro=new Libro(librodatos,autorLibro);
                }
                libroRepository.save(libro);
                System.out.println(libro);
            }
        }
        else {
            System.out.println("Libro no encontrado");
        }
    }

    private void listarLibros() {
        List<Libro> libros=libroRepository.findAll();
        if (libros.isEmpty()){
            System.out.println("No hay ningún libro registrado en la base de datos");
        }
        else {
            libros.forEach(System.out::println);
        }
    }
    private void listarAutores() {
        List<Autor> autores=autorRepository.findAll();
        if (autores.isEmpty()){
            System.out.println("No hay ningún autor registrado en la base de datos");
        }
        else {
            autores.forEach(System.out::println);
        }
    }
    private void listarAutoresVivosAño() {
        System.out.println("Por favor ingrese el año de nacimiento del autor que desea buscar");
        var fechaNacimiento=Integer.parseInt(keyboard.nextLine());
        List<Autor> autores=autorRepository.findAutorByFechaNacimientoLessThanEqualAndFechaMuerteGreaterThanEqual(fechaNacimiento,fechaNacimiento);
        if (autores.isEmpty()){
            System.out.println("No hay autores registrados en la fecha ingresada");
        }
        else {
            System.out.println(autores);
        }
    }
    private void listarLibrosIdioma() {
        var menu = """
                Por favor ingrese las primeras letras del idioma deseado
                es - Español
                en - Ingles
                ja - Japonés
                pt - Portugués
                fr - Frances
                fi - Finlandés
                it - Italiano
                zh - Chíno
                ko - Coreano                
                """;
        System.out.println(menu);
        String idiomaUsuario= keyboard.nextLine();
        List <Libro> librosPorIdioma=libroRepository.findLibroByIdiomasContaining(idiomaUsuario);
        if (librosPorIdioma.isEmpty()){
            System.out.println("No hay libros en la base de datos con ese idioma");
        }
        else {
            System.out.printf("Los Libros con el idioma " +idiomaUsuario +" son:");
            librosPorIdioma.forEach(System.out::println);
        }

    }
}
