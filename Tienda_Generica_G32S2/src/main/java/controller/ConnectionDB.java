package controller;

import java.sql.*;

import javax.swing.JOptionPane;

public class ConnectionDB {
	
	Connection cnx;
	
	public Connection conexiondb() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				
				cnx=DriverManager.getConnection("jdbc:mysql://localhost/bd_G32_EQUIPO_2","root","");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,"Error de conexion BD"+e);
			}		
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,"Error de clase en la conexion BD"+e);
			
		
		}
		
		return cnx;
	}
}
