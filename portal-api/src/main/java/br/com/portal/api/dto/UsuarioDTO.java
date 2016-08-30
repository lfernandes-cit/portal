package br.com.portal.api.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Usuario", description = "Usuário do sistema")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 2277152019564353965L;

	@ApiModelProperty(name = "idUsuario")
	private Long id;

	private String nome;

	private String login;

	private String senha;

	@ApiModelProperty(hidden = true)
	private List<EcDTO> ec;


	public UsuarioDTO() {
	}

	public UsuarioDTO(final long id) {
		this.id = id;
	}


	public UsuarioDTO(final String nome, final String login, final String senha) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(final String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(final String senha) {
		this.senha = senha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public List<EcDTO> getEc() {
		return ec;
	}


	public void setEc(final List<EcDTO> ec) {
		this.ec = ec;
	}

}