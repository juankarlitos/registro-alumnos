package com.registro.alumnos;

import com.registro.alumnos.dto.CalificacionRequestDTO;
import com.registro.alumnos.dto.CalificacionResponseDTO;
import com.registro.alumnos.entity.Alumno;
import com.registro.alumnos.entity.Calificacion;
import com.registro.alumnos.entity.Materia;
import com.registro.alumnos.exception.RecursoNoEncontradoException;
import com.registro.alumnos.repository.AlumnoRepository;
import com.registro.alumnos.repository.CalificacionRepository;
import com.registro.alumnos.service.impl.CalificacionServiceImpl;
import com.registro.alumnos.service.interfaces.MateriaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalificacionServiceTest {

    @Mock
    private CalificacionRepository calificacionRepository;
    @Mock
    private AlumnoRepository alumnoRepository;
    @Mock
    private MateriaService materiaService;
    @InjectMocks
    private CalificacionServiceImpl calificacionService;

    @Test
    void registrarCalificacion_DeberiaGuardarYRetornarResponseDTO(){
        CalificacionRequestDTO dto = new CalificacionRequestDTO(1L, "Español", 6.8);

        Materia materia = new Materia(1L, "Español");
        Alumno alumno = new Alumno(1L, "Juan", "Perez", "Gomez", materia);

        when(alumnoRepository.findById(1L)).thenReturn(Optional.of(alumno));
        when(materiaService.obtenerOMatricularMateria("Español")).thenReturn(materia);

        Calificacion calificacion = new Calificacion(1L, alumno, materia, 6.8);
        when(calificacionRepository.save(any(Calificacion.class))).thenReturn(calificacion);

        CalificacionResponseDTO response = calificacionService.registrarCalificacion(dto);

        assertEquals("Juan Perez Gomez", response.getNombreCompleto());
        assertEquals("Español", response.getMateria());
        assertEquals(6.8, response.getNota());

    }
    @Test
    void registrarCalificacion_AlumnoNoExiste_DeberiaLanzarExcepcion(){
        CalificacionRequestDTO dto = new CalificacionRequestDTO(99L, "Quimica", 5.5);

        when(alumnoRepository.findById(99L)).thenReturn(Optional.empty());

        RecursoNoEncontradoException ex = assertThrows(
                RecursoNoEncontradoException.class,
                () -> calificacionService.registrarCalificacion(dto)
        );
        assertTrue(ex.getMessage().contains("Alumno no encontrado"));
    }
}