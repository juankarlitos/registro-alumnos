package com.registro.alumnos;

import com.registro.alumnos.dto.AlumnoRequestDTO;
import com.registro.alumnos.dto.AlumnoResponseDTO;
import com.registro.alumnos.entity.Alumno;
import com.registro.alumnos.entity.Materia;
import com.registro.alumnos.repository.AlumnoRepository;
import com.registro.alumnos.service.impl.AlumnoServiceImpl;
import com.registro.alumnos.service.impl.MateriaServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AlumnoServiceTest {

    @Mock
    private AlumnoRepository alumnoRepository;

    @Mock
    private MateriaServiceImpl materiaService;

    @InjectMocks
    private AlumnoServiceImpl alumnoService;

    public AlumnoServiceTest(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registrarAlumno_DeberiaGuardarYRetornarAlumnoResponseDTO(){
        AlumnoRequestDTO dto = new AlumnoRequestDTO("Pedro", "Soto", "López", "Español");

        Materia materia = new Materia(2L, "Español");
        when(materiaService.obtenerOMatricularMateria("Español")).thenReturn(materia);

        Alumno alumnoGuardado = new Alumno(1L, "Pedro", "Soto", "Lopez", materia);
        when(alumnoRepository.save(any(Alumno.class))).thenReturn(alumnoGuardado);

        AlumnoResponseDTO result = alumnoService.registrarAlumno(dto);

        assertEquals("Pedro Soto Lopez", result.getNombreCompleto());
        assertEquals("Español", result.getMateria());
    }
    @Test
    void listarAlumnos_DeberiaRetoRnarListaDeAlumnosResponseDTO(){
        Materia materia = new Materia(1L, "Matematicas");
        Alumno alumno = new Alumno(1L, "Lucia", "Muñoz", "Rios", materia);

        when(alumnoRepository.findAll()).thenReturn(List.of(alumno));

        List<AlumnoResponseDTO> result = alumnoService.listarAlumnos();

        assertEquals(1, result.size());
        assertEquals("Lucia Muñoz Rios", result.get(0).getNombreCompleto());
        assertEquals("Matematicas", result.get(0).getMateria());
    }
}