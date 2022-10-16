package com.magnifinance.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Professor.class)
public abstract class Professor_ {

	public static volatile ListAttribute<Professor, Curso> cursos;
	public static volatile SingularAttribute<Professor, Long> codigo;
	public static volatile SingularAttribute<Professor, Boolean> ativo;
	public static volatile SingularAttribute<Professor, BigDecimal> salario;
	public static volatile SingularAttribute<Professor, String> nome;
	public static volatile SingularAttribute<Professor, LocalDate> dataNascimento;

	public static final String CURSOS = "cursos";
	public static final String CODIGO = "codigo";
	public static final String ATIVO = "ativo";
	public static final String SALARIO = "salario";
	public static final String NOME = "nome";
	public static final String DATA_NASCIMENTO = "dataNascimento";

}

