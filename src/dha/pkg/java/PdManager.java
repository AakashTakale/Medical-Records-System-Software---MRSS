package dha.pkg.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

public class PdManager {
	static ConnectionManager cm = new ConnectionManager();
	private static Connection conn = cm.openConnection();
	
	public static void Insert(PGetsSets set) throws SQLException {
		// TODO Auto-generated method stub
			
			String sql	=	"INSERT INTO patientregister (fname,lname,SSN,DobMonth,DobDay,DobYear,Age,Gender,Address,City,State,Email,Password,Efname,Elname,Erelation,Econtact,AnyPhy,Phyname,height,weight,blood,CurrentMedic) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, set.getFname());
			pstmt.setString(2, set.getLname());
			pstmt.setString(3, set.getSsn());
			pstmt.setString(4, set.getDbmonth());
			pstmt.setString(5, set.getDbday());
			pstmt.setString(6, set.getDbyear());
			pstmt.setString(7, set.getAge());
			pstmt.setString(8, set.getGender());
			pstmt.setString(9, set.getAddress());
			pstmt.setString(10, set.getCity());
			pstmt.setString(11, set.getState());
			pstmt.setString(12, set.getEmail());
			pstmt.setString(13, set.getPassword());
			pstmt.setString(14, set.getEfname());
			pstmt.setString(15, set.getElname());
			pstmt.setString(16, set.getErelation());
			pstmt.setString(17, set.getEcontact());
			pstmt.setString(18, set.getAnyphy());
			pstmt.setString(19, set.getPname());
			pstmt.setString(20, set.getHeight());
			pstmt.setString(21, set.getWeight());
			pstmt.setString(22, set.getBlood());
			pstmt.setString(23, set.getMedic());
			
			pstmt.executeUpdate();
			
	}
	public static int checkUser(PGetsSets get) throws ClassNotFoundException, SQLException{
		
		System.out.print(conn);
		
		String sql	=	"SELECT COUNT(*) FROM patientregister WHERE Email=? AND Password=?";
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
