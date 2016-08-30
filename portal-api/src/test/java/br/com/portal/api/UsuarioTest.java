package br.com.portal.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.portal.api.config.JUnitConfig;
import br.com.portal.api.dto.UsuarioDTO;
import br.com.portal.api.exception.BusinessException;
import br.com.portal.api.service.EcService;
import br.com.portal.api.service.UsuarioService;

public class UsuarioTest extends JUnitConfig {

	private static final long USUARIO_EXISTENTE = 1l;
	private static final long EC_CADASTRADO = 1l;
	private static final long USUARIO_NAO_CADASTRADO = 999l;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	EcService ecService;

	@Test
	public void cadastrar() throws BusinessException {
		UsuarioDTO usuarioDTO = new UsuarioDTO("Luiz Gabriel", "login", "senha");
		usuarioDTO = usuarioService.salvar(usuarioDTO);

		Assert.assertNotNull(usuarioDTO.getId());
	}

	@Test
	public void listar() throws BusinessException {

		final List<UsuarioDTO> usuariosDTO = usuarioService.listar();

		Assert.assertNotNull(usuariosDTO);
	}

	@Test
	public void login() throws Exception {

		final UsuarioDTO usuarioDTO = usuarioService.login("login", "senha");

		Assert.assertNotNull(usuarioDTO);
	}

	@Test(expected = BusinessException.class)
	public void loginFalha() throws Exception {

		final UsuarioDTO usuarioDTO = usuarioService.login("login", "senhaErrada");

		Assert.assertNotNull(usuarioDTO);
	}

	@Test
	public void remover() throws BusinessException {
		ecService.remover(EC_CADASTRADO);
		usuarioService.remover(USUARIO_EXISTENTE);
	}

	@Test
	public void removerFalhaRelacionamento() throws BusinessException {
		usuarioService.remover(USUARIO_EXISTENTE);
	}

	@Test(expected = BusinessException.class)
	public void removerFalha() throws BusinessException {
		usuarioService.remover(USUARIO_NAO_CADASTRADO);
	}
}
