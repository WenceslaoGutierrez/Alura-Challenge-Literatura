package com.fumoliteratura.literatura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosResultadoBusqueda(
    @JsonAlias("results")
    List<DatosLibro> datosLibros){
}
