package com.magnifinance.api.dto;

import com.magnifinance.api.model.Disciplina;

public class DisciplinaDTO {

    private Long codigo;
    private String nome;

    public DisciplinaDTO() {
    }

    public DisciplinaDTO(Disciplina disciplina) {
        this.codigo = disciplina.getCodigo();
        this.nome = disciplina.getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
}
