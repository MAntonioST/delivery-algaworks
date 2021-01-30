package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;


@Component
public class EstadoRepositoryImpl implements EstadoRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	@Override
	public Estado salvar(Estado entity) {
		return manager.merge(entity);
	}

	@Override
	public Estado buscarPorId(Long id) {
		return manager.find(Estado.class, id);
	}

	@Transactional
	@Override
	public void remover(Estado entity) {
		entity = buscarPorId(entity.getId());
		manager.remove(entity);
		
	}

	@Override
	public List<Estado> listar() {
	  return manager
		    .createQuery("from Estado", Estado.class)
		    .getResultList();
					
	}

}
