package com.magnifinance.api.resource;

import com.magnifinance.api.dto.CursoDTO;
import com.magnifinance.api.dto.filter.CursoFilterDTO;
import com.magnifinance.api.model.Curso;
import com.magnifinance.api.repository.projection.ResumoCurso;
import com.magnifinance.api.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoResource {
	
	@Autowired
	private CursoService cursoService;

	@GetMapping(params = "resumo")
	public Page<ResumoCurso> pesquisar(CursoFilterDTO cursoFilterDTO, Pageable pageable) {
		return cursoService.filtrar(cursoFilterDTO, pageable);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Curso> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Curso> curso = cursoService.findById(codigo);
		return curso.isPresent() ? ResponseEntity.ok(curso.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Curso> saveCurso(
			@RequestBody Curso curso) {
		return ResponseEntity.ok().body(
				cursoService.saveCurso(curso));
	}

}
