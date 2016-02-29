package dha.pkg.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.ResultSet;

public class ConnectionManager {
	
			private static ConnectionManager instance = null;
			
			private final String USERNAME = "root";
			
			private final String PASSWORD = "";
			private final String CONN_STRING = "jdbc:mysql://localhost:3306/";
			
			private Connection conn = null;
			
			String dbName = "testdb";
			String driver = "com.mysql.jdbc.Driver";
			Statement stmt;
			ResultSet res;
			
			
			ConnectionManager(){
			}
			
			public static ConnectionManager getInstance(){
				if(instance == null){
					instance = new ConnectionManager();
				}
				return instance;
			}
			public Connection openConnection(){
				try {
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					conn = DriverManager.getConnection(CONN_STRING+dbName, USERNAME, PASSWORD);
				} catch (SQLException e) {
					System.out.print("error in getting con"+e.toString());
				
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return conn;
			}
			/*
			public Connection getConnection(){
					if(conn == null){
						if(openConnection()){
								System.out.println("Connection Opened");
								return conn;
						}else{
							return null;
						}
					}
					return conn;
			}
*/			public ResultSet getResult (String sql, Connection conn){
				this.conn=conn;
				try{
					System.out.print(sql);
					res = (ResultSet)conn.prepareStatement(sql).executeQuery();
				}catch(Exception e){
					e.printStackTrace();
				}
				return res;
			
			}
			public void close(){
				System.out.println("Closing Connection");
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = null;
			}
}