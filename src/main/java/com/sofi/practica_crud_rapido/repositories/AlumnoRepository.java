package com.sofi.practica_crud_rapido.repositories;

import com.sofi.practica_crud_rapido.entities.Alumno;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

    Optional<Alumno> findByDni(String dni);


}
