package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;


public class ConsultaFormaPagamentoMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext =
				new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaPagamentoRepository repository = applicationContext.getBean(FormaPagamentoRepository.class);
		
		List<FormaPagamento> FormaPagamentos = repository.todas();
		for(FormaPagamento FormaPagamento : FormaPagamentos) {
			System.out.println("FormaPagamento :" + FormaPagamento.getDescricao());
		}
	}

	
}
