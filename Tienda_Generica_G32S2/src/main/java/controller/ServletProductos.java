package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import model.Productos;
import model.ProductosCRUD;


/**
 * Servlet implementation class Prueba
 */
@WebServlet("/ServletProductos")
//@MultipartConfig
public class ServletProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProductos() {
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
		
		Float cp,ni;
		double iv,pc,pv;
		String np,bt;
		Boolean t;
		
		Productos pd;
		Productos prod;
		ProductosCRUD pcrud;
		
		//ArrayList<Usuarios> listPro;
		
		Gson gs=new Gson();
		
		bt=request.getParameter("boton");
		
		
		
		if (request.getParameter("cargar")!=null) {
			
			JOptionPane.showMessageDialog(null, "en el if de carga");
			
			Part archivocsv= request.getPart("archivo");
			String url="C:\\git\\ProyectoG32S2\\Tienda_Generica_G32S2\\src\\main\\webapp\\documents\\";
			String url2="C:\\\\git\\\\ProyectoG32S2\\\\Tienda_Generica_G32S2\\\\src\\\\main\\\\webapp\\\\documents\\\\";
			
			InputStream file= archivocsv.getInputStream();
			
			File copia= new File(url+"csv01.csv");
			FileOutputStream escribir= new FileOutputStream(copia);
			int num=file.read();
			while (num != -1) {
				escribir.write(num);
				num=file.read();
			}
			file.close();
			escribir.close();
			JOptionPane.showMessageDialog(null, "Se cargo el archivo");
			
			ProductosCRUD prodc=new ProductosCRUD();
			prodc.cargarproductos(url2+"csv01.csv");
			
			pw.println("Finalizado");
				
				
		}
		
		if(request.getParameter("btnupdate")!=null) {
			try {
				cp=Float.parseFloat(request.getParameter("cp"));
				iv=Double.parseDouble(request.getParameter("iv"));
				ni=Float.parseFloat(request.getParameter("ni"));
				np=request.getParameter("np");
				pc=Double.parseDouble(request.getParameter("pc"));
				pv=Double.parseDouble(request.getParameter("pv"));
				
				
				prod=new Productos(cp, iv, ni, np, pc, pv);
				
				pcrud=new ProductosCRUD();
				
				t=pcrud.modificardatosproducto(prod);
				
				if(t) {
					
					JOptionPane.showMessageDialog(null, "El producto fue actualizado");
				}
				
				else {
					
					JOptionPane.showMessageDialog(null, "El producto no fue encontrado");
				}
				response.sendRedirect("productos.jsp");
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Ingrese un código válida, por favor");
				response.sendRedirect("productos.jsp");
			}	
		}
		
		if (bt.equals("btnsearch")) {
			
			cp=Float.parseFloat(request.getParameter("cp"));
			prod=new Productos(cp);
			pcrud=new ProductosCRUD();
			pd=pcrud.buscardatosproducto(prod);
						
			pw.println(gs.toJson(pd));
			
		}
		
		if (bt.equals("btnlist")) {
			
			ArrayList<Productos> list=new ArrayList<Productos>();
			
			pcrud=new ProductosCRUD();
			list=pcrud.listarCodigoProducto();
						
			pw.println(gs.toJson(list));
			
		}
	}

}


