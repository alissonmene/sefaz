package br.com.ivia.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LogoutController", urlPatterns = { "/logout" })
public class LogoutController extends HttpServlet {

	private static final long serialVersionUID = 7258482593367055966L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getSession().setAttribute("usuario", null);
		req.getRequestDispatcher("/login.jsp").forward(req, resp);

	}
	

}
