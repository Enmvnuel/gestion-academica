package com.cibertec.gestionacademica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_detalle_matricula")
public class DetalleMatricula {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;
    
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public DetalleMatricula() {
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Matricula getMatricula() { return matricula; }
    public void setMatricula(Matricula matricula) { this.matricula = matricula; }

    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }
}