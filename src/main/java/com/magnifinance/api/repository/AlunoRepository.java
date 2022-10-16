package com.magnifinance.api.repository;

import com.magnifinance.api.model.Aluno;
import com.magnifinance.api.repository.aluno.AlunoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>, AlunoRepositoryQuery {

}
