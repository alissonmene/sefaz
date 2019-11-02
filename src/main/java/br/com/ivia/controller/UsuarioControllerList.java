package br.com.ivia.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ivia.dao.IUsuarioDAO;
import br.com.ivia.model.Usuario;

@WebServlet(name = "UsuarioList", urlPatterns = {"/usuario/usuariolist"})
public class UsuarioControllerList extends HttpServlet {

	@EJB
	private IUsuarioDAO usuarioDAO;

	private static final long serialVersionUID = -3170885960809986660L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("usuarios", usuarioDAO.todosUsuarios());
		req.getRequestDispatcher("/index.jsp").forward(req, resp);

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		Usuario usuario = new Usuario ();
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setEmail(email);
		usuarioDAO.adicionar(usuario);
		
		resp.sendRedirect("usuariolist");
	}

}
