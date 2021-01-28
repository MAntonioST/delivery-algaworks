package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Permissao;


public interface  PermissaoRepository {

	public Permissao salvar(Permissao entity); 
	public Permissao buscarPorId(Long id);
	public void remover(Permissao entity);
	public List<Permissao> todas();
	
}
