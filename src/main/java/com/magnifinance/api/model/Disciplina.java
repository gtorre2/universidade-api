package com.magnifinance.api.model;

import com.magnifinance.api.dto.DisciplinaDTO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_disciplina")
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "in_codigo")
	private Long codigo;

	@Column(name = "ds_nome", nullable = false)
	private String nome;

	@ManyToMany(mappedBy = "disciplinas", fetch = FetchType.EAGER)
	private List<Curso> cursos;

	public Disciplina() {
	}

	public Disciplina(DisciplinaDTO disciplinaDTO) {
		this.codigo = disciplinaDTO.getCodigo();
		this.nome = disciplinaDTO.getNome();
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
