package com.registro.alumnos.service.impl;

import com.registro.alumnos.entity.Materia;
import com.registro.alumnos.repository.MateriaRepository;
import com.registro.alumnos.service.interfaces.MateriaService;
import org.springframework.stereotype.Service;

@Service
public class MateriaServiceImpl implements MateriaService {

    private final MateriaRepository materiaRepository;

    public MateriaServiceImpl(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    @Override
    public Materia obtenerOMatricularMateria(String nombreMateria) {
        return materiaRepository.findByNombreIgnoreCase(nombreMateria)
                .orElseGet(() -> materiaRepository.save(new Materia(null, nombreMateria)));
    }
}