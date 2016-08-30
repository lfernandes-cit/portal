package br.com.portal.api.util;

import br.com.portal.api.exception.BusinessException;

public class BusinessExceptionMessages {

	private static final String SEPARADOR = ": ";

	public static void entidadeNaoEncontrada(final String entidade, final String campo, final String valor) throws BusinessException {
		throw new  BusinessException (MessagesProperties.getMessage("mensagem.erro.elemento.nao.econtrado.92")
				.concat(campo + SEPARADOR + valor)
				.replace("{0}", entidade), "92");
	}

	public static void usuarioNaoEncontrado() throws BusinessException {
		throw new BusinessException(MessagesProperties.getMessage("mensagem.erro.elemento.nao.econtrado.92").replace("{0}", Entidades.USUARIO.getNome()), "92");
	}

	public static void ecNaoEncontrado(final String campo, final String valor) throws BusinessException {
		throw new BusinessException(MessagesProperties.getMessage("mensagem.erro.elemento.nao.econtrado.92").concat(campo + SEPARADOR + valor)
				.replace("{0}", Entidades.EC.getNome()), "92");

	}

	public static void ecNaoEncontrado() throws BusinessException {
		throw new BusinessException(
				MessagesProperties.getMessage("mensagem.erro.elemento.nao.econtrado.92").replace("{0}", Entidades.EC.getNome()), "92");
	}

	public static void elementoNaoEncontrado(final Entidades entidade) throws BusinessException {
		throw new  BusinessException (MessagesProperties.getMessage("mensagem.erro.elemento.nao.econtrado.92")
				.replace("{0}", entidade.getNome()), "92");
	}

	public static void entidadeComRelacionamentos(final String entidade, final String campo, final String valor) throws BusinessException {
		throw new BusinessException(
				MessagesProperties.getMessage("mensagem.erro.elemento.possui.relacionamentos.113").replace("{0}", entidade)
				.replace("{1}", campo).replace("{2}", valor),"113");

	}

}
