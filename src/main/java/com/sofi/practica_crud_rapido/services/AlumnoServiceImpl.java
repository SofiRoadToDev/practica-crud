package com.sofi.practica_crud_rapido.services;

import com.sofi.practica_crud_rapido.DTOs.AlumnoDTO;
import com.sofi.practica_crud_rapido.entities.Alumno;
import com.sofi.practica_crud_rapido.exceptions.ElementDuplicatedException;
import com.sofi.practica_crud_rapido.exceptions.ElementNotFoundException;
import com.sofi.practica_crud_rapido.mappers.AlumnoMapper;
import com.sofi.practica_crud_rapido.repositories.AlumnoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class AlumnoServiceImpl implements AlumnoService{

    private AlumnoRepository alumnoRepository;
    @Override
    public AlumnoDTO findById(Long id) throws ElementNotFoundException{
        return  AlumnoMapper.INSTANCE.alumnoToAlumnoDTO(
                alumnoRepository.findById(id)
                        .orElseThrow(() -> new ElementNotFoundException(String.format("Alumno id: %s no encontrado", id)))
        );

    }

    @Override
    public Set<AlumnoDTO> findAll() {
        return  AlumnoMapper.INSTANCE.setAlumnotoSetAlumnoDTO(
                StreamSupport.stream(alumnoRepository.findAll().spliterator(), false).collect(Collectors.toSet())
        );

    }

    @Override
    public AlumnoDTO findByDni(String dni) throws ElementNotFoundException{
        return
                AlumnoMapper.INSTANCE.alumnoToAlumnoDTO(
                        alumnoRepository.findByDni(dni).orElseThrow(() ->  new ElementNotFoundException(String.format("Alumno dni: %s no encontrado", dni))));

    }

    @Override
    public void deleteAlumno(Long id) throws ElementNotFoundException{
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(String.format("No se puede borrar al alumno id: %s no encontrado", id)));
        alumnoRepository.delete(alumno);
    }

    @Override
    public AlumnoDTO crearAlumno(AlumnoDTO alumnoDTO)  {
       Optional<Alumno> enDb = alumnoRepository.findByDni(alumnoDTO.getDni());

        if(enDb.isPresent()){
            throw new ElementDuplicatedException(" El alumno dni: "+alumnoDTO.getDni()+ " ya existe");
        }
        return AlumnoMapper.INSTANCE.alumnoToAlumnoDTO(alumnoRepository.save(AlumnoMapper.INSTANCE.alumnoDtoToAlumno(alumnoDTO)));
    }

    @Override
    public AlumnoDTO editarAlumno(AlumnoDTO alumnoDTO, Long id) {
        Alumno alumnoEnDb = alumnoRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(String.format("No se puede editar al alumno id: %s no encontrado", id)));
        BeanUtils.copyProperties(alumnoDTO, alumnoEnDb);
        alumnoRepository.save(alumnoEnDb);
        return null;
    }
}
