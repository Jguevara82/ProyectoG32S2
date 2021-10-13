package controller;

import java.sql.*;

import javax.swing.JOptionPane;

public class ConnectionDB {
	
	Connection cnx;
	
	public Connection conexiondb() {
		
		try {
			
			Class.forName("org.mariadb.jdbc.Driver");
			
			try {
				
				cnx=DriverManager.getConnection("jdbc:mysql://tiendagenericagrupo43-10-32.czo3ixoe3xoe.us-east-1.rds.amazonaws.com/bd_G32_EQUIPO_2","admin","123456789");

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
