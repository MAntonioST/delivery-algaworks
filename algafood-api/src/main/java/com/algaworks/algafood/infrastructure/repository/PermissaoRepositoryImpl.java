package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;


@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	@Override
	public Permissao salvar(Permissao entity) {
		return manager.merge(entity);
	}

	@Override
	public Permissao buscarPorId(Long id) {
		return manager.find(Permissao.class, id);
	}

	@Transactional
	@Override
	public void remover(Permissao entity) {
		entity = buscarPorId(entity.getId());
		manager.remove(entity);
		
	}

	@Override
	public List<Permissao> todas() {
	  return manager
		    .createQuery("from Permissao", Permissao.class)
		    .getResultList();
					
	}

}
