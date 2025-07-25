package com.registro.alumnos.service.interfaces;

import com.registro.alumnos.dto.AlumnoRequestDTO;
import com.registro.alumnos.dto.AlumnoResponseDTO;
import java.util.List;

public interface AlumnoService {

    AlumnoResponseDTO registrarAlumno(AlumnoRequestDTO dto);
    List<AlumnoResponseDTO> listarAlumnos();
}