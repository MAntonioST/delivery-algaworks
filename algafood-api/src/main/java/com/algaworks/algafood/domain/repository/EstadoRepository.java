package com.algaworks.algafood.domain.repository;

import java.util.List;


import com.algaworks.algafood.domain.model.Estado;

public interface  EstadoRepository {

	public Estado salvar(Estado entity); 
	public Estado buscarPorId(Long id);
	public void remover(Estado entity);
	public List<Estado> todos();
	
}
