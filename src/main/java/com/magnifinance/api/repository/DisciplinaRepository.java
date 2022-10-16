package com.magnifinance.api.repository;

import com.magnifinance.api.model.Disciplina;
import com.magnifinance.api.repository.disciplina.DisciplinaRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>, DisciplinaRepositoryQuery {

}
