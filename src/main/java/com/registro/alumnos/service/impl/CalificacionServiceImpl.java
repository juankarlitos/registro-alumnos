package com.registro.alumnos.service.impl;

import com.registro.alumnos.dto.CalificacionRequestDTO;
import com.registro.alumnos.dto.CalificacionResponseDTO;
import com.registro.alumnos.entity.Alumno;
import com.registro.alumnos.entity.Calificacion;
import com.registro.alumnos.entity.Materia;
import com.registro.alumnos.exception.RecursoNoEncontradoException;
import com.registro.alumnos.repository.AlumnoRepository;
import com.registro.alumnos.repository.CalificacionRepository;
import com.registro.alumnos.service.interfaces.CalificacionService;
import com.registro.alumnos.service.interfaces.MateriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalificacionServiceImpl implements CalificacionService {

    private final CalificacionRepository calificacionRepository;
    private final AlumnoRepository alumnoRepository;
    private final MateriaService materiaService;

    public CalificacionServiceImpl(CalificacionRepository calificacionRepository, AlumnoRepository alumnoRepository, MateriaService materiaService) {
        this.calificacionRepository = calificacionRepository;
        this.alumnoRepository = alumnoRepository;
        this.materiaService = materiaService;
    }

    @Override
    public CalificacionResponseDTO registrarCalificacion(CalificacionRequestDTO dto) {

        Alumno alumno = alumnoRepository.findById(dto.getAlumnoId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Alumno no encontrado con ID" + dto.getAlumnoId()));

        Materia materia = materiaService.obtenerOMatricularMateria(dto.getMateria());

        Calificacion calificacion = calificacionRepository.findByAlumnoAndMateria(alumno, materia)
                .orElse(new Calificacion(null, alumno, materia, null));

        calificacion.setNota(dto.getNota());
        Calificacion guardada = calificacionRepository.save(calificacion);

        return toDTO(guardada);
    }

    @Override
    public CalificacionResponseDTO actualizarCalificacion(Long id, CalificacionRequestDTO dto) {
        Calificacion calificacion = calificacionRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Calificacion no encontrada con ID" +  id));

        Alumno alumno = alumnoRepository.findById(dto.getAlumnoId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Alumno no encontrado con ID" + dto.getAlumnoId()));

        Materia materia = materiaService.obtenerOMatricularMateria(dto.getMateria());

        calificacion.setAlumno(alumno);
        calificacion.setMateria(materia);
        calificacion.setNota(dto.getNota());

                return toDTO(calificacionRepository.save(calificacion));
    }

    @Override
    public void eliminarCalificacion(Long id) {
        calificacionRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontro la calificacion con ID" + id));
        calificacionRepository.deleteById(id);
    }

    @Override
    public List<CalificacionResponseDTO> listarCalificaciones() {
        return calificacionRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private CalificacionResponseDTO toDTO(Calificacion calificacion){

        CalificacionResponseDTO dto = new CalificacionResponseDTO();
        Alumno alum = calificacion.getAlumno();
        dto.setId(calificacion.getId());
        dto.setNombreCompleto(alum.getNombre() +  " " + alum.getApellidoPaterno() + " " + alum.getApellidoMaterno());
        dto.setMateria(calificacion.getMateria().getNombre());
        dto.setNota(calificacion.getNota());
        return dto;
    }
}