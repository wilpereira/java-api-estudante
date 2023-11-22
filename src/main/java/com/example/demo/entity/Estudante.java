package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor 
@NoArgsConstructor  
@Builder
@Entity
public class Estudante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	private Long id;
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Livro> livros;
	
	@OneToMany(mappedBy = "estudante")
	@JsonIgnore
	private Set<AvaliacaoCurso> avaliacaCursos;
}
