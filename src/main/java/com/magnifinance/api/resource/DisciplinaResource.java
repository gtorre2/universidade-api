package com.magnifinance.api.resource;

import com.magnifinance.api.dto.DisciplinaDTO;
import com.magnifinance.api.dto.filter.DisciplinaFilterDTO;
import com.magnifinance.api.model.Disciplina;
import com.magnifinance.api.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaResource {
	
	@Autowired
	private DisciplinaService disciplinaService;

	@GetMapping(params = "resumo")
	public Page<Disciplina> pesquisar(DisciplinaFilterDTO disciplinaFilterDTO, Pageable pageable) {
		return disciplinaService.filtrar(disciplinaFilterDTO, pageable);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Disciplina> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Disciplina> disciplina = disciplinaService.findById(codigo);
		return disciplina.isPresent() ? ResponseEntity.ok(disciplina.get()) : ResponseEntity.notFound().build();
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DisciplinaDTO> saveDisciplina(
			@RequestBody @Valid DisciplinaDTO disciplinaDTO) {
		return ResponseEntity.ok().body(
				disciplinaService.saveDisciplina(disciplinaDTO));
	}

}
