package com.magnifinance.api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;

public class CursoDTO {

    @NotNull
    private Long codigo;
    @NotEmpty
    private String nome;
    @NotNull
    private BigInteger semestre;
    @NotNull
    private ProfessorDTO professor;
    @NotNull
    private List<AlunoDTO> alunos;
    @NotNull
    private List<DisciplinaDTO> disciplinas;

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

    public ProfessorDTO getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorDTO professor) {
        this.professor = professor;
    }

    public List<AlunoDTO> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoDTO> alunos) {
        this.alunos = alunos;
    }

    public List<DisciplinaDTO> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<DisciplinaDTO> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
