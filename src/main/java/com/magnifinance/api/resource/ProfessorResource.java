package com.magnifinance.api.resource;

import com.magnifinance.api.dto.ProfessorDTO;
import com.magnifinance.api.dto.filter.ProfessorFilterDTO;
import com.magnifinance.api.model.Professor;
import com.magnifinance.api.repository.projection.ResumoProfessor;
import com.magnifinance.api.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professores")
public class ProfessorResource {
	
	@Autowired
	private ProfessorService professorService;

	@GetMapping(params = "resumo")
	public Page<ResumoProfessor> pesquisar(ProfessorFilterDTO professorFilterDTO, Pageable pageable) {
		return professorService.filtrar(professorFilterDTO, pageable);
	}

	@GetMapping
	public ResponseEntity<List<Professor>> findAll() {
		return ResponseEntity.ok(professorService.listAll());
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Professor> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Professor> professor = professorService.findById(codigo);
		return professor.isPresent() ? ResponseEntity.ok(professor.get()) : ResponseEntity.notFound().build();
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProfessorDTO> saveProfessor(
			@RequestBody @Valid ProfessorDTO professorDTO) {
		return ResponseEntity.ok().body(
				professorService.saveProfessor(professorDTO));
	}

}
