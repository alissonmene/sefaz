package br.com.ivia.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ivia.dao.IUsuarioDAO;
import br.com.ivia.util.Parametros;

@WebServlet(name = "UsuarioAjaxController", urlPatterns = { "/usuario/usuarioemailajax" })
public class UsuarioAjaxController extends HttpServlet {

	@EJB
	private IUsuarioDAO usuarioDAO;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1247177988385359152L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");

		if (email != null && !email.isEmpty()) {
			resp.setContentType(Parametros.CONTENT_TYPE_JSON.getValor());
			resp.setCharacterEncoding("UTF-8");
			PrintWriter out = resp.getWriter();
			Boolean isExisteEmail =  usuarioDAO.isExisteEmail(email);

			out.printf(Locale.US, "{ \"isExisteEmail\": %s}", isExisteEmail);
		}

	}

}
