package dha.pkg.java;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class UploadImageServlet
 */
public class UploadImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		String connectionURL = "jdbc:mysql://localhost:3306/testdb";
		Connection con=null;
		try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con = DriverManager.getConnection(connectionURL, "root", "");
		System.out.print("Conn: "+con);
		PreparedStatement ps = con.prepareStatement("INSERT INTO picture VALUES(?,?)");
		File file = new File("C:/images/images.jpg");
		System.out.println(""+file);
		FileInputStream fs = new FileInputStream(file);
		ps.setInt(1,1);
		ps.setBinaryStream(2,fs,fs.available());
		int i = ps.executeUpdate();
		if(i!=0){
			response.sendRedirect("ImgSuccess.jsp");
			//pw.println("image inserted successfully");
		}else{
			pw.println("problem in image insertion");
		}
		} catch (Exception e){
		System.out.println(e);
		
		}
	}

}
