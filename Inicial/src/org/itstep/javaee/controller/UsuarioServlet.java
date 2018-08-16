package org.itstep.javaee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.itstep.javaee.dao.UsuarioDao;
import org.itstep.javaee.dao.exception.DaoException;
import org.itstep.javaee.dao.impl.UsuarioDaoImpl;
import org.itstep.javaee.modelo.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = (String) request.getParameter("name");
		String cpf = (String) request.getParameter("cpf");
		String email = (String) request.getParameter("email");
		String endereco = (String) request.getParameter("endereco");
		Usuario usuario = new Usuario();
		usuario.setName(name);
		usuario.setCpf(cpf);
		usuario.setEmail(email);
		usuario.setEndereco(endereco);
		HttpSession session = request.getSession();
		session.setAttribute("usuario", usuario);

		UsuarioDao usuarioDao = new UsuarioDaoImpl();

		try {
			Usuario bean = usuarioDao.create(usuario);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("response.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
