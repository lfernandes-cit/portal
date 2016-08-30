package br.com.portal.api.service.impl;

import static br.com.portal.api.util.CheckUtil.isNull;
import static br.com.portal.api.util.CheckUtil.isNullOrEmpty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.portal.api.adapter.DozerAdapter;
import br.com.portal.api.dto.EcDTO;
import br.com.portal.api.entidades.Ec;
import br.com.portal.api.exception.BusinessException;
import br.com.portal.api.repository.EcRepository;
import br.com.portal.api.service.EcService;
import br.com.portal.api.util.BusinessExceptionMessages;
import br.com.portal.api.util.Entidades;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true, noRollbackFor = Exception.class)
public class EcServiceImpl extends DozerAdapter implements EcService {

	@Autowired
	EcRepository ecRepo;

	public EcServiceImpl() {
		super();
	}

	@Override
	@Transactional
	public EcDTO salvar(final EcDTO ecDTO) throws BusinessException {

		try {
			final Ec ec = (Ec) converter(ecDTO, Ec.class);
			ecRepo.save(ec);
			return (EcDTO) converter(ec, EcDTO.class);
		} catch (final Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}


	@Override
	@Transactional
	public EcDTO atualizar(final EcDTO ecDTO) throws BusinessException {

		try {
			final Ec ec = (Ec) converter(ecDTO, Ec.class);
			ecRepo.save(ec);
			return (EcDTO) converter(ec, EcDTO.class);
		} catch (final Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}

	@Override
	@Transactional
	public void remover(final Long id) throws BusinessException {
		try {
			ecRepo.delete(id);
		} catch (final EmptyResultDataAccessException e) {
			BusinessExceptionMessages.entidadeNaoEncontrada(Entidades.EC.getNome(), "Id", id.toString());
		}

	}

	@Override
	public List<EcDTO> listarPorUsuario(final Long idUsuario) throws BusinessException {
		final List<Ec> ec = ecRepo.findByUsuarioId(idUsuario);

		if (isNullOrEmpty(ec)) {
			BusinessExceptionMessages.ecNaoEncontrado();
		}

		final List<EcDTO> ecDTO = converterLista(ec, EcDTO.class);


		return ecDTO;
	}

	@Override
	public EcDTO buscar(final Long idEc) throws BusinessException {
		final Ec ec = ecRepo.findOne(idEc);

		if (isNull(ec)) {
			BusinessExceptionMessages.ecNaoEncontrado();
		}

		final EcDTO ecDTO = (EcDTO) converter(ec, EcDTO.class);

		return ecDTO;
	}

}
