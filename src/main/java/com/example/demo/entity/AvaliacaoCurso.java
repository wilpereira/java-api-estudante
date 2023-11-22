package com.example.demo.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoCurso {
	
	@EmbeddedId
	private AvaliacaoCursoKey id = new AvaliacaoCursoKey();
	
	@ManyToOne
	@MapsId("estudanteId")
	@JoinColumn(name = "estudante_id")
	Estudante estudante;
	
	@ManyToOne
	@MapsId("cursoId")
	@JoinColumn(name = "curso_id")
	Curso curso;
	
	int notaDaAvaliacao;
}
