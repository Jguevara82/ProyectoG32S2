package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

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
		
		Float cc;
		String dc,ec, nc, tc;
		Boolean t;
		
		Clientes cli;
		Clientes cl;
		ClientesCRUD clc;
		
		if (request.getParameter("btninsert")!=null) {
			
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
		}
		
		if (request.getParameter("btndelete")!=null) {
			
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
		}
		
		if (request.getParameter("btnupdate")!=null) {
			
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
		}
		
		if (request.getParameter("btnsearch")!=null) {
			
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
		}
		
	}

}
