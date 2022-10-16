package com.magnifinance.api.dto;

import com.magnifinance.api.model.Aluno;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlunoDTO {

    private Long codigo;
    private String nome;
    private BigDecimal nota;
    private LocalDate dataNascimento;
    private String matricula;

    public AlunoDTO() {
    }

    public AlunoDTO(Aluno aluno) {
        this.codigo = aluno.getCodigo();
        this.nome = aluno.getNome();
        this.nota = aluno.getNota();
        this.dataNascimento = aluno.getDataNascimento();
        this.matricula = aluno.getMatricula();
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

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
