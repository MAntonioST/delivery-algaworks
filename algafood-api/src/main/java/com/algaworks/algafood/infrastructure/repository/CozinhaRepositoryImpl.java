package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	@Override
	public Cozinha salvar(Cozinha entity) {
		return manager.merge(entity);
	}

	@Override
	public Cozinha buscarPorId(Long id) {
		return manager.find(Cozinha.class, id);
	}

	@Transactional
	@Override
	public void remover(Long id) {
		Cozinha cozinha = buscarPorId(id);
		
		if(cozinha== null) {
		  throw new EmptyResultDataAccessException(1);
		}
		manager.remove(cozinha);
	}

	@Override
	public List<Cozinha> listar() {
	  return manager
		    .createQuery("from Cozinha", Cozinha.class)
		    .getResultList();
					
	}

}
