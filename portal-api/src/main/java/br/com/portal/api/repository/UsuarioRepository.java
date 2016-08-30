package br.com.portal.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.portal.api.entidades.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	public Usuario findByLoginAndSenha(String login, String senha);

}
