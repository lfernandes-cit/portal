package br.com.portal.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.portal.api.config.JUnitConfig;
import br.com.portal.api.dto.EcDTO;
import br.com.portal.api.dto.UsuarioDTO;
import br.com.portal.api.exception.BusinessException;
import br.com.portal.api.service.EcService;


public class EcTest extends JUnitConfig {

	private static final long USUARIO_EXISTENTE = 1l;
	private static final long USUARIO_NAO_CADASTRADO = 999l;
	private static final long EC_NAO_CADASTRADO = 999l;
	private static final long EC_CADASTRADO = 1l;

	@Autowired
	EcService ecService;

	@Test
	public void cadastrar() throws BusinessException {
		final UsuarioDTO usuarioDTO = new UsuarioDTO(USUARIO_EXISTENTE);
		EcDTO historicoMedico = new EcDTO("Padaria do Zé", usuarioDTO);
		historicoMedico = ecService.salvar(historicoMedico);

		Assert.assertNotNull(historicoMedico.getId());
	}

	@Test
	public void listarPorUsuario() throws BusinessException {

		final List<EcDTO> ec = ecService.listarPorUsuario(USUARIO_EXISTENTE);

		Assert.assertNotNull(ec);
	}

	@Test(expected = BusinessException.class)
	public void listarPorUsuarioFalha() throws BusinessException {
		ecService.listarPorUsuario(USUARIO_NAO_CADASTRADO);
	}

	@Test
	public void remover() throws BusinessException {
		ecService.remover(EC_CADASTRADO);
	}

	@Test(expected = BusinessException.class)
	public void removerFalha() throws BusinessException {
		ecService.remover(EC_NAO_CADASTRADO);
	}
}
