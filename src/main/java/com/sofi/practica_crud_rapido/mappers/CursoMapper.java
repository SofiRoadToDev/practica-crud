package com.sofi.practica_crud_rapido.mappers;

import com.sofi.practica_crud_rapido.DTOs.CursoDTO;
import com.sofi.practica_crud_rapido.entities.Curso;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    CursoMapper INSTANCE = Mappers.getMapper(CursoMapper.class);
    Curso cursoDTOtoCurso(CursoDTO cursoDTO);
    CursoDTO cursotoCursoDTO(Curso curso);
    Set<Curso>setCursoDTOtoSetCurso(Set<CursoDTO> cursoDTOSet);
    Set<CursoDTO>setCursotoSetCursoDTO(Set<Curso> cursoSet);
}
