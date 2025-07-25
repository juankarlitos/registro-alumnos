package com.registro.alumnos.repository;

import com.registro.alumnos.entity.Alumno;
import com.registro.alumnos.entity.Calificacion;
import com.registro.alumnos.entity.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {

    List<Calificacion> findByAlumno(Alumno alumno);
    Optional<Calificacion> findByAlumnoAndMateria(Alumno alumno, Materia materia);
}