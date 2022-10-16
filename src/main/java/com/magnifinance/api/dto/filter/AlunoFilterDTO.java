package com.magnifinance.api.dto.filter;

import javax.validation.constraints.NotEmpty;

public class AlunoFilterDTO {

    @NotEmpty
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
