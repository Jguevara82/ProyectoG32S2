package controller;

import java.io.IOException;
import java.util.Objects;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import model.Clientes;
import model.ClientesCRUD;

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
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		
		Float cc;
		String dc,ec, nc, tc;
		Boolean t;
		
		Clientes cli;
		Clientes cl;
		ClientesCRUD clc;
		
		if (request.getParameter("btninsert")!=null) {
			try {
				cc=Float.parseFloat(request.getParameter("cc"));
				dc=request.getParameter("dc");
				ec=request.getParameter("ec");
				nc=request.getParameter("nc");
				tc=request.getParameter("tc");
				
				cl=new Clientes(cc, dc, ec, nc, tc);
				
				clc=new ClientesCRUD();
				
				t=clc.insertardatoscliente(cl);
				
				if(t) {
					
					JOptionPane.showMessageDialog(null, "El cliente fue registrado");
					response.sendRedirect("clientes.jsp");
					
				}
				
				else {
					
					JOptionPane.showMessageDialog(null, "El cliente no fue registrado");
					response.sendRedirect("clientes.jsp");
					
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Ingrese una cédula válida, por favor");
				response.sendRedirect("clientes.jsp");
			}
		}
		
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
				JOptionPane.showMessageDialog(null, "Ingrese una cédula válida, por favor");
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
				JOptionPane.showMessageDialog(null, "Ingrese una cédula válida, por favor");
				response.sendRedirect("clientes.jsp");
			}
		}
		
		if (request.getParameter("btnsearch")!=null) {
			try {
				cc=Float.parseFloat(request.getParameter("cc"));
				
				cl=new Clientes(cc);
				
				clc=new ClientesCRUD();
				
				cli=clc.buscardatoscliente(cl);
				
				cc=cli.getCedula_cliente();
				dc=cli.getDireccion_cliente();
				ec=cli.getEmail_cliente();
				nc=cli.getNombre_usuario();
				tc=cli.getTelefono_cliente();
				
				if(cc!=null) {
					
					JOptionPane.showMessageDialog(null, "El cliente fue encontrado");
					response.sendRedirect("clientes.jsp?cc="+cc+"&&dc="+dc+"&&ec="+ec+"&&nc="+nc+"&&tc="+tc);
					
				}
				
				else {
					
					JOptionPane.showMessageDialog(null, "El cliente no fue encontrado");
					response.sendRedirect("clientes.jsp");
					
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Ingrese una cédula válida, por favor");
				response.sendRedirect("clientes.jsp");
			}
		}
		
		
		
//inicio de validacion para buscar el cliente usando json	
		Gson gs=new Gson();
		String buscarcli = request.getParameter("consultcli");

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
		String crearcli = request.getParameter("consultcli");
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
