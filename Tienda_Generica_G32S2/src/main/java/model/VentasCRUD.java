package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.ConnectionDB;

public class VentasCRUD {
	
	ConnectionDB cnnxn = new ConnectionDB();
	Connection cn = cnnxn.conexiondb();
	
	PreparedStatement ps;
	ResultSet rs;
	
	Ventas ven;
	
	public boolean insertarDatosVentas(Ventas ve) {
		
		int x;
		Boolean dat=false;
		
		try {
			ps = cn.prepareStatement("insert into ventas values(?,?,?,?,?,?)");
			
			ps.setInt(1, ve.getCodigo_venta());
			ps.setFloat(2,ve.getCedula_cliente());
			ps.setFloat(3, ve.getCedula_usuario());
			ps.setDouble(4, ve.getIvaventa());
			ps.setDouble(5, ve.getTotal_venta());
			ps.setDouble(6, ve.getValor_venta());
			
			x = ps.executeUpdate();
			if (x>0) {
				dat=true;
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return dat;
	}
	
	public ArrayList<Ventas> listarVentas(Ventas ve) {
		
		ArrayList<Ventas> listVen=new ArrayList<>();
		
		try {
			ps = cn.prepareStatement("SELECT * FROM `ventas` WHERE 1");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ven = new Ventas(rs.getInt(1), rs.getFloat(2), rs.getFloat(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
				listVen.add(ven);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listVen;
	}
	
	public Ventas buscarUltRegVentas(Ventas ve) {
		
		
		
		try {
			ps = cn.prepareStatement("select MAX(codigo_venta), cedula_cliente, cedula_usuario, ivaventa, total_venta, valor_venta As id FROM ventas");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ven = new Ventas(rs.getInt(1), rs.getFloat(2), rs.getFloat(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ven;
	}
}
