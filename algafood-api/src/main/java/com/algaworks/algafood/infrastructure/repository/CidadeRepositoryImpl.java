package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
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
	public void remover(Long id) {
		Cidade entity = buscarPorId(id);
		if(entity== null) {
			  throw new EmptyResultDataAccessException(1);
			}
		manager.remove(entity);
		
	}

	@Override
	public List<Cidade> listar() {
	  return manager
		    .createQuery("from Cidade", Cidade.class)
		    .getResultList();
					
	}

}
