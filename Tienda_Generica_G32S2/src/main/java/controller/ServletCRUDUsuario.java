package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.google.gson.Gson;

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
		HttpSession sesion=request.getSession();
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		
		Float cu;
		String eu,nu, p, u;
		Boolean t;
		
		Usuarios usu;
		Usuarios us;
		UsuarioCRUD uc;
		
		//1
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
				JOptionPane.showMessageDialog(null, "Ingrese una c�dula v�lida, por favor");
				response.sendRedirect("usuarios.jsp");
			}
		}
		
		//2
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
				JOptionPane.showMessageDialog(null, "Ingrese una c�dula v�lida, por favor");
				response.sendRedirect("usuarios.jsp");
			}
		}
		
		//3
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
				JOptionPane.showMessageDialog(null, "Ingrese una c�dula v�lida, por favor");
				response.sendRedirect("usuarios.jsp");
			}	
		}
		
		//4
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
				
				sesion.setAttribute("usu", u);
				
				if(cu!=null) {
					
					JOptionPane.showMessageDialog(null, "El usuario fue encontrado");
					response.sendRedirect("usuarios.jsp?cu="+cu+"&&eu="+eu+"&&nu="+nu+"&&p="+p+"&&u="+u);
					
				}
				
				else {
					
					JOptionPane.showMessageDialog(null, "El usuario no fue encontrado");
					response.sendRedirect("usuarios.jsp");
					
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Ingrese una c�dula v�lida, por favor");
				response.sendRedirect("usuarios.jsp");
			}
		}
		
		//5
		ArrayList<Usuarios> listUsu=new ArrayList<>();
		uc=new UsuarioCRUD();
		listUsu=uc.listarusuarios();
		Gson gs=new Gson();
		
		pw.println(gs.toJson(listUsu));
		
		/*if (request.getParameter("btnlist")!=null) {
			try {
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, ""+e);
			}
		}*/
		
	}
}
