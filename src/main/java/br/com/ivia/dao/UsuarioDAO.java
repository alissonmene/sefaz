package br.com.ivia.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.ivia.model.Usuario;

@Stateless
public class UsuarioDAO implements IUsuarioDAO {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Override
	public void adicionar(Usuario usuario) {
		em.persist(usuario);
	}

	@Override
	public List<Usuario> todosUsuarios() {

		Query query = em.createNativeQuery("select * from usuario", Usuario.class);

		return query.getResultList();
	}

	@Override
	public Usuario consultarUsuarioById(Long id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public Usuario alterar(Usuario usuario) {
		return em.merge(usuario);
	}

	@Override
	public void remover(Usuario usuario) {

		em.remove(em.contains(usuario) ? usuario : em.merge(usuario));
	}

	@Override
	public Boolean isExisteEmail(String email) {
		Query query = em.createNativeQuery("select * from usuario u  where u.email = :email ");
		
		query.setParameter("email", email);
		
		 return query.getResultList().isEmpty() ? Boolean.FALSE : Boolean.TRUE;
	}

	@Override
	public Usuario login(String email, String senha) {
		
		Query query = em.createNativeQuery("select * from usuario u  where u.email = :email "
				+ "and u.senha = :senha ", Usuario.class);
		
		query.setParameter("email", email);
		query.setParameter("senha", senha);
		
		
		List<Usuario> listaUsuario = query.getResultList();
		return  listaUsuario != null && !listaUsuario.isEmpty() ?
				(Usuario) listaUsuario.get(0) : null; 
		
		
	}

}
