package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

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
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		
		Float nitp;
		String cp,dp, np, tp, bt;
		Boolean t;
		
		Proveedores pro;
		Proveedores pr;
		ProveedoresCRUD prc;
		
		Gson gs=new Gson();
		
		bt=request.getParameter("boton");
		
		if (bt.equals("btninsert")) {
			try {
				nitp=Float.parseFloat(request.getParameter("nitp"));
				cp=request.getParameter("cp");
				dp=request.getParameter("dp");
				np=request.getParameter("np");
				tp=request.getParameter("tp");
				
				pr=new Proveedores(nitp, cp, dp, np, tp);
				prc=new ProveedoresCRUD();
				
				t=prc.insertardatosproveedor(pr);

				if(t) {
					
					pw.println(gs.toJson(t));
					
				}
				
				else {
					
					pw.println(gs.toJson(t));
					
				}
			}catch(Exception e){
				pw.println(gs.toJson(null));
			}
		}
		
		if (bt.equals("btndelete")) {
			try {
				nitp=Float.parseFloat(request.getParameter("nitp"));
				
				pr=new Proveedores(nitp);
				prc=new ProveedoresCRUD();
				
				t=prc.eliminardatosproveedor(pr);
				
				if(t) {
					
					pw.println(gs.toJson(t));
					
				}
				
				else {
					
					pw.println(gs.toJson(t));
					
				}
			}catch(Exception e){
				pw.println(gs.toJson(null));
			}
		}
		
		if (bt.equals("btnupdate")) {
			try {
				nitp=Float.parseFloat(request.getParameter("nitp"));
				cp=request.getParameter("cp");
				dp=request.getParameter("dp");
				np=request.getParameter("np");
				tp=request.getParameter("tp");
				
				pr=new Proveedores(nitp,cp,dp,np,tp);
				prc=new ProveedoresCRUD();
				
				t=prc.modificardatosproveedor(pr);
				
				JOptionPane.showMessageDialog(null, t);
				
				if(t) {
					
					pw.println(gs.toJson(t));
					
				}
				
				else {
					
					pw.println(gs.toJson(t));
					
				}
			}catch(Exception e){
				pw.println(gs.toJson(null));
			}
		}
		
		if (bt.equals("btnsearch")) {
			
			nitp=Float.parseFloat(request.getParameter("nitp"));
				
			pr=new Proveedores(nitp);
			prc=new ProveedoresCRUD();
			
			pro=prc.buscardatosproveedor(pr);
			
			pw.println(gs.toJson(pro));
				
		}
	}

}
