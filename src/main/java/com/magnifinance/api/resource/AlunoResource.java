package com.magnifinance.api.resource;

import com.magnifinance.api.dto.AlunoDTO;
import com.magnifinance.api.dto.filter.AlunoFilterDTO;
import com.magnifinance.api.model.Aluno;
import com.magnifinance.api.model.Disciplina;
import com.magnifinance.api.repository.projection.ResumoAluno;
import com.magnifinance.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoResource {

	@Autowired
	private AlunoService alunoService;

	@GetMapping(params = "resumo")
	public Page<ResumoAluno> pesquisar(AlunoFilterDTO alunoFilterDTO, Pageable pageable) {
		return alunoService.filtrar(alunoFilterDTO, pageable);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Aluno> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Aluno> aluno = alunoService.findById(codigo);
		return aluno.isPresent() ? ResponseEntity.ok(aluno.get()) : ResponseEntity.notFound().build();
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AlunoDTO> saveAluno(
			@RequestBody @Valid AlunoDTO alunoDTO) {
		return ResponseEntity.ok().body(
				alunoService.saveAluno(alunoDTO));
	}
}
