package com.example.demoEDU.repository;


import com.example.demoEDU.model.Aluno;
import com.example.demoEDU.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DisciplinaRepository extends JpaRepository<Disciplina,Integer> {
    List<Disciplina> findByNome (String nome);


    @Query("select a from Disciplina a where a.sigla == ?1")
    List<Disciplina> findByDisciplina (String sigla);

    @Query("select a from Disciplina a where a.codigo > ?1")
    List<Disciplina> findByCodigo (int codigo);

    @Query("select a from Disciplina a where a.sigla == ?1 and a.codigo > ?2 ")
    List<Aluno> findByNomeRa(String parteNome , int ra);
}
