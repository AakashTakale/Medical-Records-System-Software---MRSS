package dha.pkg.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Serv1
 */
public class Serv1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serv1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password=null;
		Connection connection=null;
		boolean status=false;
		RequestDispatcher requestDispatcher;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");
			Statement statement=connection.createStatement();
			
			ResultSet emailResultSet=statement.executeQuery("select email,password from login where email='"+email+"'");
			if(emailResultSet.next())
			{
				password=emailResultSet.getString("password");
				status=true;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			if(status){
				requestDispatcher = request.getRequestDispatcher("EmailSendServ?password="+password+"&mail="+email);
				requestDispatcher.include(request, response);
			}
			else{
				out.println("<script type=\"text/javascript\">");  
		       	 out.println("alert('Unknown Email Id to this appllication');");  
		       	 out.println("</script>");
				 requestDispatcher=request.getRequestDispatcher("frgtpaswd.jsp");
				 requestDispatcher.include(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
