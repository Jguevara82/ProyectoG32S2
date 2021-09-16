package controller;

import java.sql.*;

import javax.swing.JOptionPane;

public class ConnectionDB {
	
	Connection cnx;
	
	public Connection conexiondb() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				
				cnx=DriverManager.getConnection("jdbc:mysql://localhost/bd_tiendagenerica","root","");
				JOptionPane.showMessageDialog(null, "Connected");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		
		}
		
		return cnx;
	}
}
