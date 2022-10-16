package com.magnifinance.api.service;

import com.magnifinance.api.dto.ProfessorDTO;
import com.magnifinance.api.dto.filter.ProfessorFilterDTO;
import com.magnifinance.api.model.Professor;
import com.magnifinance.api.repository.ProfessorRepository;
import com.magnifinance.api.repository.projection.ResumoProfessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Page<ResumoProfessor> filtrar(ProfessorFilterDTO professorFilterDTO, Pageable pageable) {
        return professorRepository.filtrar(professorFilterDTO, pageable);
    }

    public Optional<Professor> findById(Long codigo) {
        return professorRepository.findById(codigo);
    }

    public List<Professor> listAll() {
       return professorRepository.findAll();
    }

    @Transactional
    public ProfessorDTO saveProfessor(ProfessorDTO professorDTO) {
        var professor = new Professor();
        professor.setNome(professorDTO.getNome());
        professor.setAtivo(true);
        professor.setDataNascimento(professorDTO.getDataNascimento());
        professor.setSalario(professorDTO.getSalario());
        professor = professorRepository.save(professor);

        var professorDTO1 = new ProfessorDTO(professor);

        return professorDTO1;
    }

}
