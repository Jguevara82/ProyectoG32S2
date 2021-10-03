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
				
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		
		Float cu;
		String eu,nu, p, u, bt;
		Boolean t;
		
		Usuarios usu;
		Usuarios us;
		UsuarioCRUD uc;
		
		ArrayList<Usuarios> listUsu;
		
		Gson gs=new Gson();

		bt=request.getParameter("boton");
		
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
				JOptionPane.showMessageDialog(null, "Ingrese una cédula válida, por favor");
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
				JOptionPane.showMessageDialog(null, "Ingrese una cédula válida, por favor");
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
				JOptionPane.showMessageDialog(null, "Ingrese una cédula válida, por favor");
				response.sendRedirect("usuarios.jsp");
			}	
		}
		
		//4
		if (bt.equals("btnsearch")) {
			
				cu=Float.parseFloat(request.getParameter("cu"));
				
				us=new Usuarios(cu);
				
				uc=new UsuarioCRUD();
				
				usu=uc.buscardatosusuario(us);

				pw.println(gs.toJson(usu));
				
				
		}
		
		//5

		if (bt.equals("btnlist")) {
			
			listUsu=new ArrayList<>();
			uc=new UsuarioCRUD();
			listUsu=uc.listarusuarios();

			pw.println(gs.toJson(listUsu));
			
		}
		
	}
}
