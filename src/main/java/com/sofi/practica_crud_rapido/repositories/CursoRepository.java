package com.sofi.practica_crud_rapido.repositories;

import com.sofi.practica_crud_rapido.entities.Curso;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CursoRepository extends CrudRepository<Curso, Long> {

    Optional<Curso> findByCodigo(String codigo);

}
