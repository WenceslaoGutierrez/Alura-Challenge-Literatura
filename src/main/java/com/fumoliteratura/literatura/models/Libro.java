package com.fumoliteratura.literatura.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true,nullable = false)
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "autor_id",nullable = false)
    private Autor autor;
    private String autorNombre;
    private String idiomas;
    private  Integer totalDescargas;

    public Libro(){}
    public Libro(DatosLibro datos,Autor autor){
        this.titulo= datos.titulo();
        this.autorNombre=autor.getNombre();
        this.idiomas=datos.idiomas().get(0);
        this.totalDescargas= datos.totalDescargas();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getAutorNombre() {
        return autorNombre;
    }

    public void setAutorNombre(String autorNombre) {
        this.autorNombre = autorNombre;
    }

    public String getIdiomaas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getTotalDescargas() {
        return totalDescargas;
    }

    public void setTotalDescargas(Integer totalDescargas) {
        this.totalDescargas = totalDescargas;
    }
}
