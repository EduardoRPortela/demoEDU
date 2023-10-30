package com.example.demoEDU.controller;


import com.example.demoEDU.model.Aluno;
import com.example.demoEDU.model.Disciplina;
import com.example.demoEDU.repository.AlunoRepository;
import com.example.demoEDU.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiDisciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaRepository discRepo;
    @GetMapping("/todos") // o seguinte para chamar apiAluno/todos
    public List<Disciplina> buscarTodos()
    {
        return discRepo.findAll();

    }

    @GetMapping("/cod/{cod}")
    public Optional<Disciplina> buscarPorRa(@PathVariable("cod") int cod)
    {

        return discRepo.findById(cod);
    }

    @GetMapping("/nome/{nome}")
    public List<Disciplina> buscarPorNome(@PathVariable("nome") String nome)
    {

        return discRepo.findByNome(nome);
    }

    @GetMapping("/sigla/{sigla}")
    public List<Disciplina> buscarPorSigla(@PathVariable("sigla") String sigla)
    {

        return discRepo.findBySigla(sigla);
    }


    @PostMapping("/Inserir")
    public void inserirDisciplina(@RequestBody Disciplina disc)
    {
        discRepo.save(disc);
    }

    @DeleteMapping("/remover")
    public void removerDisciplina(@RequestBody Disciplina disc)
    {
        discRepo.delete(disc);
    }

    @DeleteMapping("/remover/cod/{cod}")
    public void removerPorId (@PathVariable("cod") int cod)
    {
        discRepo.deleteById(cod);
    }

    @PutMapping("/atualizar")
    public void atualizarDisciplina(@RequestBody Disciplina disc)
    {
        discRepo.save(disc);
    }

}
