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
		Usuarios us;
		UsuarioCRUD uc;
		
		if (request.getParameter("btninsert")!=null) {
			try{
				cu=Float.parseFloat(request.getParameter("cu"));
				eu=request.getParameter("eu");
				nu=request.getParameter("nu");
				p=request.getParameter("p");
				u=request.getParameter("u");
				
				us=new Usuarios(cu, eu, nu, p, u);
				
				uc=new UsuarioCRUD();
				
				t=uc.insertardatosusuario(us);
				
				if(t) {
					
					JOptionPane.showMessageDialog(null, "El usuario fue registrado");
					
				}
				
				else {
					
					JOptionPane.showMessageDialog(null, "El usuario no fue registrado");
					
				}
				response.sendRedirect("usuarios.jsp");
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Ingrese una cédula válida, por favor");
				response.sendRedirect("usuarios.jsp");
			}
		}
		
		if (request.getParameter("btndelete")!=null) {
			try {
				cu=Float.parseFloat(request.getParameter("cu"));
				us=new Usuarios(cu);
				
				uc=new UsuarioCRUD();
				t=uc.eliminardatosusuario(us);
				
				if(t) {
					
					JOptionPane.showMessageDialog(null, "El usuario fue eliminado");
				}
				
				else {
					JOptionPane.showMessageDialog(null, "El usuario no fue encontrado");
				}
				response.sendRedirect("usuarios.jsp");
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Ingrese una cédula válida, por favor");
				response.sendRedirect("usuarios.jsp");
			}
		}
		
		if (request.getParameter("btnupdate")!=null) {
			try {
				cu=Float.parseFloat(request.getParameter("cu"));
				eu=request.getParameter("eu");
				nu=request.getParameter("nu");
				p=request.getParameter("p");
				u=request.getParameter("u");
				
				
				us=new Usuarios(cu, eu, nu, p, u);
				
				uc=new UsuarioCRUD();
				
				t=uc.modificardatosusuario(us);
				
				if(t) {
					
					JOptionPane.showMessageDialog(null, "El usuario fue actualizado");
				}
				
				else {
					
					JOptionPane.showMessageDialog(null, "El usuario no fue encontrado");
				}
				response.sendRedirect("usuarios.jsp");
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Ingrese una cédula válida, por favor");
				response.sendRedirect("usuarios.jsp");
			}
		}
		
		if (request.getParameter("btnsearch")!=null) {
			try {
				cu=Float.parseFloat(request.getParameter("cu"));
				
				us=new Usuarios(cu);
				
				uc=new UsuarioCRUD();
				
				usu=uc.buscardatosusuario(us);
				
				cu=usu.getCedula_usuario();
				eu=usu.getEmail_usuario();
				nu=usu.getNombre_usuario();
				p=usu.getPassword();
				u=usu.getUsuario();
				
				if(cu!=null) {
					
					JOptionPane.showMessageDialog(null, "El usuario fue encontrado");
					response.sendRedirect("tablausuarios.jsp?cu="+cu+"&&eu="+eu+"&&nu="+nu+"&&p="+p+"&&u="+u);
					
				}
				
				else {
					
					JOptionPane.showMessageDialog(null, "El usuario no fue encontrado");
					response.sendRedirect("usuarios.jsp");
					
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Ingrese una cédula válida, por favor");
				response.sendRedirect("usuarios.jsp");
			}
		}
	}
}
