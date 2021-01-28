package com.algaworks.algafood.domain.repository;

import java.util.List;


import com.algaworks.algafood.domain.model.Restaurante;


public interface  RestauranteRepository {

	public Restaurante salvar(Restaurante entity); 
	public Restaurante buscarPorId(Long id);
	public void remover(Restaurante entity);
	public List<Restaurante> todas();
	
}
