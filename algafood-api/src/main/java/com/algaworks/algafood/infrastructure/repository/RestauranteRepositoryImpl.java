package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	@Override
	public Restaurante salvar(Restaurante entity) {
		return manager.merge(entity);
	}

	@Override
	public Restaurante buscarPorId(Long id) {
		return manager.find(Restaurante.class, id);
	}

	@Transactional
	@Override
	public void remover(Restaurante entity) {
		entity = buscarPorId(entity.getId());
		manager.remove(entity);
		
	}

	@Override
	public List<Restaurante> todas() {
	  return manager
		    .createQuery("from Restaurante", Restaurante.class)
		    .getResultList();
					
	}

}
