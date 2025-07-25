package com.registro.alumnos.controller;

import com.registro.alumnos.dto.CalificacionRequestDTO;
import com.registro.alumnos.dto.CalificacionResponseDTO;
import com.registro.alumnos.service.interfaces.CalificacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/calificaciones")
public class CalificacionController {

    private final CalificacionService calificacionService;

    public CalificacionController(CalificacionService calificacionService) {
        this.calificacionService = calificacionService;
    }

    @PostMapping
    public ResponseEntity<CalificacionResponseDTO> registrar(@RequestBody CalificacionRequestDTO dto){

        return  ResponseEntity.ok(calificacionService.registrarCalificacion(dto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CalificacionResponseDTO> actualizar(@PathVariable Long id,
                                                              @RequestBody CalificacionRequestDTO dto){

        return ResponseEntity.ok(calificacionService.actualizarCalificacion(id, dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){

        calificacionService.eliminarCalificacion(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<List<CalificacionResponseDTO>> listar(){

        return ResponseEntity.ok(calificacionService.listarCalificaciones());
    }
}