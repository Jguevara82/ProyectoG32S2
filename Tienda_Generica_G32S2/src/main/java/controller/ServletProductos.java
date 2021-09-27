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
		// TODO Auto-generated method stub
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
	}

}
