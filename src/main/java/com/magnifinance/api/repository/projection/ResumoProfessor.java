package com.magnifinance.api.repository.projection;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ResumoProfessor implements Serializable {

    private Long codigo;
    private String nome;
    private BigDecimal salario;
    private LocalDate dataNascimento;

    public ResumoProfessor(Long codigo, String nome, BigDecimal salario, LocalDate dataNascimento) {
        this.codigo = codigo;
        this.nome = nome;
        this.salario = salario;
        this.dataNascimento = dataNascimento;
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

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
