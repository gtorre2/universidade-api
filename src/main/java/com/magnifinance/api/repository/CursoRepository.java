package com.magnifinance.api.repository;

import com.magnifinance.api.model.Curso;
import com.magnifinance.api.repository.curso.CursoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>, CursoRepositoryQuery {

}
