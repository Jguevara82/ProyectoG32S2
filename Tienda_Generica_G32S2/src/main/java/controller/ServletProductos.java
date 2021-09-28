package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import model.Productos;
import model.ProductosCRUD;


/**
 * Servlet implementation class Prueba
 */
@WebServlet("/ServletProductos")
@MultipartConfig
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
		
		int cp,ni;
		double iv,pc,pv;
		String np;
		Boolean t;
		
		Productos pd;
		Productos prod;
		ProductosCRUD pcrud;
		
		Part archivocsv= request.getPart("archivo");
		String url="C:\\git\\ProyectoG32S2\\Tienda_Generica_G32S2\\src\\main\\webapp\\documents\\";
		String url2="C:\\\\git\\\\ProyectoG32S2\\\\Tienda_Generica_G32S2\\\\src\\\\main\\\\webapp\\\\documents\\\\";
		
		if (request.getParameter("cargar")!=null) {
			try {
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
				boolean x;
				JOptionPane.showMessageDialog(null, "Se cargo el archivo");
				
				ProductosCRUD prodc=new ProductosCRUD();
				x=prodc.cargarproductos(url2+"csv01.csv");
				
				if(x) {
					JOptionPane.showMessageDialog(null, "Datos cargados en BD");
					response.sendRedirect("productos.jsp");
				}else {
					JOptionPane.showMessageDialog(null, "No se cargaron los datos");
				}
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Error al cargar el archivo"+e);
				response.sendRedirect("productos.jsp?men=Error al cargar el archivo");
			}
		}
		
		if(request.getParameter("btnupdate")!=null) {
			try {
				cp=Integer.parseInt(request.getParameter("cp"));
				iv=Double.parseDouble(request.getParameter("iv"));
				ni=Integer.parseInt(request.getParameter("ni"));
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
		
		if (request.getParameter("btnsearch")!=null) {
			try {
				cp=Integer.parseInt(request.getParameter("cp"));
				
				prod=new Productos(cp);
				
				pcrud=new ProductosCRUD();
				
				pd=pcrud.buscardatosproducto(prod);
				
				cp=pd.getCodigo_producto();
				iv=pd.getIvacompra();
				ni=pd.getNitproveedor();
				np=pd.getNombre_producto();
				pc=pd.getPrecio_compra();
				pv=pd.getPrecio_venta();
				
				if(cp!=0) {
					
					JOptionPane.showMessageDialog(null, "El producto fue encontrado");
					response.sendRedirect("productos.jsp?cp="+cp+"&&iv="+iv+"&&ni="+ni+"&&np="+np+"&&pc="+pc+"&&pv="+pv);
					
				}
				
				else {
					
					JOptionPane.showMessageDialog(null, "El producto no fue encontrado");
					response.sendRedirect("productos.jsp");
					
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Ingrese un código válido, por favor");
				response.sendRedirect("productos.jsp");
			}
		}
		}

	}


