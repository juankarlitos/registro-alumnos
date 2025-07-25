package com.registro.alumnos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> manejarRecursosNoEncontrado(RecursoNoEncontradoException ex){
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("timestamp", LocalDate.now());
        respuesta.put("mensaje", ex.getMessage());
        respuesta.put("codigo", HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> manejarErroresGenerales(Exception ex){

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("timestamp", LocalDate.now());
        respuesta.put("mensaje", "Error interno del servidor");
        respuesta.put("error", ex.getMessage());
        respuesta.put("codigo", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
    }
}