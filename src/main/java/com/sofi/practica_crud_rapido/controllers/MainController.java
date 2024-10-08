package com.sofi.practica_crud_rapido.controllers;

import com.sofi.practica_crud_rapido.entities.Alumno;
import com.sofi.practica_crud_rapido.exceptions.ElementDuplicatedException;
import com.sofi.practica_crud_rapido.exceptions.ElementNotFoundException;
import com.sofi.practica_crud_rapido.services.AlumnoService;
import com.sofi.practica_crud_rapido.services.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/alumnos/{id}")
    public ResponseEntity<?>borrarAlumno(@PathVariable Long id) throws ElementNotFoundException {
        alumnoService.deleteAlumno(id);
        return ResponseEntity.status(204).body("Borrado exitoso");
    }

    @PostMapping("/alumnos")
    public ResponseEntity<?>crearAlumno(@RequestBody Alumno alumno) throws ElementDuplicatedException {
        return ResponseEntity.status(201).body(alumnoService.crearAlumno(alumno));
    }

    @PutMapping("/alumnos")
    public ResponseEntity<?>editarAlumno(@RequestBody Alumno alumno) throws ElementNotFoundException {
        return ResponseEntity.status(201).body(alumnoService.editarAlumno(alumno));
    }

    @GetMapping("/cursos")
    public ResponseEntity<?>getAllCursos(){
        return ResponseEntity.ok(cursoService.findAll());
    }



}
