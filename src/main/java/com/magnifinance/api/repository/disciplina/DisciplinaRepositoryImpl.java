package com.magnifinance.api.repository.disciplina;

import com.magnifinance.api.dto.filter.DisciplinaFilterDTO;
import com.magnifinance.api.model.Disciplina;
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

public class DisciplinaRepositoryImpl implements DisciplinaRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Disciplina> filtrar(DisciplinaFilterDTO disciplinaFilterDTO, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Disciplina> criteria = builder.createQuery(Disciplina.class);
		Root<Disciplina> root = criteria.from(Disciplina.class);

		Predicate[] predicates = criarRestricoes(disciplinaFilterDTO, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Disciplina> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(disciplinaFilterDTO));
	}

	private Predicate[] criarRestricoes(DisciplinaFilterDTO disciplinaFilterDTO, CriteriaBuilder builder,
			Root<Disciplina> root) {
		List<Predicate> predicates = new ArrayList<>();
		
//		if (!StringUtils.isEmpty(disciplinaFilterDTO.getNome())) {
//			predicates.add(builder.like(
//					builder.lower(root.get(Disciplina_.nome)), "%" + disciplinaFilterDTO.getNome().toLowerCase() + "%"));
//		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}
	
	private Long total(DisciplinaFilterDTO disciplinaFilterDTO) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Disciplina> root = criteria.from(Disciplina.class);
		
		Predicate[] predicates = criarRestricoes(disciplinaFilterDTO, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
	
}
