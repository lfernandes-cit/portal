package br.com.portal.api.service;

import java.util.List;

import br.com.portal.api.dto.EcDTO;
import br.com.portal.api.exception.BusinessException;

public interface EcService {

	public EcDTO salvar(EcDTO ecDTO) throws BusinessException;

	public void remover(Long id) throws BusinessException;

	List<EcDTO> listarPorUsuario(Long idUsuario) throws BusinessException;

	EcDTO atualizar(EcDTO ecDTO) throws BusinessException;

	public EcDTO buscar(Long idEc) throws BusinessException;

}
