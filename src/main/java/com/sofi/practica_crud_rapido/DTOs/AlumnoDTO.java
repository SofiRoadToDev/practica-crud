package com.sofi.practica_crud_rapido.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlumnoDTO {


    private Long id;
    @Size(min= 1, max = 50, message = "El máximo de caracteres es 50")
    @NotBlank
    @NonNull
    private String nombre;

    @Size(min= 1, max = 50, message = "El máximo de caracteres es 50")
    @NotBlank( message = "El nombre no es obligatorio")
    @NonNull
    private String apellido;

    @Pattern(regexp = "\\d{8}", message = " El dni debe consistir en 8 dígitos, sin puntos")
    @Size(min = 8, max = 8)
    private String dni;

}
