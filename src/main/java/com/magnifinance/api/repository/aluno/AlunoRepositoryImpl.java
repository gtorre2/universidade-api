package com.magnifinance.api.repository.aluno;

import com.magnifinance.api.dto.filter.AlunoFilterDTO;
import com.magnifinance.api.model.Aluno;
import com.magnifinance.api.model.Aluno_;
import com.magnifinance.api.repository.projection.ResumoAluno;
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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepositoryImpl implements AlunoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<ResumoAluno> filtrar(AlunoFilterDTO alunoFilterDTO, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoAluno> criteria = builder.createQuery(ResumoAluno.class);
		Root<Aluno> root = criteria.from(Aluno.class);

		criteria.select(builder.construct(ResumoAluno.class
				, root.get(Aluno_.codigo), root.get(Aluno_.nome)
				, root.get(Aluno_.nota), root.get(Aluno_.dataNascimento),
				root.get(Aluno_.matricula)));

		Predicate[] predicates = criarRestricoes(alunoFilterDTO, builder, root);
		criteria.where(predicates);

		TypedQuery<ResumoAluno> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(alunoFilterDTO));
	}

	private Predicate[] criarRestricoes(AlunoFilterDTO AlunoFilterDTO, CriteriaBuilder builder,
			Root<Aluno> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(AlunoFilterDTO.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get(Aluno_.nome)), "%" + AlunoFilterDTO.getNome().toLowerCase() + "%"));
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
	
	private Long total(AlunoFilterDTO AlunoFilterDTO) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Aluno> root = criteria.from(Aluno.class);
		
		Predicate[] predicates = criarRestricoes(AlunoFilterDTO, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
	
}
