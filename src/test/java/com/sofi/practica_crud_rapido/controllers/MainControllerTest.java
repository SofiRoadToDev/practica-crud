package com.sofi.practica_crud_rapido.controllers;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.mysql.cj.xdevapi.JsonArray;
import com.sofi.practica_crud_rapido.DTOs.AlumnoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void shouldReturnAnAlumno(){
        ResponseEntity<AlumnoDTO> response = testRestTemplate
                .getForEntity("/alumnos/1", AlumnoDTO.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getId()).isEqualTo(1);
    }


    @Test
    void shouldReturnAListOfAlumnos(){
        ResponseEntity<String> response = testRestTemplate
                .getForEntity("/alumnos", String.class);
        DocumentContext documentContext = JsonPath.parse(response.getBody());
        int alumnosPrecargados = documentContext.read("$.length()");
        assertThat(alumnosPrecargados).isEqualTo(2);

        JsonArray ids = documentContext.read("$..id");
        assertThat(ids).containsExactlyInAnyOrder();


    }

    @Test
    void shouldReturnCreatedAlumnoUri(){
        AlumnoDTO alumnoDTO = new AlumnoDTO();
        alumnoDTO.setApellido("Torres");
        alumnoDTO.setDni("564646");
        alumnoDTO.setNombre("Juan");
        ResponseEntity<Void> response = testRestTemplate
                .postForEntity("/alumnos", alumnoDTO, Void.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        URI location = response.getHeaders().getLocation();
        ResponseEntity<String> locationResponse = testRestTemplate
                .getForEntity(location, String.class);
        assertThat(locationResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(locationResponse.getBody());
        Number id = documentContext.read("$.id");
        String dni = documentContext.read("$.dni");

        assertThat(id).isNotNull();
        assertThat(dni).isEqualTo(alumnoDTO.getDni());
    }
}
