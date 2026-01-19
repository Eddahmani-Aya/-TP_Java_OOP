package dao;

import java.sql.*;

public class ConnectionDB {
	
	
	 private static final String URL = "jdbc:mysql://localhost:3306/SCOLARITE";
	 private static final String USER = "root";
	 private static final String PASSWORD = "";
	 private static Connection conn;
	 public static Connection getConnection() {
		 if(conn==null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection(URL,USER,PASSWORD);
				System.out.println("Connexion réussie !");
			}catch (Exception e) {
				e.printStackTrace();
			}
		 }
		return conn;
	 }
}