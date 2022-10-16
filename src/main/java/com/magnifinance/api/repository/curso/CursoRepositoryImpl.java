package com.magnifinance.api.repository.curso;

import com.magnifinance.api.dto.filter.CursoFilterDTO;
import com.magnifinance.api.model.Curso;
import com.magnifinance.api.model.Curso_;
import com.magnifinance.api.model.Professor_;
import com.magnifinance.api.repository.projection.ResumoCurso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CursoRepositoryImpl implements CursoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<ResumoCurso> filtrar(CursoFilterDTO cursoFilterDTO, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoCurso> criteria = builder.createQuery(ResumoCurso.class);
		Root<Curso> root = criteria.from(Curso.class);

		var professor = Curso_.professor;

		criteria.select(builder.construct(ResumoCurso.class
				, root.get(Curso_.codigo), root.get(Curso_.nome), root.get(Curso_.semestre)
				, root.get(Curso_.professor).get(Professor_.nome))
		);

		Predicate[] predicates = criarRestricoes(cursoFilterDTO, builder, root);
		criteria.where(predicates);

		TypedQuery<ResumoCurso> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(cursoFilterDTO));
	}

	private Predicate[] criarRestricoes(CursoFilterDTO cursoFilterDTO, CriteriaBuilder builder,
			Root<Curso> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(cursoFilterDTO.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get(Curso_.nome)), "%" + cursoFilterDTO.getNome().toLowerCase() + "%"));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}
	
	private Long total(CursoFilterDTO cursoFilterDTO) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Curso> root = criteria.from(Curso.class);
		
		Predicate[] predicates = criarRestricoes(cursoFilterDTO, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
	
}
