package com.registro.alumnos.controller;

import com.registro.alumnos.dto.AlumnoRequestDTO;
import com.registro.alumnos.dto.AlumnoResponseDTO;
import com.registro.alumnos.service.interfaces.AlumnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @PostMapping
    public ResponseEntity<AlumnoResponseDTO> registrar(@RequestBody AlumnoRequestDTO dto){

        return ResponseEntity.ok(alumnoService.registrarAlumno(dto));
    }
    @GetMapping
    public ResponseEntity<List<AlumnoResponseDTO>> listar(){

        return ResponseEntity.ok(alumnoService.listarAlumnos());
    }
}