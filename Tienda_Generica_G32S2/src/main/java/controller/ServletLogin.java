package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import model.UsuarioCRUD;
import model.Usuarios;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		String usuario = request.getParameter("usu");
		String clave = request.getParameter("pass");

		Usuarios us;
		int bandera;
		UsuarioCRUD uc;
		if (request.getParameter("btningreso") != null) {

			us = new Usuarios(clave, usuario);
			uc = new UsuarioCRUD();
			bandera = uc.buscarUsuLogin(us);

			if (bandera != 0) {
				JOptionPane.showMessageDialog(null, "usuario y clave correctos");
				response.sendRedirect("menu.html");
			} else {
				JOptionPane.showMessageDialog(null, "usuario y/o clave incorrectos");
				response.sendRedirect("login.html");
			}
	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
