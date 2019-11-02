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

@WebServlet(name = "LoginController", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7258482593367055966L;
	
	
	
	
	@EJB
	private IUsuarioDAO usuarioDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("login.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario =  usuarioDAO.login(email, senha);
		
		req.getSession().setAttribute("usuario", usuario);
		
		if (usuario != null) {
			
			resp.sendRedirect("./usuario/usuariolist");
		}else {
			
			
			req.setAttribute("email", email);
			req.setAttribute("senha", senha);
			req.setAttribute("msg", "usuário não encontrado");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
			
			
		
	}
	

}
