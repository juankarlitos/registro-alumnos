package com.registro.alumnos.repository;

import com.registro.alumnos.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}