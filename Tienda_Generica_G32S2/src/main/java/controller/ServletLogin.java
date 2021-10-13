package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
		HttpSession cedUsu=request.getSession();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String usuario = request.getParameter("usu");
		String clave = request.getParameter("pass");
		String cedula_usuario;

		Usuarios us;
		Usuarios usu;
		UsuarioCRUD uc;
		
		if (request.getParameter("btningreso") != null) {
			try {
				us = new Usuarios(clave, usuario);
				uc = new UsuarioCRUD();
				usu = uc.buscarUsuLogin(us);
				cedula_usuario=String.format("%.0f", usu.getCedula_usuario());
				//cedula_usuario=Float.toString(usu.getCedula_usuario());
				
				cedUsu.setAttribute("cedUsu", cedula_usuario);
				cedUsu.setAttribute("objUsu", usu);
				
				if (usu.getCedula_usuario() != null) {
					JOptionPane.showMessageDialog(null, "usuario y clave correctos");
					response.sendRedirect("menu.html");
				}
			}
			catch(Exception e) {
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
