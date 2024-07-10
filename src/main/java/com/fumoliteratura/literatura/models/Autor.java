package com.fumoliteratura.literatura.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    private String fechaNacimiento;

    private String fechaMuerte;
    private List<Libro> libroList;
    public Autor(){}
    public Autor(DatosAutores autor){
        
    }

}
