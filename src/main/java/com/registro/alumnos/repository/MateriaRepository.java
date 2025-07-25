package com.registro.alumnos.repository;

import com.registro.alumnos.entity.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface MateriaRepository extends JpaRepository<Materia, Long> {
    Optional<Materia> findByNombreIgnoreCase(String nombre);
}