package com.magnifinance.api.repository;

import com.magnifinance.api.model.Professor;
import com.magnifinance.api.repository.professor.ProfessorRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> , ProfessorRepositoryQuery {

}
