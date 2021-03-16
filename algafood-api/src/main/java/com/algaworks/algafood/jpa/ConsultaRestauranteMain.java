package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class ConsultaRestauranteMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext =
				new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository repository = applicationContext.getBean(RestauranteRepository.class);
		
		List<Restaurante> restaurantes = repository.listar();
		for(Restaurante restaurante : restaurantes) {
			System.out.println("Restaurante :" + restaurante.getNome() + " - " + "Cozinha :" + restaurante.getCozinha().getNome());
		}
	}

	
}
