package dha.pkg.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbManager1 {
	static ConnectionManager cm = new ConnectionManager();
	private static Connection conn = cm.openConnection();
	
	public static void Insert(GetsSets2 set) throws ClassNotFoundException, SQLException{
		
		System.out.print(conn);
		
		String sql	=	"INSERT INTO presc (fname,lname,content) VALUES(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, set.getFname());
		pstmt.setString(2, set.getLname());
		pstmt.setString(3, set.getContent());
		
		pstmt.executeUpdate();
		
		System.out.println("Records Successfully Updated..");
		
	}
}
