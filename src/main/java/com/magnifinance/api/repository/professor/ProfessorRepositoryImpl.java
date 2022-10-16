package com.magnifinance.api.repository.professor;

import com.magnifinance.api.dto.filter.ProfessorFilterDTO;
import com.magnifinance.api.model.Professor;
import com.magnifinance.api.model.Professor_;
import com.magnifinance.api.repository.projection.ResumoProfessor;
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

public class ProfessorRepositoryImpl implements ProfessorRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<ResumoProfessor> filtrar(ProfessorFilterDTO professorFilterDTO, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoProfessor> criteria = builder.createQuery(ResumoProfessor.class);
		Root<Professor> root = criteria.from(Professor.class);

		criteria.select(builder.construct(ResumoProfessor.class
				, root.get(Professor_.codigo), root.get(Professor_.nome),
				root.get(Professor_.salario)
				, root.get(Professor_.dataNascimento)));

		Predicate[] predicates = criarRestricoes(professorFilterDTO, builder, root);
		criteria.where(predicates);

		TypedQuery<ResumoProfessor> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(professorFilterDTO));
	}

	private Predicate[] criarRestricoes(ProfessorFilterDTO ProfessorFilterDTO, CriteriaBuilder builder,
			Root<Professor> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(ProfessorFilterDTO.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get(Professor_.nome)), "%" + ProfessorFilterDTO.getNome().toLowerCase() + "%"));
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
	
	private Long total(ProfessorFilterDTO ProfessorFilterDTO) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Professor> root = criteria.from(Professor.class);
		
		Predicate[] predicates = criarRestricoes(ProfessorFilterDTO, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
	
}
