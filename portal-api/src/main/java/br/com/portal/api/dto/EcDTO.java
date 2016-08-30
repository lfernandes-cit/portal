package br.com.portal.api.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Estabelecimento Comercial", description = "Relação do estabelecimento comercial com o usuário")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EcDTO implements Serializable {

	private static final long serialVersionUID = -112768916177795216L;

	@ApiModelProperty(name = "idEc")
	private Long id;

	private String nome;

	private String telefone;

	private String endereco;

	private Integer numero;

	private String cep;

	private String cidade;

	private String pos;

	private UsuarioDTO usuario;

	private PaisDTO pais;

	public EcDTO() {
	}

	public EcDTO(final String nome, final UsuarioDTO usuario) {
		this.nome = nome;
		this.usuario = usuario;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(final String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(final Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(final String cidade) {
		this.cidade = cidade;
	}


	public String getPos() {
		return pos;
	}

	public void setPos(final String pos) {
		this.pos = pos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(final UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(final String telefone) {
		this.telefone = telefone;
	}

	public PaisDTO getPais() {
		return pais;
	}

	public void setPais(final PaisDTO pais) {
		this.pais = pais;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(final String cep) {
		this.cep = cep;
	}

}