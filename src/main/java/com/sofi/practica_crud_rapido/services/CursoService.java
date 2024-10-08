package com.sofi.practica_crud_rapido.services;

import com.sofi.practica_crud_rapido.entities.Curso;
import com.sofi.practica_crud_rapido.exceptions.ElementDuplicatedException;
import com.sofi.practica_crud_rapido.exceptions.ElementNotFoundException;

import java.util.Set;

public interface CursoService {

    Curso findById (Long id) throws ElementNotFoundException;

    Set<Curso> findAll();

    void deleteCurso(Long id) throws ElementNotFoundException;

    Curso crearCurso(Curso curso) throws ElementDuplicatedException;

    Curso editarCurso(Curso curso) throws ElementNotFoundException;
}
