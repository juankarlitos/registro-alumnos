package com.registro.alumnos.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "calificaciones")

public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Calificacion() {
    }
    public Calificacion(Long id, Alumno alumno, Materia materia, Double nota) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Alumno getAlumno() {
        return alumno;
    }
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    public Materia getMateria() {
        return materia;
    }
    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    public Double getNota() {
        return nota;
    }
    public void setNota(Double nota) {
        this.nota = nota;    }

    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;
    @ManyToOne
    @JoinColumn(name = "materia_id", nullable = false)
    private Materia materia;
    @Column(nullable = false)
    private Double nota;
}