package com.mep.school.services;

import com.mep.school.models.AlunoModel;
import com.mep.school.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public AlunoModel findById(Long id) {
        return alunoRepository.findById(id).get();
    }

    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    public AlunoModel update(Long id, AlunoModel alunoModel) {
        Optional<AlunoModel> alunoExistente = alunoRepository.findById(id);

        if (alunoExistente.isPresent()) {
            AlunoModel aluno = alunoExistente.get();
            aluno.setNome(alunoModel.getNome());
            aluno.setMatricula(alunoModel.getMatricula());
            aluno.setEndereco(alunoModel.getEndereco());
            aluno.setStatus(alunoModel.getStatus());
            return alunoRepository.save(aluno);
        } else {
            alunoModel.setId(id);
            return alunoRepository.save(alunoModel);
        }

    }
}
