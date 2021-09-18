package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import model.Proveedores;
import model.ProveedoresCRUD;


/**
 * Servlet implementation class ServletCRUDProveedores
 */
@WebServlet("/ServletCRUDProveedores")
public class ServletCRUDProveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCRUDProveedores() {
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
		
		Float nitp;
		String cp,dp, np, tp;
		Boolean t;
		
		Proveedores pro;
		Proveedores pr;
		ProveedoresCRUD prc;
		
		if (request.getParameter("btninsert")!=null) {
			
			nitp=Float.parseFloat(request.getParameter("nitp"));
			cp=request.getParameter("cp");
			dp=request.getParameter("dp");
			np=request.getParameter("np");
			tp=request.getParameter("tp");
			
			pr=new Proveedores(nitp, cp, dp, np, tp);
			
			prc=new ProveedoresCRUD();
			
			t=prc.insertardatosproveedor(pr);
			
			if(t) {
				
				JOptionPane.showMessageDialog(null, "El proveedor fue registrado");
				response.sendRedirect("proveedores.jsp");
				
			}
			
			else {
				
				JOptionPane.showMessageDialog(null, "El proveedor no fue registrado");
				response.sendRedirect("proveedores.jsp");
				
			}
		}
		
		if (request.getParameter("btndelete")!=null) {
			nitp=Float.parseFloat(request.getParameter("nitp"));
			
			pr=new Proveedores(nitp);
			
			prc=new ProveedoresCRUD();
			
			t=prc.eliminardatosproveedor(pr);
			
			if(t) {
				
				JOptionPane.showMessageDialog(null, "El proveedor fue eliminado");
				response.sendRedirect("proveedores.jsp");
				
			}
			
			else {
				
				JOptionPane.showMessageDialog(null, "El proveedor no fue encontrado");
				response.sendRedirect("proveedores.jsp");
				
			}
		}
		
		if (request.getParameter("btnupdate")!=null) {
			
			nitp=Float.parseFloat(request.getParameter("nitp"));
			cp=request.getParameter("cp");
			dp=request.getParameter("dp");
			np=request.getParameter("np");
			tp=request.getParameter("tp");
			
			pr=new Proveedores(nitp,cp,dp,np,tp);
			
			prc=new ProveedoresCRUD();
			
			t=prc.modificardatosproveedor(pr);
			
			if(t) {
				
				JOptionPane.showMessageDialog(null, "El proveedor fue actualizado");
				response.sendRedirect("proveedores.jsp");
				
			}
			
			else {
				
				JOptionPane.showMessageDialog(null, "El proveedor no fue encontrado");
				response.sendRedirect("proveedores.jsp");
				
			}
		}
		
		if (request.getParameter("btnsearch")!=null) {
			
			nitp=Float.parseFloat(request.getParameter("nitp"));
			
			pr=new Proveedores(nitp);
			
			prc=new ProveedoresCRUD();
			
			pro=prc.buscardatosproveedor(pr);
			
			nitp=pro.getNitproveedor();
			cp=pro.getCiudad_proveedor();
			dp=pro.getDireccion_proveedor();
			np=pro.getNombre_proveedor();
			tp=pro.getTelefono_proveedor();
			
			if(nitp!=null) {
				
				JOptionPane.showMessageDialog(null, "El provedor fue encontrado");
				response.sendRedirect("proveedores.jsp?nitp="+nitp+"&&cp="+cp+"&&dp="+dp+"&&np="+np+"&&tp="+tp);
				
			}
			
			else {
				
				JOptionPane.showMessageDialog(null, "El proveedor no fue encontrado");
				response.sendRedirect("proveedores.jsp");
				
			}
		}
	}

}
