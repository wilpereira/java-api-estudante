package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Estudante;
import com.example.demo.repository.EstudanteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EstudanteService {

//	@TODO private static Map<Long, Estudante> listaEstudantes = new HashMap<>();
	
	private EstudanteRepository estudanteRepository; 
	
	public  ResponseEntity<Estudante> buscarEstudante(Long id) {
		if(estudanteRepository.existsById(id)) {
			return ResponseEntity.status(HttpStatus.OK).body(estudanteRepository.findById(id).get());	
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);		
	}
	
	public Page<Estudante> buscarTodosEstudante(PageRequest page) {
		return estudanteRepository.findAll(page);
	}
	
	public ResponseEntity<Estudante> cadastrarEstudante(Estudante estudante) {
		Estudante estudanteSalvo = estudanteRepository.save(estudante);
		return ResponseEntity.status(HttpStatus.OK).body(estudanteSalvo);
	}
	
	public ResponseEntity<Estudante> atualizarEstudante(Long id, Estudante estudante) {		
		if(estudanteRepository.existsById(id)) {
			Estudante estudanteSalvo = estudanteRepository.save(estudante);
			return ResponseEntity.status(HttpStatus.OK).body(estudanteSalvo);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	public ResponseEntity<String> removerEstudante(Long id) {
		if(estudanteRepository.existsById(id)) {
			estudanteRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Estudante deletado com sucesso!");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudande não encontrado");
	}
}
