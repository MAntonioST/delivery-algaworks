package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;


@Component
public class CidadeRepositoryImpl implements CidadeRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	@Override
	public Cidade salvar(Cidade entity) {
		return manager.merge(entity);
	}

	@Override
	public Cidade buscarPorId(Long id) {
		return manager.find(Cidade.class, id);
	}

	@Transactional
	@Override
	public void remover(Cidade entity) {
		entity = buscarPorId(entity.getId());
		manager.remove(entity);
		
	}

	@Override
	public List<Cidade> todas() {
	  return manager
		    .createQuery("from Cidade", Cidade.class)
		    .getResultList();
					
	}

}
