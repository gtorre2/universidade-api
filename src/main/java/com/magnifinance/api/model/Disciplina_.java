package com.magnifinance.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Disciplina.class)
public abstract class Disciplina_ {

	public static volatile ListAttribute<Disciplina, Curso> cursos;
	public static volatile SingularAttribute<Disciplina, Long> codigo;
	public static volatile SingularAttribute<Disciplina, String> nome;

	public static final String CURSOS = "cursos";
	public static final String CODIGO = "codigo";
	public static final String NOME = "nome";

}

