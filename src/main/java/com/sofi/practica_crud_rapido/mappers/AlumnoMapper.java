package com.sofi.practica_crud_rapido.mappers;

import com.sofi.practica_crud_rapido.DTOs.AlumnoDTO;
import com.sofi.practica_crud_rapido.entities.Alumno;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface AlumnoMapper {
    AlumnoMapper INSTANCE = Mappers.getMapper(AlumnoMapper.class);
    Alumno alumnoDtoToAlumno(AlumnoDTO alumnoDTO);
    AlumnoDTO alumnoToAlumnoDTO(Alumno alumno);
    Set<Alumno> setAlumnoDTOtoSetAlumno(Set<AlumnoDTO>alumnoDTOSet);
    Set<AlumnoDTO> setAlumnotoSetAlumnoDTO(Set<Alumno>alumnoSet);


}
