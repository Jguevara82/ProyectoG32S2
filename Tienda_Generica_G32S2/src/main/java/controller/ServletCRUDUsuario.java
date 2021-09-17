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

@WebServlet("/ServletCRUDUsuario")
public class ServletCRUDUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCRUDUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Float cu;
		String eu,nu, p, u;
		Boolean t;
		
		
		Usuarios usu;
		
		if (request.getParameter("btninsert")!=null) {
			cu=Float.parseFloat(request.getParameter("cu"));
			eu=request.getParameter("eu");
			nu=request.getParameter("nu");
			p=request.getParameter("p");
			u=request.getParameter("u");
			
			Usuarios us=new Usuarios(cu, eu, nu, p, u);
			
			UsuarioCRUD uc=new UsuarioCRUD();
			
			t=uc.insertardatosusuario(us);
			
			if(t) {
				
				JOptionPane.showMessageDialog(null, "El usuario fue registrado");
				response.sendRedirect("usuarios.html");
				
			}
			
			else {
				
				JOptionPane.showMessageDialog(null, "El usuario no fue registrado");
				response.sendRedirect("usuarios.html");
				
			}
		}
		
		if (request.getParameter("btndelete")!=null) {
			cu=Float.parseFloat(request.getParameter("cu"));
			
			Usuarios us=new Usuarios(cu);
			
			UsuarioCRUD uc=new UsuarioCRUD();
			
			t=uc.eliminardatosusuario(us);
			
			if(t) {
				
				JOptionPane.showMessageDialog(null, "El usuario fue eliminado");
				response.sendRedirect("usuarios.html");
				
			}
			
			else {
				
				JOptionPane.showMessageDialog(null, "El usuario no fue encontrado");
				response.sendRedirect("usuarios.html");
				
			}
		}
		
		if (request.getParameter("btnupdate")!=null) {
			cu=Float.parseFloat(request.getParameter("cu"));
			
			Usuarios us=new Usuarios(cu);
			
			UsuarioCRUD uc=new UsuarioCRUD();
			
			t=uc.modificardatosusuario(us);
			
			if(t) {
				
				JOptionPane.showMessageDialog(null, "El usuario fue actualizado");
				response.sendRedirect("usuarios.html");
				
			}
			
			else {
				
				JOptionPane.showMessageDialog(null, "El usuario no fue encontrado");
				response.sendRedirect("usuarios.html");
				
			}
		}
		
		if (request.getParameter("btnsearch")!=null) {
			cu=Float.parseFloat(request.getParameter("cu"));
			
			Usuarios us=new Usuarios(cu);
			
			UsuarioCRUD uc=new UsuarioCRUD();
			
			usu=uc.buscardatosusuario(us);
			
			/*if(usu.equals()!=true) {
				
				JOptionPane.showMessageDialog(null, "El usuario fue encontrado");
				response.sendRedirect("busqueda.jsp");
				
			}
			
			else {
				
				JOptionPane.showMessageDialog(null, "El usuario no fue encontrado");
				response.sendRedirect("busqueda.jsp");
				
			}*/
		}

	}

}
