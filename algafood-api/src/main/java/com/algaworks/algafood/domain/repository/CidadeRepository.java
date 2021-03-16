package com.algaworks.algafood.domain.repository;

import java.util.List;


import com.algaworks.algafood.domain.model.Cidade;

public interface  CidadeRepository {

	public Cidade salvar(Cidade entity); 
	public Cidade buscarPorId(Long id);
	public void remover(Long id);
	public List<Cidade> listar();
	
}
