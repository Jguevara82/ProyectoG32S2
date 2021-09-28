package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.ConnectionDB;

public class ProveedoresCRUD {

	ConnectionDB cnnxn=new ConnectionDB();
	
	Connection cn=cnnxn.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	
	Proveedores pro;
	
	public boolean insertardatosproveedor(Proveedores pr) {
		
		int x;
		Boolean dat=false;
		try {
			
			ps=cn.prepareStatement("INSERT INTO proveedores values(?,?,?,?,?)");
			ps.setFloat(1, pr.getNitproveedor());
			ps.setString(2, pr.getCiudad_proveedor());
			ps.setString(3, pr.getDireccion_proveedor());
			ps.setString(4, pr.getNombre_proveedor());
			ps.setString(5, pr.getTelefono_proveedor());
			x=ps.executeUpdate();
			if (x>0) {
				dat=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return dat;
		
	}
	
	public boolean eliminardatosproveedor(Proveedores pr) {
		
		int x;
		Boolean dat=false;
		try {
			
			ps=cn.prepareStatement("DELETE FROM proveedores WHERE nitproveedor=?");
			ps.setFloat(1, pr.getNitproveedor());
			x=ps.executeUpdate();
			if (x>0) {
				dat=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return dat;
		
	}
	
	public boolean modificardatosproveedor(Proveedores pr) {
		
		int x;
		Boolean dat=false;
		try {
			
			ps=cn.prepareStatement("UPDATE proveedores SET ciudad_proveedor='"+pr.getCiudad_proveedor()+"',"
											+ "direccion_proveedor='"+pr.getDireccion_proveedor()+"',"
											+ "nombre_proveedor='"+pr.getNombre_proveedor()+"',"
											+ "telefono_proveedor='"+pr.getTelefono_proveedor()+"'"
											+ "WHERE nitproveedor='"+pr.getNitproveedor()+"'");
			x=ps.executeUpdate();
			if (x>0) {
				dat=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return dat;
		
	}
	
	public Proveedores buscardatosproveedor(Proveedores pr) {

		try {
			
			ps=cn.prepareStatement("SELECT * FROM proveedores WHERE nitproveedor=?");
			ps.setFloat(1, pr.getNitproveedor());
			rs=ps.executeQuery();
						
			while (rs.next()) {
				pro=new Proveedores(rs.getFloat(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return pro;
		
	}
}
