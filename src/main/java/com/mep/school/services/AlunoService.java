package com.mep.school.services;

import com.mep.school.models.AlunoModel;
import com.mep.school.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoModel criarAluno(AlunoModel alunoModel) {
        return alunoRepository.save(alunoModel);
    }

    public List<AlunoModel> findAll() {
        return alunoRepository.findAll();
    }

    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }

}
