package br.com.portal.api.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Pais", description = "Paises cadastrados no sistema")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PaisDTO implements Serializable {

	private static final long serialVersionUID = -112768916177795216L;

	@ApiModelProperty(name = "idPais")
	private Long id;

	private String nome;


	public PaisDTO() {
	}


	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}