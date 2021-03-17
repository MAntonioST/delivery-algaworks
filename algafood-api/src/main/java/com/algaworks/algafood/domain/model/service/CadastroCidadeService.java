package com.algaworks.algafood.domain.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.repository.CidadeRepository;


@Service
public class CadastroCidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;

	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.findById(estadoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de Estado com código %d", estadoId)));
		
		cidade.setEstado(estado);
		return cidadeRepository.save(cidade);
	}
	
	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}



	public Cidade buscarPorId(Long cidadeId) {
		return cidadeRepository.findById(cidadeId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						   String.format("Não existe um cadastro de Cidade com código %d", cidadeId)));
	}

	
	
	public void excluir(Long cidadeId) {

		try {
			cidadeRepository.deleteById(cidadeId);
			
		}catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
			   String.format("Não existe um cadastro de Cidade com código %d", cidadeId));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
		       String.format("Cidade de código %d não pode ser removida, pois está em uso", cidadeId));

		}
	}

}
