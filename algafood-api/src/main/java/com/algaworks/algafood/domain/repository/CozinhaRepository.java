package com.algaworks.algafood.domain.repository;

import java.util.List;


import com.algaworks.algafood.domain.model.Cozinha;

public interface  CozinhaRepository {

	public Cozinha salvar(Cozinha entity); 
	public Cozinha buscarPorId(Long id);
	public void remover(Cozinha entity);
	public List<Cozinha> listar();
	
}
