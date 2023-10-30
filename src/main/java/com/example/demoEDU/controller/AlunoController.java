package com.example.demoEDU.controller;

import com.example.demoEDU.model.Aluno;
import com.example.demoEDU.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiAluno")
public class AlunoController {


    @Autowired
    AlunoRepository alRepo;
    @GetMapping("/todos") // o seguinte para chamar apiAluno/todos
    public List<Aluno> buscarTodos()
    {
        return alRepo.findAll();

    }

    @GetMapping("/ra/{ra}")
    public Optional<Aluno> buscarPorRa(@PathVariable("ra") int ra)
    {
        return alRepo.findById(ra);
    }

    @GetMapping("/nome/{nome}") // o seguinte para chamar apiAluno/nome/edu
    public List<Aluno> buscarPorNome(@PathVariable("nome") String nome)
    {
        return alRepo.findByNome(nome);
    }

    @PostMapping("/Inserir")
    public void inserirAluno(@RequestBody Aluno al)
    {
        alRepo.save(al);
    }

    @DeleteMapping("/remover")
    public void removerAluno(@RequestBody Aluno al)
    {
        alRepo.delete(al);
    }

    @DeleteMapping("/remover/ra/{ra}")
    public void removerPorId (@PathVariable("ra") int ra)
    {
        alRepo.deleteById(ra);
    }

    @PutMapping("/atualizar")
    public void atualizarAluno(@RequestBody Aluno al)
    {
        alRepo.save(al);
    }

    @GetMapping("/todos/partenome/{partenome}")
    public List<Aluno> buscarPorParteNome (@PathVariable ("partenome") String parteNome)
    {
        return alRepo.findByParteNome(parteNome);
    }

    @GetMapping ("/todos/ramaior/{ra}")
    public List<Aluno> buscarPorRaMaior (@PathVariable("ra") int ra)
    {
        return alRepo.findByRaMaior(ra);
    }

    @GetMapping("/todos/nomera/{partenome}/{ra}")
    public List<Aluno> buscarPorNomeRa(@PathVariable("partenome") String parteNome ,@PathVariable("ra") int ra) // http://localhost:8080/apiAluno/todos/nomera/j/1
    {
        return alRepo.findByNomeRa(parteNome,ra);
    }


}
