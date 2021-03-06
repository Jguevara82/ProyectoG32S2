package model;

import java.sql.*;

import controller.ConnectionDB;

public class UsuarioCRUD {
	
	ConnectionDB cnnxn=new ConnectionDB();
	
	Connection cn=cnnxn.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	
	Usuarios usu;
	
	public boolean insertardatosusuario(Usuarios us) {
		
		int x;
		Boolean dat=false;
		try {
			
			ps=cn.prepareStatement("INSERT INTO usuarios values(?,?,?,?,?)");
			ps.setFloat(1, us.getCedula_usuario());
			ps.setString(2, us.getEmail_usuario());
			ps.setString(3, us.getNombre_usuario());
			ps.setString(4, us.getPassword());
			ps.setString(5, us.getUsuario());
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
	
	public boolean eliminardatosusuario(Usuarios us) {
		
		int x;
		Boolean dat=false;
		try {
			
			ps=cn.prepareStatement("DELETE FROM usuarios WHERE cedula_usuario=?");
			ps.setFloat(1, us.getCedula_usuario());
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
	
	public boolean modificardatosusuario(Usuarios us) {
		
		int x;
		Boolean dat=false;
		try {
			
			ps=cn.prepareStatement("UPDATE usuarios SET email_usuario='"+us.getEmail_usuario()+"',"
											+ "nombre_usuario='"+us.getNombre_usuario()+"',"
											+ "password='"+us.getPassword()+"',"
											+ "usuario='"+us.getUsuario()+"'"
											+ "WHERE cedula_usuario='"+us.getCedula_usuario()+"'");
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
	
	public Usuarios buscardatosusuario(Usuarios us) {

		try {
			
			ps=cn.prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario=?");
			ps.setFloat(1, us.getCedula_usuario());
			rs=ps.executeQuery();
						
			while (rs.next()) {
				usu=new Usuarios(rs.getFloat(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return usu;
		
	}
	
public int buscarUsuLogin(Usuarios us) {
		
		int bandera = 0;
		try {
			
			ps=cn.prepareStatement("SELECT * FROM usuarios WHERE usuario=? and password=?");
			ps.setString(1, us.getUsuario());
			ps.setString(2, us.getPassword());
			rs=ps.executeQuery();
						
			while (rs.next()) {
				bandera = 1;
				usu=new Usuarios(rs.getFloat(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return bandera;
		
	}
}
