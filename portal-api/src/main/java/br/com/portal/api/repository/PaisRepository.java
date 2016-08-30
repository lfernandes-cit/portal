package br.com.portal.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.portal.api.entidades.Pais;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Long> {


}
