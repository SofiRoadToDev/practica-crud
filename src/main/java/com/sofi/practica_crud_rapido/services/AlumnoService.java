package com.sofi.practica_crud_rapido.services;

import com.sofi.practica_crud_rapido.entities.Alumno;
import com.sofi.practica_crud_rapido.exceptions.ElementNotFoundException;

import java.util.Set;

public interface AlumnoService {


    Alumno findById(Long id) throws ElementNotFoundException;

    Set<Alumno> findAll();

    Alumno findByDni(String dni) throws ElementNotFoundException;

    void deleteAlumno(Long id) throws ElementNotFoundException;

    Alumno crearAlumno(Alumno alumno);

    Alumno editarAlumno(Alumno alumno);

}
