package com.fumoliteratura.literatura.principal;

import com.fumoliteratura.literatura.service.ConsumoAPI;

import java.util.Scanner;

public class Principal {

    private Scanner keyboard = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";


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
}
