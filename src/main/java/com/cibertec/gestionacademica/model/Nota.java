package com.cibertec.gestionacademica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_nota")
public class Nota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(columnDefinition = "DECIMAL(4,2)")
    private Double calificacion;
    
    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;
    
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Nota() {
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Double getCalificacion() { return calificacion; }
    public void setCalificacion(Double calificacion) { this.calificacion = calificacion; }

    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }

    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }
}