package com.sofi.practica_crud_rapido.controllers;

import com.sofi.practica_crud_rapido.DTOs.AlumnoDTO;
import com.sofi.practica_crud_rapido.entities.Alumno;
import com.sofi.practica_crud_rapido.exceptions.ElementDuplicatedException;
import com.sofi.practica_crud_rapido.exceptions.ElementNotFoundException;
import com.sofi.practica_crud_rapido.mappers.AlumnoMapper;
import com.sofi.practica_crud_rapido.services.AlumnoService;
import com.sofi.practica_crud_rapido.services.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class MainController {

    private AlumnoService alumnoService;
    private CursoService cursoService;

    @GetMapping("/alumnos")
    public ResponseEntity<?>getAllAlumnos(){
        return ResponseEntity.ok(alumnoService.findAll());
    }

    @GetMapping("/alumnos/{id}")
    public ResponseEntity<?>getById(@PathVariable Long id) throws ElementNotFoundException{
         return ResponseEntity.ok(alumnoService.findById(id));
    }

    @DeleteMapping("/alumnos/{id}")
    public ResponseEntity<?>borrarAlumno(@PathVariable Long id) throws ElementNotFoundException {
        alumnoService.deleteAlumno(id);
        return ResponseEntity.status(204).body("Borrado exitoso");
    }

    @PostMapping("/alumnos")
    public ResponseEntity<?>crearAlumno(@RequestBody Alumno alumno) throws ElementDuplicatedException {
        AlumnoDTO saved = alumnoService.crearAlumno(alumno);
        URI alumnoUri = UriComponentsBuilder
                .fromPath("/alumnos/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(alumnoUri).build();
    }

    @PutMapping("/alumnos")
    public ResponseEntity<?>editarAlumno(@RequestBody Alumno alumno) throws ElementNotFoundException {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cursos")
    public ResponseEntity<?>getAllCursos(){
        return ResponseEntity.ok(cursoService.findAll());
    }






}
