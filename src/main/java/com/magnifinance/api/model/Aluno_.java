package com.magnifinance.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Aluno.class)
public abstract class Aluno_ {

	public static volatile ListAttribute<Aluno, Curso> cursos;
	public static volatile SingularAttribute<Aluno, Long> codigo;
	public static volatile SingularAttribute<Aluno, String> matricula;
	public static volatile SingularAttribute<Aluno, String> nome;
	public static volatile SingularAttribute<Aluno, LocalDate> dataNascimento;
	public static volatile SingularAttribute<Aluno, BigDecimal> nota;

	public static final String CURSOS = "cursos";
	public static final String CODIGO = "codigo";
	public static final String MATRICULA = "matricula";
	public static final String NOME = "nome";
	public static final String DATA_NASCIMENTO = "dataNascimento";
	public static final String NOTA = "nota";

}

