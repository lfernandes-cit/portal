package br.com.portal.api.service;

import java.util.List;

import br.com.portal.api.dto.PaisDTO;
import br.com.portal.api.exception.BusinessException;

public interface PaisService {

	public List<PaisDTO> listar() throws BusinessException;


}
