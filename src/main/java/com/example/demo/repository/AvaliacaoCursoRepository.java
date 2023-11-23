package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AvaliacaoCurso;
import com.example.demo.entity.AvaliacaoCursoKey;

@Repository
public interface AvaliacaoCursoRepository extends JpaRepository<AvaliacaoCurso, AvaliacaoCursoKey>{

}
