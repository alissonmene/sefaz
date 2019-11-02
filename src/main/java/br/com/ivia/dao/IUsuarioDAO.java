package br.com.ivia.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.ivia.model.Usuario;

@Local
public interface IUsuarioDAO {

	void adicionar (Usuario usuario);
	List<Usuario> todosUsuarios ();
	Usuario consultarUsuarioById (Long id);
	Usuario alterar (Usuario usuario);
	void remover (Usuario usuario);
	Boolean isExisteEmail (String email);
	Usuario login (String email, String senha);
}
