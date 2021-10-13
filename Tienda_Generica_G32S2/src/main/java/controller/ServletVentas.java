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

import com.google.gson.Gson;

import model.DetalleVentas;
import model.DetalleVentasCRUD;
import model.UsuarioCRUD;
import model.Usuarios;
import model.Ventas;
import model.VentasCRUD;

/**
 * Servlet implementation class ServletVentas
 */
@WebServlet("/ServletVentas")
public class ServletVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVentas() {
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
		// TODO Auto-generated method stub
		HttpSession codV=request.getSession();
		HttpSession codDV=request.getSession();
		
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter pw=response.getWriter();
		
		Integer cv,    cdv, cp, cdp;
		Float cu, cc;
		Double iv, tv, vv,   ptv, pvv, piv;
		String bt;
		Boolean t, td;

		Ventas ve;
		Ventas ven;
		VentasCRUD vc;
		
		DetalleVentas dv;
		DetalleVentas dvn;
		DetalleVentasCRUD dvc;
		
		ArrayList<Ventas> listV=new ArrayList<>();
		
		Gson gs=new Gson();
		
		bt=request.getParameter("boton");
		
		if (bt.equals("btninsertv")) {
			
			try{
				
				cv=Integer.parseInt(request.getParameter("cv"));
				cu=Float.parseFloat(request.getParameter("cu"));
				cc=Float.parseFloat(request.getParameter("cc"));
				iv=Double.parseDouble(request.getParameter("iv"));
				tv=Double.parseDouble(request.getParameter("tv"));
				vv=Double.parseDouble(request.getParameter("vv"));
								
				ve=new Ventas(cv, cc, cu, iv, tv, vv);
				vc=new VentasCRUD();
				
				t=vc.insertarDatosVentas(ve);
				
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
		
		if (bt.equals("btninsertdv")) {
			
			try{
								
				cdv=Integer.parseInt(request.getParameter("cdv"));
				cp=Integer.parseInt(request.getParameter("cp"));
				cdp=Integer.parseInt(request.getParameter("cdp"));
				cv=Integer.parseInt(request.getParameter("cv"));
				ptv=Double.parseDouble(request.getParameter("ptv"));
				pvv=Double.parseDouble(request.getParameter("pvv"));
				piv=Double.parseDouble(request.getParameter("piv"));
				
				dv=new DetalleVentas(cdv, cp, cdp, cv, ptv, pvv, piv);
				dvc=new DetalleVentasCRUD();
				
				td=dvc.insertarDatosDetalleVentas(dv);
				
				if(td) {
					
					pw.println(gs.toJson(td));
					
				}
				
				else {
					
					pw.println(gs.toJson(td));
					
				}
			}catch(Exception e){
				
				pw.println(gs.toJson(null));
			}
		}
		
		if (bt.equals("conCodV")) {
			
			ve=new Ventas();
			vc=new VentasCRUD();
			ven=vc.buscarUltRegVentas(ve);
			
			codV.setAttribute("codVen", ven);
			
			pw.println(gs.toJson(ven));
			
		}
		
		if (bt.equals("conCodDV")) {
			
			dv=new DetalleVentas();
			dvc=new DetalleVentasCRUD();
			dvn=dvc.buscarUltRegDetalleVentas(dv);

			codDV.setAttribute("codDVen", dvn);
			
			pw.println(gs.toJson(dvn));
			
		}
		
		if(bt.equals("listVen")) {
			
			ve=new Ventas();
			vc=new VentasCRUD();
			listV=vc.listarVentas(ve);
			
			pw.println(gs.toJson(listV));
			
		}
	}

}
