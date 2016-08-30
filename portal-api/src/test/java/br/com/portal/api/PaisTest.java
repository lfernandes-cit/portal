package br.com.portal.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.portal.api.config.JUnitConfig;
import br.com.portal.api.dto.PaisDTO;
import br.com.portal.api.exception.BusinessException;
import br.com.portal.api.service.PaisService;

public class PaisTest extends JUnitConfig {

	@Autowired
	PaisService paisService;


	@Test
	public void listar() throws BusinessException {
		final List<PaisDTO> paisesDTO = paisService.listar();

		Assert.assertNotNull(paisesDTO);
		Assert.assertTrue(paisesDTO.size() > 0);
	}

}
