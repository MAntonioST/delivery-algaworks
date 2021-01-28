package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	@Override
	public FormaPagamento salvar(FormaPagamento entity) {
		return manager.merge(entity);
	}

	@Override
	public FormaPagamento buscarPorId(Long id) {
		return manager.find(FormaPagamento.class, id);
	}

	@Transactional
	@Override
	public void remover(FormaPagamento entity) {
		entity = buscarPorId(entity.getId());
		manager.remove(entity);

	}

	@Override
	public List<FormaPagamento> todas() {
		return manager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();

	}

}
