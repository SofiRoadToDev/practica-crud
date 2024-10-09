package com.sofi.practica_crud_rapido.controllers;

import com.sofi.practica_crud_rapido.exceptions.ElementDuplicatedException;
import com.sofi.practica_crud_rapido.exceptions.ElementNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.ControllerAdvice( annotations = RestController.class)
@Log4j2
public class ControllerAdvice {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?>handleValidationErrors(MethodArgumentNotValidException ex){
        Map<String, String> errores = ex.getBindingResult().getFieldErrors()
                .stream().collect(Collectors.toMap(
                e -> e.getField(),
                e -> e.getDefaultMessage()
        ));
        log.info(errores);
        return ResponseEntity.badRequest().body(errores);
    }


    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?>handleNotFoundResource(ElementNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<?>handleDuplicatedResource(ElementDuplicatedException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

}
