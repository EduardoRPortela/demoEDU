package com.example.demoEDU.controller;


import com.example.demoEDU.model.Aluno;
import com.example.demoEDU.model.Professor;
import com.example.demoEDU.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiProfessor")
public class ProfessorController {

    @Autowired
    ProfessorRepository proRepo;
    @GetMapping("/todosProf")
    public List<Professor> buscarTodos()
    {
        return proRepo.findAll();

    }

    @GetMapping("/Cod/{Cod}")
    public Optional<Professor> buscarPorCodigo(@PathVariable("Cod") int Cod)
    {
        return proRepo.findById(Cod);
    }

    @PostMapping("/Inserir")
    public void inserirProfessor(@RequestBody Professor prof)
    {
        proRepo.save(prof);
    }

    @DeleteMapping("/remover")
    public void removerProfessor(@RequestBody Professor prof)
    {
        proRepo.delete(prof);
    }

    @DeleteMapping("/remover/Cod/{Cod}")
    public void removerPorId (@PathVariable("Cod") int Cod)
    {
        proRepo.deleteById(Cod);
    }

    @PutMapping("/atualizar")
    public void atualizarAluno(@RequestBody Professor prof)
    {
        proRepo.save(prof);
    }

    @GetMapping("/todos/partenome/{partenome}")
    public List<Professor> buscarPorParteNome (@PathVariable ("partenome") String parteNome)
    {
        return proRepo.findByParteNome(parteNome);
    }

    @GetMapping ("/todos/salariomenor/{salario}")
    public List<Professor> buscarPorSalarioMenor (@PathVariable("salario") int salario)
    {
        return proRepo.findBysalarioMenor(salario);
    }


}
