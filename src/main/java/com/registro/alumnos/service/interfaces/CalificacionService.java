package com.registro.alumnos.service.interfaces;

import com.registro.alumnos.dto.CalificacionRequestDTO;
import com.registro.alumnos.dto.CalificacionResponseDTO;
import java.util.List;

public interface CalificacionService {

    CalificacionResponseDTO registrarCalificacion(CalificacionRequestDTO dto);
    CalificacionResponseDTO actualizarCalificacion(Long id, CalificacionRequestDTO dto);
    void eliminarCalificacion(Long calificacionId);
    List<CalificacionResponseDTO> listarCalificaciones();
}