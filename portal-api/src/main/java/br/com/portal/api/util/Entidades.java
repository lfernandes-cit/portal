package br.com.portal.api.util;

public enum Entidades {

	// Sistema
	USUARIO                 ("Usuário"),
	EC("Estabelecimento Comercial");

	private String nome;

	private Entidades(final String nome) {
		setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

}
