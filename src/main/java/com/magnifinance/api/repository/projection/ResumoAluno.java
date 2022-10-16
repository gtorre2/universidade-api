package com.magnifinance.api.repository.projection;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ResumoAluno implements Serializable {

    private Long codigo;
    private String nome;
    private BigDecimal nota;
    private LocalDate dataNascimento;
    private String matricula;

    public ResumoAluno(Long codigo, String nome, BigDecimal nota, LocalDate dataNascimento, String matricula) {
        this.codigo = codigo;
        this.nome = nome;
        this.nota = nota;
        this.dataNascimento = dataNascimento;
        this.matricula = matricula;
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
