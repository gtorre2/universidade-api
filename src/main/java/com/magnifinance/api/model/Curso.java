package com.magnifinance.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "tb_curso")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Curso {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "in_codigo", nullable = false)
	private Long codigo;

	@Column(name = "ds_nome", nullable = false)
	private String nome;

	@Column(name = "in_semestre", nullable = false)
	private BigInteger semestre;

	@ManyToOne
	@JoinColumn(name = "codigo_professor", referencedColumnName = "in_codigo", nullable = false)
	private Professor professor;

	@ManyToMany
	@JoinTable(name = "tb_curso_aluno", joinColumns = {
			@JoinColumn(name = "codigo_curso", referencedColumnName = "in_codigo")}, inverseJoinColumns = {
			@JoinColumn(name = "codigo_aluno", referencedColumnName = "in_codigo")})
	private List<Aluno> alunos;

	@ManyToMany
	@JoinTable(name = "tb_curso_disciplina", joinColumns = {
			@JoinColumn(name = "codigo_curso", referencedColumnName = "in_codigo")}, inverseJoinColumns = {
			@JoinColumn(name = "codigo_disciplina", referencedColumnName = "in_codigo")})
	private List<Disciplina> disciplinas;

	@Transient
	private String nomeProfessor;

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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
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
		Curso other = (Curso) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
