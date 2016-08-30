package br.com.portal.api.service;

import java.util.List;

import br.com.portal.api.dto.UsuarioDTO;
import br.com.portal.api.exception.BusinessException;

public interface UsuarioService {

	public UsuarioDTO salvar(UsuarioDTO usuario) throws BusinessException;

	public void remover(Long id) throws BusinessException;

	public List<UsuarioDTO> listar() throws BusinessException;

	public UsuarioDTO login(String login, String senha) throws BusinessException, Exception;

}
