package br.com.portal.api.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.portal.api.dto.PaisDTO;
import br.com.portal.api.dto.RespostaPadraoDTO;
import br.com.portal.api.exception.BusinessException;
import br.com.portal.api.service.PaisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "/pais")
@RequestMapping(value = "/pais")
public class PaisWS {

	private static final String SUCESSO = "Sucesso";
	private static final String OK = "200";

	@Autowired
	PaisService paisService;

	@ApiOperation(value = "Listar", notes = "Listar os países do sistema")
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody RespostaPadraoDTO listar() {

		final RespostaPadraoDTO resposta = new RespostaPadraoDTO();
		try {
			final List<PaisDTO> paisesDTO = paisService.listar();
			resposta.setMensagem(SUCESSO);
			resposta.setObject(paisesDTO);
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

}
