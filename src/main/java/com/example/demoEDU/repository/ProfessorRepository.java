package com.example.demoEDU.repository;

import com.example.demoEDU.model.Aluno;
import com.example.demoEDU.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor,Integer> {


    @Query("select a from Professor a where a.nome like %?1%")
    List<Professor> findByParteNome (String parteNome);

    @Query("select a from Professor a where a.salario < ?1")
    List<Professor> findBysalarioMenor (int salario);


}
