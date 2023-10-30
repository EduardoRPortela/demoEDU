package com.example.demoEDU.repository;

import com.example.demoEDU.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AlunoRepository extends JpaRepository<Aluno,Integer> {

    List<Aluno> findByNome (String nome);

    @Query("select a from Aluno a where a.nome like %?1%")
    List<Aluno> findByParteNome (String parteNome);

    @Query("select a from Aluno a where a.ra > ?1")
    List<Aluno> findByRaMaior (int ra);

    @Query("select a from Aluno a where a.nome like %?1% and a.ra > ?2 ")
    List<Aluno> findByNomeRa(String parteNome , int ra);

}
