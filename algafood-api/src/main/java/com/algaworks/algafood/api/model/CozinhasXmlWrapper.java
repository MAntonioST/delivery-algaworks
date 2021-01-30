package com.algaworks.algafood.api.model;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;
import lombok.NonNull;



@JacksonXmlRootElement(localName = "cozinhas")
@Data
public class CozinhasXmlWrapper {

	@JsonProperty("cozinha")
	@JacksonXmlElementWrapper(useWrapping = false)
	@NonNull //do lombok, para gerar um construtor obrigatório
	private List<Cozinha> cozinhas;
}