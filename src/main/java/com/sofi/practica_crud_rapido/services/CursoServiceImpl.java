package com.sofi.practica_crud_rapido.services;

import com.sofi.practica_crud_rapido.entities.Curso;
import com.sofi.practica_crud_rapido.exceptions.ElementDuplicatedException;
import com.sofi.practica_crud_rapido.exceptions.ElementNotFoundException;
import com.sofi.practica_crud_rapido.repositories.CursoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class CursoServiceImpl implements CursoService {

    private CursoRepository cursoRepository;
    @Override
    public Curso findById(Long id) throws ElementNotFoundException {
        return cursoRepository.findById(id).orElseThrow(() -> new ElementNotFoundException(String.format(" curso id: %s no encontrado", id)));
    }

    @Override
    public Set<Curso> findAll() {
        return StreamSupport.stream(cursoRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }

    @Override
    public void deleteCurso(Long id) throws ElementNotFoundException {
        Curso curso = cursoRepository.findById(id).orElseThrow(() -> new ElementNotFoundException(String.format(" curso id: %s no encontrado", id)));
        cursoRepository.delete(curso);
    }

    @Override
    public Curso crearCurso(Curso curso) throws ElementDuplicatedException {
       Optional<Curso> cursoExistente = cursoRepository.findByCodigo(curso.getCodigo());
       if(cursoExistente.isPresent()){
            throw new ElementDuplicatedException(" El curso con codigo "+curso.getCodigo()+" ya existe");
       }
        return cursoRepository.save(curso);
    }

    @Override
    public Curso editarCurso(Curso curso) throws ElementNotFoundException {
        Curso cursoInDb = cursoRepository.findById(curso.getId()).orElseThrow(() -> new ElementNotFoundException(String.format(" curso id: %s no encontrado", curso.getId())));
        BeanUtils.copyProperties(curso, cursoInDb, "id");
        return cursoInDb;
    }
}
