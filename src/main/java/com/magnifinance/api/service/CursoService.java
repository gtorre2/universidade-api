package com.magnifinance.api.service;

import com.magnifinance.api.dto.AlunoDTO;
import com.magnifinance.api.dto.CursoDTO;
import com.magnifinance.api.dto.DisciplinaDTO;
import com.magnifinance.api.dto.ProfessorDTO;
import com.magnifinance.api.dto.filter.CursoFilterDTO;
import com.magnifinance.api.model.Aluno;
import com.magnifinance.api.model.Curso;
import com.magnifinance.api.model.Disciplina;
import com.magnifinance.api.model.Professor;
import com.magnifinance.api.repository.CursoRepository;
import com.magnifinance.api.repository.projection.ResumoCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Page<ResumoCurso> filtrar(CursoFilterDTO cursoFilterDTO, Pageable pageable) {
        return cursoRepository.filtrar(cursoFilterDTO, pageable);
    }

    public Optional<Curso> findById(Long codigo) {
        return cursoRepository.findById(codigo);
    }

    public List<CursoDTO> listAll() {
        var cursos = cursoRepository.findAll();
        List<CursoDTO> listDTO = new ArrayList<>();
        List<AlunoDTO> alunoDTOS = new ArrayList<>();
        List<DisciplinaDTO> disciplinaDTOS = new ArrayList<>();

        for(Curso curso : cursos) {
            var cursoDTO = new CursoDTO();
            var professorDTO = new ProfessorDTO(curso.getProfessor());

            for(Aluno aluno : curso.getAlunos()) {
                var alunoDTO = new AlunoDTO(aluno);
                alunoDTOS.add(alunoDTO);
            }

            for(Disciplina disciplina : curso.getDisciplinas()) {
                var disciplinaDTO = new DisciplinaDTO(disciplina);
                disciplinaDTOS.add(disciplinaDTO);
            }

            cursoDTO.setNome(curso.getNome());
            cursoDTO.setSemestre(curso.getSemestre());
            cursoDTO.setProfessor(professorDTO);
            cursoDTO.setAlunos(alunoDTOS);
            cursoDTO.setDisciplinas(disciplinaDTOS);

            listDTO.add(cursoDTO);
        }

        return listDTO;
    }

    @Transactional
    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

}
