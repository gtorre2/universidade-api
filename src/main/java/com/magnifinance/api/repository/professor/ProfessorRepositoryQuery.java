package com.magnifinance.api.repository.professor;

import com.magnifinance.api.dto.filter.ProfessorFilterDTO;
import com.magnifinance.api.repository.projection.ResumoProfessor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProfessorRepositoryQuery {

	Page<ResumoProfessor> filtrar(ProfessorFilterDTO ProfessorFilterDTO, Pageable pageable);

}
