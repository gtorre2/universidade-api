package com.magnifinance.api.model;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Curso.class)
public abstract class Curso_ {

	public static volatile ListAttribute<Curso, Disciplina> disciplinas;
	public static volatile SingularAttribute<Curso, Long> codigo;
	public static volatile SingularAttribute<Curso, Professor> professor;
	public static volatile ListAttribute<Curso, Aluno> alunos;
	public static volatile SingularAttribute<Curso, String> nome;
	public static volatile SingularAttribute<Curso, BigInteger> semestre;

	public static final String DISCIPLINAS = "disciplinas";
	public static final String CODIGO = "codigo";
	public static final String PROFESSOR = "professor";
	public static final String ALUNOS = "alunos";
	public static final String NOME = "nome";
	public static final String SEMESTRE = "semestre";

}

