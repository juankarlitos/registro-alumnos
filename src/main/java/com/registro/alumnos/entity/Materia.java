package com.registro.alumnos.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "materias")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Materia() {
    }
    public Materia(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Column(nullable = false, unique = true)
    private String nombre;
}