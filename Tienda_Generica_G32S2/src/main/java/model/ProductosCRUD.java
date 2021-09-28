package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.ConnectionDB;

public class ProductosCRUD {

	ConnectionDB cnnxn=new ConnectionDB();
	
	Connection cn=cnnxn.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	
	Productos prod;
	
	public boolean cargarproductos(String url) {
		boolean x=false;
		try {
			
			ps=cn.prepareStatement("load data infile '"+url+"' into table productos fields terminated by ',' lines terminated by '\r\n';");
			x=ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Error al cargar la información en la BD"+e);
		}
		return x;
	}
}
