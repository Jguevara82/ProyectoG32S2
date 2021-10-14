package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import model.Clientes;
import model.ClientesCRUD;
import model.UsuarioCRUD;

/**
 * Servlet implementation class ServletCRUDClientes
 */
@WebServlet("/ServletCRUDClientes")
public class ServletCRUDClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCRUDClientes() {
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
		
		HttpSession lc=request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		
		Float cc;
		String dc,ec, nc, tc, bt;
		Boolean t;
		
		Clientes cli;
		Clientes cl;
		ClientesCRUD clc;
		
		ArrayList<Clientes> listCli;
		
		bt=request.getParameter("boton");

		if (request.getParameter("btndelete")!=null) {
			try {
				cc=Float.parseFloat(request.getParameter("cc"));
				
				cl=new Clientes(cc);
				
				clc=new ClientesCRUD();
				
				t=clc.eliminardatoscliente(cl);
				
				if(t) {
					
					JOptionPane.showMessageDialog(null, "El cliente fue eliminado");
					response.sendRedirect("clientes.jsp");
					
				}
				
				else {
					
					JOptionPane.showMessageDialog(null, "El cliente no fue encontrado");
					response.sendRedirect("clientes.jsp");
					
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Ingrese una c�dula v�lida, por favor");
				response.sendRedirect("clientes.jsp");
			}
		}
		
		if (request.getParameter("btnupdate")!=null) {
			try {
				cc=Float.parseFloat(request.getParameter("cc"));
				dc=request.getParameter("dc");
				ec=request.getParameter("ec");
				nc=request.getParameter("nc");
				tc=request.getParameter("tc");
				
				cl=new Clientes(cc,dc,ec,nc,tc);
				
				clc=new ClientesCRUD();
				
				t=clc.modificardatoscliente(cl);
				
				if(t) {
					
					JOptionPane.showMessageDialog(null, "El cliente fue actualizado");
					response.sendRedirect("clientes.jsp");
					
				}
				
				else {
					
					JOptionPane.showMessageDialog(null, "El cliente no fue encontrado");
					response.sendRedirect("clientes.jsp");
					
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Ingrese una c�dula v�lida, por favor");
				response.sendRedirect("clientes.jsp");
			}
		}
		
		if(!Objects.isNull(bt)){
			if (bt.equals("btnlist")) {
				
				Gson gs=new Gson();
				clc=new ClientesCRUD();
				listCli=new ArrayList<Clientes>(clc.listarclientes());
				lc.setAttribute("objCli", listCli);
				
				pw.println(gs.toJson(listCli));
			}
		}
//inicio de validacion para buscar el cliente usando json	
		Gson gs=new Gson();
		String buscarcli = request.getParameter("consultcli");
		String crearcli = request.getParameter("consultcli");
		if(Objects.isNull(buscarcli) || Objects.isNull(crearcli)) {
			 buscarcli = "";
			 crearcli = "";
		}

		if (buscarcli.equals("traercli")) {
			cc =  Float.valueOf(request.getParameter("cedulabuscar"));
			cl=new Clientes(cc);		
			clc=new ClientesCRUD();		
			cli=clc.buscardatoscliente(cl);
			if(Objects.isNull(cli)) {
				JOptionPane.showMessageDialog(null, "no se encuentra un usuario con ese numero de cedula");			
				pw.println(gs.toJson(false));	
			}else {
				pw.println(gs.toJson(cli));	
			}
		
		}
		//fin de validacion para buscar el cliente usando json	
		
		
		//inicio de validacion para crear el cliente usando json
		
		 if (crearcli.equals("crearcli")) {
			 cc =  Float.valueOf(request.getParameter("cedulacrear"));
			 dc = request.getParameter("direccioncrear");
			 ec = request.getParameter("emailcrear");
			 nc = request.getParameter("nombrecrear");
			 tc = request.getParameter("telcrear");
			 
			 cl = new Clientes(cc, dc, ec, nc, tc);
			 clc = new ClientesCRUD();	
			 cli=clc.buscardatoscliente(cl);
			 if(Objects.isNull(cli)) {
			 t = clc.insertardatoscliente(cl);
			 if(t) {
				 JOptionPane.showMessageDialog(null, "Cliente registrado satisfactoriamente");
					pw.println(gs.toJson(true));	
			 }else {
				 JOptionPane.showMessageDialog(null, "cliente no registrado, por favor comuniquese con soporte tecnico");
					pw.println(gs.toJson(true));	
			 }
			 }else {
				 JOptionPane.showMessageDialog(null, "El cliente con el numero de cedula ingresada ya esta registrado en el sistema");
			 }
		 }
		//fin de validacion para crear el cliente usando json
	}

}
