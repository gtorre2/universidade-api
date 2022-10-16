package com.magnifinance.api.repository.aluno;

import com.magnifinance.api.dto.filter.AlunoFilterDTO;
import com.magnifinance.api.repository.projection.ResumoAluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlunoRepositoryQuery {

	Page<ResumoAluno> filtrar(AlunoFilterDTO alunoFilterDTO, Pageable pageable);

}
