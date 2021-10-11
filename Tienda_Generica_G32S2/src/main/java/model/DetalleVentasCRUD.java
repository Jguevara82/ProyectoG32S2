package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import controller.ConnectionDB;

public class DetalleVentasCRUD {
	
	ConnectionDB cnnxn = new ConnectionDB();
	Connection cn = cnnxn.conexiondb();
	
	PreparedStatement ps;
	ResultSet rs;
	
	DetalleVentas detVen;
	
	public boolean insertarDatosDetalleVentas(DetalleVentas dv) {
		
		int x;
		Boolean dat=false;
		
		try {
			ps = cn.prepareStatement("insert into detalle_ventas values(?,?,?,?,?,?,?)");
			ps.setInt(1, dv.getCodigo_detalle_venta());
			ps.setInt(2, dv.getCantidad_producto());
			ps.setInt(3, dv.getCodigo_producto());
			ps.setInt(4, dv.getCodigo_venta());
			ps.setDouble(5, dv.getValor_total());
			ps.setDouble(6, dv.getValor_venta());
			ps.setDouble(7, dv.getValoriva());
			
			x = ps.executeUpdate();
			
			if (x>0) {
				dat=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dat;
	}
	
	public DetalleVentas listarDetalleVentas (DetalleVentas dv) {
		
		
		try {
		ps = cn.prepareStatement("select * from detalle_ventas");
		rs = ps.executeQuery();
		
		while (rs.next()) {
			detVen = new DetalleVentas(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7));
		}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return detVen;
	}

	public DetalleVentas buscarUltRegDetalleVentas (DetalleVentas dv) {
		
		
		try {
		ps = cn.prepareStatement("select MAX(codigo_detalle_venta), cantidad_producto, codigo_producto, codigo_venta, valor_total, valor_venta, valoriva As id FROM detalle_ventas");
		rs = ps.executeQuery();
		
		while (rs.next()) {
			detVen = new DetalleVentas(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7));
		}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return detVen;
	}

}
