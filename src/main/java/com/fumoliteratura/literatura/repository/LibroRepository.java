package com.fumoliteratura.literatura.repository;

import com.fumoliteratura.literatura.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro,Long> {
    Libro findLibroByTitulo(String nombreLibro);

    List<Libro> findLibroByIdiomasContaining(String idiomas);
}
