package br.com.portal.api.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate(value = true)
@Table(name = "EC")
public class Ec implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "TELEFONE")
	private String telefone;

	@Column(name = "ENDERECO")
	private String endereco;

	@Column(name = "NUMERO")
	private Integer numero;

	@Column(name = "CEP")
	private String cep;

	@Column(name = "CIDADE")
	private String cidade;

	@Column(name = "POS")
	private String pos;

	@ManyToOne
	@JoinColumn(name = "COD_USUARIO")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "COD_PAIS")
	private Pais pais;

	public Ec() {
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(final String telefone) {
		this.telefone = telefone;
	}

	public void setPais(final Pais pais) {
		this.pais = pais;
	}

	public Pais getPais() {
		return pais;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}