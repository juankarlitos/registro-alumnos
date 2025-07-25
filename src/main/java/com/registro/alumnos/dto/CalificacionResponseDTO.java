package com.registro.alumnos.dto;

public class CalificacionResponseDTO {

    private Long id;
    private String nombreCompleto;
    private String materia;
    private Double nota;

    public CalificacionResponseDTO() {
    }
    public CalificacionResponseDTO(Long id,String nombreCompleto, String materia, Double nota) {
        this.nombreCompleto = nombreCompleto;
        this.materia = materia;
        this.nota = nota;
        this.id = id;
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
    public Double getNota() {
        return nota;
    }
    public void setNota(Double nota) {
        this.nota = nota;
    }
}