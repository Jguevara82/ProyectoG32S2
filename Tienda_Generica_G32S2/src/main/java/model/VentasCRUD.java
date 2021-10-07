package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	
	public Ventas buscarDatosVenatas(Ventas ve) {
		
		try {
			ps = cn.prepareStatement("Select * from ventas where codigo_venta = ?");
			ps.setInt(1, ve.getCodigo_venta());
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
