package com.mep.school.controllers;

import com.mep.school.models.AlunoModel;
import com.mep.school.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoModel> criarAluno(@RequestBody AlunoModel alunoModel) {
        AlunoModel request = alunoService.criarAluno(alunoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alunoModel.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<AlunoModel>> buscarTodosAlunos() {
        List<AlunoModel> request = alunoService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public AlunoModel buscarAluno(@PathVariable Long id) {
        return alunoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
    }

    @PutMapping("/{id}")
    public AlunoModel atualizarAluno(@PathVariable Long id, @RequestBody AlunoModel alunoModel) {
        return alunoService.update(id, alunoModel);
    }

}
