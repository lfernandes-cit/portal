package br.com.portal.api.service.impl;

import static br.com.portal.api.util.CheckUtil.isNull;
import static br.com.portal.api.util.CheckUtil.isNullOrEmpty;

import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.portal.api.adapter.DozerAdapter;
import br.com.portal.api.dto.UsuarioDTO;
import br.com.portal.api.entidades.Usuario;
import br.com.portal.api.exception.BusinessException;
import br.com.portal.api.repository.UsuarioRepository;
import br.com.portal.api.service.UsuarioService;
import br.com.portal.api.util.AESencrp;
import br.com.portal.api.util.BusinessExceptionMessages;
import br.com.portal.api.util.Entidades;

@Service
public class UsuarioServiceImpl extends DozerAdapter implements UsuarioService {

	@Autowired
	UsuarioRepository userRepo;

	public UsuarioServiceImpl() {
		super();
	}

	@Override
	@Transactional(rollbackFor = BusinessException.class)
	public UsuarioDTO salvar(final UsuarioDTO usuarioDTO) throws BusinessException {

		try {
			final Usuario usuario = (Usuario) converter(usuarioDTO, Usuario.class);
			usuario.setSenha(AESencrp.encrypt(usuario.getSenha()));
			userRepo.save(usuario);
			return (UsuarioDTO) converter(usuario, UsuarioDTO.class);
		} catch (final Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}

	@Override
	@Transactional(rollbackFor = BusinessException.class)
	public void remover(final Long id) throws BusinessException {
		try {
			userRepo.delete(id);
		} catch (final EmptyResultDataAccessException e) {
			BusinessExceptionMessages.entidadeNaoEncontrada(Entidades.USUARIO.getNome(), "Id", id.toString());
		} catch (final ConstraintViolationException e) {
			BusinessExceptionMessages.entidadeComRelacionamentos(Entidades.USUARIO.getNome(), "Id", id.toString());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioDTO> listar() throws BusinessException {
		final List<Usuario> usuarios = IteratorUtils.toList(userRepo.findAll().iterator());

		if (isNullOrEmpty(usuarios)) {
			BusinessExceptionMessages.usuarioNaoEncontrado();
		}

		final List<UsuarioDTO> usuariosDTO = converterLista(usuarios, UsuarioDTO.class);

		return usuariosDTO;
	}

	@Override
	public UsuarioDTO login(final String login, final String senha) throws Exception {

		final Usuario usuario = userRepo.findByLoginAndSenha(login, AESencrp.encrypt(senha));

		if (isNull(usuario)) {
			BusinessExceptionMessages.entidadeNaoEncontrada(Entidades.USUARIO.getNome(), "Login", login);
		}

		final UsuarioDTO usuarioDTO = (UsuarioDTO) converter(usuario, UsuarioDTO.class);

		return usuarioDTO;
	}


}
