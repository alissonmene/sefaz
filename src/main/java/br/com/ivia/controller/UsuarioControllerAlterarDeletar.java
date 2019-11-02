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
import br.com.ivia.util.Parametros;

@WebServlet(name = "UsuarioAlteraDeletarr", urlPatterns = { "/usuario/usuarioalterardeletar" })
public class UsuarioControllerAlterarDeletar extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4460844731772559756L;

	@EJB
	private IUsuarioDAO usuarioDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String radio = req.getParameter("radio");
		String action = req.getParameter(Parametros.GET_PARAMETRO_ACTION.getValor());

		if (radio != null && !radio.isEmpty()) {

			Usuario usuario = usuarioDAO.consultarUsuarioById(Long.valueOf(radio));
			if (action.equals("REMOVER")) {
				usuarioDAO.remover(usuario);
				resp.sendRedirect("usuariolist");
			} else {
				req.setAttribute("usuario", usuario);
				req.getRequestDispatcher("/alterar.jsp").forward(req, resp);
				
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		String id = req.getParameter("id");

		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setId(Long.valueOf(id));
		usuario.setSenha(senha);
		usuario.setNome(nome);

		usuarioDAO.alterar(usuario);

		resp.sendRedirect("usuariolist");
	}

}
