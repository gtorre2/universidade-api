package com.magnifinance.api.service;

import com.magnifinance.api.dto.AlunoDTO;
import com.magnifinance.api.dto.filter.AlunoFilterDTO;
import com.magnifinance.api.model.Aluno;
import com.magnifinance.api.repository.AlunoRepository;
import com.magnifinance.api.repository.projection.ResumoAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Page<ResumoAluno> filtrar(AlunoFilterDTO alunoFilterDTO, Pageable pageable) {
        return alunoRepository.filtrar(alunoFilterDTO, pageable);
    }
    public Optional<Aluno> findById(Long codigo) {
        return alunoRepository.findById(codigo);
    }

    public List<AlunoDTO> listAll() {
        var alunos = alunoRepository.findAll();
        List<AlunoDTO> listDTO = new ArrayList<>();

        for(Aluno aluno : alunos) {
            var alunoDTO = new AlunoDTO(aluno);

            listDTO.add(alunoDTO);
        }

        return listDTO;
    }

    @Transactional
    public AlunoDTO saveAluno(AlunoDTO alunoDTO) {
        var aluno = new Aluno();
        aluno.setNome(alunoDTO.getNome());
        aluno.setNota(alunoDTO.getNota());
        aluno.setDataNascimento(alunoDTO.getDataNascimento());
        aluno.setMatricula(alunoDTO.getMatricula());

        aluno = alunoRepository.save(aluno);

        var alunoDTO1 = new AlunoDTO(aluno);

        return alunoDTO1;
    }

}
