package com.magnifinance.api.repository.projection;

import com.magnifinance.api.model.Professor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class ResumoCurso implements Serializable {

    private Long codigo;
    private String nome;
    private BigInteger semestre;
    private String professor;
    private String disciplina;
    private String aluno;

    public ResumoCurso(Long codigo, String nome, BigInteger semestre, String professor, String disciplina, String aluno) {
        this.codigo = codigo;
        this.nome = nome;
        this.semestre = semestre;
        this.professor = professor;
        this.disciplina = disciplina;
        this.aluno = aluno;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigInteger getSemestre() {
        return semestre;
    }

    public void setSemestre(BigInteger semestre) {
        this.semestre = semestre;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
