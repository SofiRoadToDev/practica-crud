package com.sofi.practica_crud_rapido.services;

import com.sofi.practica_crud_rapido.DTOs.AlumnoDTO;
import com.sofi.practica_crud_rapido.entities.Alumno;
import com.sofi.practica_crud_rapido.exceptions.ElementNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Set;

public interface AlumnoService {


    AlumnoDTO findById(Long id) throws ElementNotFoundException;

    Set<AlumnoDTO> findAll();

    AlumnoDTO findByDni(String dni) throws ElementNotFoundException;

    void deleteAlumno(Long id) throws ElementNotFoundException;

    AlumnoDTO crearAlumno(AlumnoDTO alumnoDTO) ;

    AlumnoDTO editarAlumno(AlumnoDTO alumnoDTO, Long id) ;

}
