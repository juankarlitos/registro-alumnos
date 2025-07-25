package com.registro.alumnos.dto;

public class CalificacionRequestDTO {
    private Long alumnoId;
    private String materia;
    private Double nota;

    public CalificacionRequestDTO() {
    }
    public CalificacionRequestDTO(Long alumnoId, String materia, Double nota) {
        this.alumnoId = alumnoId;
        this.materia = materia;
        this.nota = nota;
    }
    public Long getAlumnoId() {
        return alumnoId;
    }
    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
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