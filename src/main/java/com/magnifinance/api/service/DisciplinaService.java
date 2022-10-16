package com.magnifinance.api.service;

import com.magnifinance.api.dto.DisciplinaDTO;
import com.magnifinance.api.dto.filter.DisciplinaFilterDTO;
import com.magnifinance.api.model.Disciplina;
import com.magnifinance.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public Page<Disciplina> filtrar(DisciplinaFilterDTO disciplinaFilterDTO, Pageable pageable) {
        return disciplinaRepository.filtrar(disciplinaFilterDTO, pageable);
    }

    public List<DisciplinaDTO> listAll() {
        var disciplinas = disciplinaRepository.findAll();
        List<DisciplinaDTO> listDTO = new ArrayList<>();

        for(Disciplina disciplina : disciplinas) {
            var disciplinaDTO = new DisciplinaDTO();
            disciplinaDTO.setNome(disciplina.getNome());

            listDTO.add(disciplinaDTO);
        }

        return listDTO;
    }


    public Optional<Disciplina> findById(Long codigo) {
        return disciplinaRepository.findById(codigo);
    }

    @Transactional
    public DisciplinaDTO saveDisciplina(DisciplinaDTO disciplinaDTO) {
        var disciplina = new Disciplina();
        disciplina.setNome(disciplinaDTO.getNome());
        disciplina = disciplinaRepository.save(disciplina);

        var disciplinaDTO1 = new DisciplinaDTO();
        disciplinaDTO1.setCodigo(disciplina.getCodigo());
        disciplinaDTO1.setNome(disciplina.getNome());

        return disciplinaDTO1;
    }

}
