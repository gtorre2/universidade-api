package com.magnifinance.api.repository.curso;

import com.magnifinance.api.dto.filter.CursoFilterDTO;
import com.magnifinance.api.repository.projection.ResumoCurso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CursoRepositoryQuery {

	Page<ResumoCurso> filtrar(CursoFilterDTO cursoFilterDTO, Pageable pageable);

}
