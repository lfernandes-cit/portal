package br.com.portal.api.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.portal.api.dto.EcDTO;
import br.com.portal.api.dto.RespostaPadraoDTO;
import br.com.portal.api.exception.BusinessException;
import br.com.portal.api.service.EcService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "/ec", description = "Operações sobre o EC do usuário")
@RequestMapping(value = "/ec")
public class EcWS {

	private static final String SUCESSO = "Sucesso";
	private static final String OK = "200";

	@Autowired
	EcService ecService;

	@ApiOperation(value = "Salvar", notes = "Salva ou atualiza um EC")
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody RespostaPadraoDTO salvar(
			@ApiParam(value = "Estabelecimento comercial", required = true, name = "ec") @RequestBody final EcDTO ecDTO) {

		final RespostaPadraoDTO resposta = new RespostaPadraoDTO();
		try {
			ecService.salvar(ecDTO);
			resposta.setMensagem(SUCESSO);
			resposta.setObject(ecDTO);
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

	@ApiOperation(value = "Atualizar", notes = "Salva ou atualiza um EC")
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody RespostaPadraoDTO atualizar(
			@ApiParam(value = "Estabelecimento comercial", required = true, name = "ec") @RequestBody final EcDTO ecDTO) {

		final RespostaPadraoDTO resposta = new RespostaPadraoDTO();
		try {
			ecService.atualizar(ecDTO);
			resposta.setMensagem(SUCESSO);
			resposta.setObject(ecDTO);
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

	@ApiOperation(value = "Remover", notes = "Remove um EC")
	@RequestMapping(method = RequestMethod.DELETE)
	public RespostaPadraoDTO remover(@ApiParam(value = "Id do Estabelecimento Comercial", required = true, name = "id") @RequestParam final Long id) {

		final RespostaPadraoDTO resposta = new RespostaPadraoDTO();
		try {
			ecService.remover(id);
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

	@ApiOperation(value = "Listar Por Usuário", notes = "Lista EC por usuário")
	@RequestMapping(value = "/usuario", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody RespostaPadraoDTO listarPorUsuario(
			@ApiParam(value = "Id do usuario", required = true, name = "idUsuario") @RequestParam final Long idUsuario) {

		final RespostaPadraoDTO resposta = new RespostaPadraoDTO();
		List<EcDTO> ec;
		try {
			ec = ecService.listarPorUsuario(idUsuario);
			resposta.setMensagem(SUCESSO);
			resposta.setObject(ec);
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

	@ApiOperation(value = "Buscar Ec")
	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody RespostaPadraoDTO buscar(@ApiParam(value = "Id do EC", required = true, name = "idEc") @RequestParam final Long idEc) {

		final RespostaPadraoDTO resposta = new RespostaPadraoDTO();
		EcDTO ec;
		try {
			ec = ecService.buscar(idEc);
			resposta.setMensagem(SUCESSO);
			resposta.setObject(ec);
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
