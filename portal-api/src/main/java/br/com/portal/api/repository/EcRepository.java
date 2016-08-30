package br.com.portal.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.portal.api.entidades.Ec;

@Repository
public interface EcRepository extends CrudRepository<Ec, Long> {

	@Query("SELECT ec FROM Ec ec WHERE ec.usuario.id = :idUsuario ORDER BY ec.id")
	List<Ec> findByUsuarioId(@Param("idUsuario") Long idUsuario);

}
