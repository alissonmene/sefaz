package br.com.ivia.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.ivia.model.Usuario;

@WebFilter({ "/usuario/*" })
public class AutenticacaoFiltro implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		
		if (usuario == null ) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);

		} else {
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			//dispatcher.forward(request, response);
			chain.doFilter(request, response);
		}
		

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
