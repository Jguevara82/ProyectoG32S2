package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.ConnectionDB;

public class ConsultaVentasXCliente {
	
	ConnectionDB cnnxn=new ConnectionDB();
	
	Connection cn=cnnxn.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	
	ArrayList<VentaCliente> listavc= new ArrayList<VentaCliente>();
		
	public ArrayList<VentaCliente> ConsultarVentas() {
		try {
			
			ps=cn.prepareStatement("SELECT clientes.cedula_cliente, clientes.nombre_cliente, ventas.total_venta "
					+ "FROM (clientes JOIN ventas ON clientes.cedula_cliente=ventas.cedula_cliente);");
			rs=ps.executeQuery();
			
			while (rs.next()) {
				listavc.add(new VentaCliente(rs.getFloat(1), rs.getString(2), rs.getDouble(3)));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Error al cargar la información en la BD"+e);
		}
		return listavc;
	}
}
