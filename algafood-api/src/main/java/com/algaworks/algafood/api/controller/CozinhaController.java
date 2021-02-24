package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.model.CozinhasXmlWrapper;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping(value ="/cozinhas") //produces = MediaType.APPLICATION_JSON_VALUE)
public class CozinhaController {

	@Autowired
	private CozinhaRepository repository;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cozinha> listar1(){
		return repository.listar();
	}
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhasXmlWrapper listarXml(){
		return new CozinhasXmlWrapper(repository.listar());
	}
	
	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscarPorId(@PathVariable Long cozinhaId) {
		Cozinha cozinha = repository.buscarPorId(cozinhaId);
		
		if(cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return repository.salvar(cozinha);
	}
	
	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId,
			@RequestBody Cozinha cozinha){
		Cozinha cozinhaAtual = repository.buscarPorId(cozinhaId);
		
		if(cozinhaAtual != null) {
			//cozinha.setNome(cozinha.getNome());
			BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
			repository.salvar(cozinhaAtual);
			return ResponseEntity.ok(cozinhaAtual);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId){
		
		try {
		Cozinha cozinha = repository.buscarPorId(cozinhaId);
		
		if(cozinha != null) {
			repository.remover(cozinha);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
		}catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build(); // se cozinha estiver ligada a um restaurante
		}
	}
}
