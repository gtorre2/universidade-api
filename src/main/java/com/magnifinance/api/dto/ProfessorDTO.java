package com.magnifinance.api.dto;

import com.magnifinance.api.model.Professor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ProfessorDTO {

    private Long codigo;
    private String nome;
    private BigDecimal salario;
    private LocalDate dataNascimento;
    private Boolean ativo;

    public ProfessorDTO(Professor professor) {
        this.codigo = professor.getCodigo();
        this.nome = professor.getNome();
        this.salario = professor.getSalario();
        this.dataNascimento = professor.getDataNascimento();
        this.ativo = professor.getAtivo();
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
