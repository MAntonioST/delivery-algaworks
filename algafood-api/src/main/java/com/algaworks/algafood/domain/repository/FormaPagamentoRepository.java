package com.algaworks.algafood.domain.repository;

import java.util.List;
import com.algaworks.algafood.domain.model.FormaPagamento;


public interface  FormaPagamentoRepository {

	public FormaPagamento salvar(FormaPagamento entity); 
	public FormaPagamento buscarPorId(Long id);
	public void remover(FormaPagamento entity);
	public List<FormaPagamento> todas();
	
}
