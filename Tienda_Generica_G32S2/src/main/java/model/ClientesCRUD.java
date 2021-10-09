package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.ConnectionDB;

public class ClientesCRUD {

	ConnectionDB cnnxn=new ConnectionDB();
	
	Connection cn=cnnxn.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	
	Clientes cli;
	
	public boolean insertardatoscliente(Clientes cl) {
		
		int x;
		Boolean dat=false;
		try {
			
			ps=cn.prepareStatement("INSERT INTO clientes values(?,?,?,?,?)");
			ps.setFloat(1, cl.getCedula_cliente());
			ps.setString(2, cl.getDireccion_cliente());
			ps.setString(3, cl.getEmail_cliente());
			ps.setString(4, cl.getNombre_usuario());
			ps.setString(5, cl.getTelefono_cliente());
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
	
	public boolean eliminardatoscliente(Clientes cl) {
		
		int x;
		Boolean dat=false;
		try {
			
			ps=cn.prepareStatement("DELETE FROM clientes WHERE cedula_cliente=?");
			ps.setFloat(1, cl.getCedula_cliente());
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
	
	public boolean modificardatoscliente(Clientes cl) {
		
		int x;
		Boolean dat=false;
		try {
			
			ps=cn.prepareStatement("UPDATE clientes SET direccion_cliente='"+cl.getDireccion_cliente()+"',"
											+ "email_cliente='"+cl.getEmail_cliente()+"',"
											+ "nombre_cliente='"+cl.getNombre_usuario()+"',"
											+ "telefono_cliente='"+cl.getTelefono_cliente()+"'"
											+ "WHERE cedula_cliente='"+cl.getCedula_cliente()+"'");
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
	
	public Clientes buscardatoscliente(Clientes cl) {

		try {
			
			ps=cn.prepareStatement("SELECT * FROM clientes WHERE cedula_cliente=?");
			ps.setFloat(1, cl.getCedula_cliente());
			rs=ps.executeQuery();
						
			while (rs.next()) {
				cli=new Clientes(rs.getFloat(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return cli;
		
	}
	
public ArrayList<Clientes> listarclientes() {
		
		ArrayList<Clientes> listCli=new ArrayList<>();

		try {
			
			ps=cn.prepareStatement("SELECT * FROM clientes");
			rs=ps.executeQuery();
						
			while (rs.next()) {
				cli=new Clientes(rs.getFloat(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				listCli.add(cli);
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return listCli;
		
	}
	
}
