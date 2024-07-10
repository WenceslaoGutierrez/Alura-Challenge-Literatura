package com.fumoliteratura.literatura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosAutor(
        @JsonAlias("name")
    String nombre,
        @JsonAlias("birth_year")
    Integer fechaNacimiento,
        @JsonAlias("death_year")
    Integer fechaMuerte,
        List<Libro> libroList){
}