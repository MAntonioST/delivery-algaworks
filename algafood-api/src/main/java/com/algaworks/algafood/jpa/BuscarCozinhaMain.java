package com.algaworks.algafood.jpa;



import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

public class BuscarCozinhaMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext =
				new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository repository = applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha cozinha = repository.buscarPorId(2L);
		System.out.println("Cozinha :" + cozinha.getNome());
		
	}

	
}
