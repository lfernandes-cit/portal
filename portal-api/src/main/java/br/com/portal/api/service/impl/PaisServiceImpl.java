package br.com.portal.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.portal.api.adapter.DozerAdapter;
import br.com.portal.api.dto.PaisDTO;
import br.com.portal.api.entidades.Pais;
import br.com.portal.api.exception.BusinessException;
import br.com.portal.api.repository.PaisRepository;
import br.com.portal.api.service.PaisService;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true, noRollbackFor = Exception.class)
public class PaisServiceImpl extends DozerAdapter implements PaisService {

	@Autowired
	PaisRepository paisRepo;

	public PaisServiceImpl() {
		super();
	}


	@Override
	public List<PaisDTO> listar() throws BusinessException {
		final List<Pais> paises = (List<Pais>) paisRepo.findAll();

		final List<PaisDTO> paisesDTO = converterLista(paises, PaisDTO.class);

		return paisesDTO;
	}

}
