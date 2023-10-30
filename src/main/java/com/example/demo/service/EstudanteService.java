package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Estudante;

public class EstudanteService {

	private static Map<Long, Estudante> listaEstudantes = new HashMap<>();
	
	private ResponseEntity<Estudante> buscarEstudante(Long id) {
		Estudante estudante = listaEstudantes.get(id);
		if(estudante == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(estudante);
	}
	
	private List<Estudante> buscarTodosEstudante() {
		return new ArrayList<>(listaEstudantes.values());
	}
	
	private ResponseEntity<Estudante> cadastrarEstudante(Estudante estudante) {
		Estudante estudanteEncontrado = listaEstudantes.get(estudante.getId());
		if(estudanteEncontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(estudanteEncontrado);
	}
	
	private ResponseEntity<Estudante> atualizarEstudante(Estudante estudante) {
		Estudante estudanteEncontrado = listaEstudantes.get(estudante.getId());
		if(estudanteEncontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		listaEstudantes.put(estudante.getId(), estudante);
		return ResponseEntity.status(HttpStatus.OK).body(estudanteEncontrado);
	}
	
	private ResponseEntity<String> deletarEstudante(Long id) {
		Estudante estudanteEncontrado = listaEstudantes.get(id);
		if(estudanteEncontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		listaEstudantes.remove(id);
		return ResponseEntity.status(HttpStatus.OK).body("Estudante deletado com sucesso!");
	}
}
