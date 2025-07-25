package com.registro.alumnos.service.impl;

import com.registro.alumnos.dto.AlumnoRequestDTO;
import com.registro.alumnos.dto.AlumnoResponseDTO;
import com.registro.alumnos.entity.Alumno;
import com.registro.alumnos.entity.Materia;
import com.registro.alumnos.exception.RecursoNoEncontradoException;
import com.registro.alumnos.repository.AlumnoRepository;
import com.registro.alumnos.service.interfaces.AlumnoService;
import com.registro.alumnos.service.interfaces.MateriaService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final MateriaService materiaService;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository, MateriaService materiaService) {
        this.alumnoRepository = alumnoRepository;
        this.materiaService = materiaService;
    }
    @Override
    public AlumnoResponseDTO registrarAlumno(AlumnoRequestDTO dto) {

        Materia materia = materiaService.obtenerOMatricularMateria(dto.getMateria());

        Alumno alumno = new Alumno();
        alumno.setNombre(dto.getNombre());
        alumno.setApellidoPaterno(dto.getApellidoPaterno());
        alumno.setApellidoMaterno(dto.getApellidoMaterno());
        alumno.setMateria(materia);

        Alumno guardado = alumnoRepository.save(alumno);

        AlumnoResponseDTO response = new AlumnoResponseDTO();
        response.setId(guardado.getId());
        response.setNombreCompleto(guardado.getNombre() + " " + guardado.getApellidoPaterno() + " " + guardado.getApellidoMaterno());
        response.setMateria(materia.getNombre());
        return response;
    }
    @Override
    public List<AlumnoResponseDTO> listarAlumnos() {
        return alumnoRepository.findAll().stream().map(alumno -> {
            AlumnoResponseDTO dto = new AlumnoResponseDTO();
            dto.setId(alumno.getId());
            dto.setNombreCompleto(alumno.getNombre() + " " + alumno.getApellidoPaterno() + " " + alumno.getApellidoMaterno());
            dto.setMateria(alumno.getMateria().getNombre());
            return dto;

        }).collect(Collectors.toList());
    }
}