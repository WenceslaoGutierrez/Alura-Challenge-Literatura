package com.fumoliteratura.literatura.repository;

import com.fumoliteratura.literatura.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository <Autor, Long> {
    Autor findAutorByNombreIgnoreCase(String nombre);

    List<Autor> findAutorByFechaNacimientoLessThanEqualAndFechaMuerteGreaterThanEqual(int fechaNacimiento,int fechaMuerte);
}
