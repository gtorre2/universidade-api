package com.magnifinance.api.repository.disciplina;

import com.magnifinance.api.dto.filter.DisciplinaFilterDTO;
import com.magnifinance.api.model.Disciplina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DisciplinaRepositoryQuery {

	Page<Disciplina> filtrar(DisciplinaFilterDTO disciplinaFilterDTO, Pageable pageable);

}
