package dha.pkg.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.xml.ws.Response;

import com.mysql.jdbc.ResultSet;

public class DbManager {
	static ConnectionManager cm = new ConnectionManager();
	private static Connection conn = cm.openConnection();
	
	public static void Insert(GetsSets set) throws ClassNotFoundException, SQLException{
		
		System.out.print(conn);
		
		String sql	=	"INSERT INTO register (fname,lname,gender,state,city,email,password,age,address,specialization) VALUES(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, set.getFname());
		pstmt.setString(2, set.getLname());
		pstmt.setString(3, set.getGender());
		pstmt.setString(4, set.getState());
		pstmt.setString(5, set.getCity());
		pstmt.setString(6, set.getEmail());
		pstmt.setString(7, set.getPassword());
		pstmt.setString(8, set.getAge());
		pstmt.setString(9, set.getAddress());
		pstmt.setString(10, set.getSpec());
		
		pstmt.executeUpdate();
		
		System.out.println("Records Successfully Updated..");
		
	}
	public static int checkUser(GetsSets get) throws ClassNotFoundException, SQLException{
		
		System.out.print(conn);
		
		String sql	=	"SELECT COUNT(*) FROM register WHERE email=? AND password=?";
		PreparedStatement pstmt	=	conn.prepareStatement(sql);
		pstmt.setString(1, get.getEmail());
		pstmt.setString(2, get.getPassword());
		ResultSet rs	=	(ResultSet) pstmt.executeQuery();
		
		int count = 0;
		while(rs.next()){
			count	=	rs.getInt(1);
		}
		rs.close();
		pstmt.close();
		return count;
		
	}
	
}