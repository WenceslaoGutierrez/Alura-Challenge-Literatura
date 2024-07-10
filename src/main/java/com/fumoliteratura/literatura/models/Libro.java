package com.fumoliteratura.literatura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titulo;
    @ManyToOne
    private List<Autor> autores;
    private List<String> idiomaas;
    private  Integer totalDescargas;

    public Libro(){}
    public Libro(DatosLibros datos){
        this.titulo= datos.titulo();
        this.autores=datos.autores();
        this.idiomaas=datos.idiomas();
        this.totalDescargas= datos.totalDescargas();
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<String> getIdiomaas() {
        return idiomaas;
    }

    public void setIdiomaas(List<String> idiomaas) {
        this.idiomaas = idiomaas;
    }

    public Integer getTotalDescargas() {
        return totalDescargas;
    }

    public void setTotalDescargas(Integer totalDescargas) {
        this.totalDescargas = totalDescargas;
    }
}
