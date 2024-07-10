package com.fumoliteratura.literatura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosAutores(
        @JsonAlias("name")
    String nombre,
        @JsonAlias("birth_year")
    String fechaNacimiento,
        @JsonAlias("death_year")
    String fechaMuerte,
        List<Libro> libroList){
}