package br.com.portal.api.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.portal.api.dto.RespostaPadraoDTO;
import br.com.portal.api.dto.UsuarioDTO;
import br.com.portal.api.exception.BusinessException;
import br.com.portal.api.service.UsuarioService;
import br.com.portal.api.util.Messages;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "/usuario", description = "Operações sobre o Usuário")
@RequestMapping(value = "/usuario")
public class UsuarioWS {

	private static final String SUCESSO = "Sucesso";
	private static final String OK = "200";

	@Autowired
	UsuarioService userService;

	@ApiOperation(value = "Salvar", notes = "Salva ou atualiza um usuário")
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody RespostaPadraoDTO salvar(
			@ApiParam(value = "Usuário do sistema", required = true, name = "usuario") @RequestBody final UsuarioDTO usuarioDTO) {

		final RespostaPadraoDTO resposta = new RespostaPadraoDTO();
		try {
			userService.salvar(usuarioDTO);
			resposta.setMensagem(SUCESSO);
			resposta.setObject(usuarioDTO);
			resposta.setCodigo(OK);
		} catch (final BusinessException e) {
			resposta.setMensagem(e.getMessage());
			resposta.setCodigo(e.getCodigo());
			return resposta;
		} catch (final Exception e) {
			resposta.setMensagem(e.getMessage());
			return resposta;
		}

		return resposta;

	}

	@ApiOperation(value = "Remover", notes = "Remove um usuário")
	@RequestMapping(method = RequestMethod.DELETE)
	public RespostaPadraoDTO remover(@ApiParam(value = "Id do usuario", required = true, name = "id") @RequestParam final Long id) {

		final RespostaPadraoDTO resposta = new RespostaPadraoDTO();
		try {
			userService.remover(id);
			resposta.setMensagem(SUCESSO);
			resposta.setCodigo(OK);
		} catch (final BusinessException e) {
			resposta.setMensagem(e.getMessage());
			resposta.setCodigo(e.getCodigo());
			return resposta;
		} catch (final Exception e) {
			resposta.setMensagem(e.getMessage());
			return resposta;
		}

		return resposta;

	}

	@ApiOperation(value = "Listar", notes = "Lista todos os usuários")
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody RespostaPadraoDTO listar() {

		final RespostaPadraoDTO resposta = new RespostaPadraoDTO();
		List<UsuarioDTO> usuarios;
		try {
			usuarios = userService.listar();
			resposta.setMensagem(SUCESSO);
			resposta.setObject(usuarios);
			resposta.setCodigo(OK);
			return resposta;
		} catch (final BusinessException e) {
			resposta.setMensagem(e.getMessage());
			resposta.setCodigo(e.getCodigo());
			return resposta;
		} catch (final Exception e) {
			resposta.setMensagem(e.getMessage());
			return resposta;
		}

	}


	@ApiOperation(value = "Login", notes = "Login do Usuário no sistema")
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody RespostaPadraoDTO login(@ApiParam(value = "usuario", required = true, name = "usuario") @RequestBody UsuarioDTO usuario) {

		final RespostaPadraoDTO resposta = new RespostaPadraoDTO();
		try {
			usuario = userService.login(usuario.getLogin(), usuario.getSenha());
			resposta.setObject(usuario);
			resposta.setMensagem(Messages.usuarioLogado());
			resposta.setCodigo(OK);
			return resposta;
		} catch (final BusinessException e) {
			resposta.setMensagem(e.getMessage());
			resposta.setCodigo(e.getCodigo());
			return resposta;
		} catch (final Exception e) {
			resposta.setMensagem(e.getMessage());
			return resposta;
		}

	}


}
