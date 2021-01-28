package com.algaworks.algafood.jpa;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class InclusaoRestauranteMain {

	
	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext =
				new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository repository = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("Fogão da Vovó");
		restaurante1.setTaxaFrete(BigDecimal.valueOf(18.00));
		
	
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("Mama Mia Massas");
		restaurante2.setTaxaFrete(BigDecimal.valueOf(12.00));		
		
		restaurante1 = repository.salvar(restaurante1);
		restaurante2 = repository.salvar(restaurante2);
		
		System.out.println(restaurante1.getId()+ " - " + restaurante1.getNome() + " - " + "taxa :" + restaurante1.getTaxaFrete());
		System.out.println(restaurante2.getId()+ " - " + restaurante2.getNome() + " - " + "taxa :" + restaurante2.getTaxaFrete());
	}

		
}
