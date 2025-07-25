package com.registro.alumnos.dto;
public class AlumnoResponseDTO {
    private Long id;
    private String nombreCompleto;
    private String materia;
    public AlumnoResponseDTO() {
    }
    public AlumnoResponseDTO(Long id, String nombreCompleto, String materia) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.materia = materia;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia) {
        this.materia = materia;
    }
}