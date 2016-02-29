package dha.pkg.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

public class NdManager {
	static ConnectionManager cm = new ConnectionManager();
	private static Connection conn = cm.openConnection();
	
	public static void Insert(NGetsSets set) throws SQLException{
		
		String sql	=	"INSERT INTO nurseregister (fname,lname,SSN,Gender,Email,Password) VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, set.getFname());
		pstmt.setString(2, set.getLname());
		pstmt.setString(3, set.getSsn());
		pstmt.setString(4, set.getGender());
		pstmt.setString(5, set.getEmail());
		pstmt.setString(6, set.getPassword());
		
		pstmt.executeUpdate();
	}
	
public static int checkUser(NGetsSets get) throws ClassNotFoundException, SQLException{
		
		System.out.print(conn);
		
		String sql	=	"SELECT COUNT(*) FROM nurseregister WHERE Email=? AND Password=?";
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
