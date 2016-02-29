package dha.pkg.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
         
         ConnectionManager cm = new ConnectionManager();
     	 Connection con = (Connection) cm.openConnection();
     	 
         String name=request.getParameter("txtName");                          
         try{
                
                PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from patientregister where SSN=?");
                ps.setString(1,name);  
                
                out.println("<html>");
               
                out.println("<body>");
                //<div style="background-image: url('http://www.mypicx.com/uploadimg/1312875436_05012011_2.png')"></div>
                out.print("<div style= margin-left:5% style = background-image: url('http://www.sorrywatch.com/wp-content/uploads/2013/07/talk-to-your-doctor-small.jpg')>");
                out.print("<table border=1 width=27% margin-left=20% ");
                out.print("<h2><strong>Patient History: </strong></h2>");
                
                ResultSet rs=(ResultSet) ps.executeQuery();                
                /* Printing column names */
                ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();
                while(rs.next())
                   {
                
                	out.print("<tr>");
                	out.print("<tr><td></td></tr>");
                	out.print("<tr><td></td></tr>");
                	out.print("<tr><td></td></tr>");
                	out.print("<tr><td></td></tr>");
                	
                   out.print("<tr><td>Name: </td>");
                   out.print("<td>"+rs.getString(2));
                   out.print(" "+rs.getString(3)+"</td></tr>");
                   out.print("<tr><td>"+rsmd.getColumnName(4)+":</td>");
                   out.print("<td>"+rs.getString(4)+"</td></tr>");
                   out.print("<tr><td>Date Of Birth: </td>");
                   out.print("<td>"+rs.getString(6));
                   out.print(" "+rs.getString(5));
                   out.print(", "+rs.getString(7)+"</td></tr>");
                   out.print("<tr><td>"+rsmd.getColumnName(8)+":</td>");
                   out.print("<td>"+rs.getString(8)+"</td></tr>");
                   out.print("<tr><td>"+rsmd.getColumnName(9)+":</td>");
                   out.print("<td>"+rs.getString(9)+"</td></tr>");
                   out.print("<tr><td>"+rsmd.getColumnName(10)+":</td>");
                   out.print("<td>"+rs.getString(10)+"</td></tr>");
                   out.print("<tr><td>"+rsmd.getColumnName(11)+":</td>");
                   out.print("<td>"+rs.getString(11)+"</td></tr>");
                   out.print("<tr><td>"+rsmd.getColumnName(12)+":</td>");
                   out.print("<td>"+rs.getString(12)+"</td></tr>");
                   out.print("<tr><td>Email Id: </td>");
                   out.print("<td>"+rs.getString(13)+"</td></tr>");
                   out.print("<tr><td></td></tr>");
                   out.print("<tr><td></td></tr>");
                   
                   out.print("<tr><td><strong>Emergency Contact Details: </strong></td></tr>");
                   
                   out.print("<tr><td></td></tr>");
                   out.print("<tr><td></td></tr>");
                   out.print("<tr><td>Name: </td>");
                   out.print("<td>"+rs.getString(15));
                   out.print(" "+rs.getString(16)+"</td></tr>");
                   out.print("<tr><td>Relationship: </td>");
                   out.print("<td>"+rs.getString(17)+"</td></tr>");
                   out.print("<tr><td>Contact No.: </td>");
                   out.print("<td>"+rs.getString(18)+"</td></tr>");
                   out.print("<tr><td>Any Physician? </td>");
                   out.print("<td>"+rs.getString(19)+"</td></tr>");
                   out.print("<tr><td>Physician Name: </td>");
                   out.print("<td>"+rs.getString(20)+"</td></tr>");
                   out.print("<tr><td>Height: </td>");
                   out.print("<td>"+rs.getString(21)+"</td></tr>");
                   out.print("<tr><td>Weight: </td>");
                   out.print("<td>"+rs.getString(22)+"</td></tr>");
                   out.print("<tr><td>Blood Group: </td>");
                   out.print("<td>"+rs.getString(23)+"</td></tr>");
                   out.print("<tr><td>Current Medication: </td>");
                   out.print("<td>"+rs.getString(24)+"</td></tr>");
                   
                }
                out.print("</table>");
                out.print("</div>");
                out.println("</body>");
                out.println("</html>");

         }catch (Exception e2)
           {
               e2.printStackTrace();
               System.out.print("Patient" +name+ "Not found..");
           }

         finally{
        	 out.close();
           }
  }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*ConnectionManager cm;
		Connection conn;
		Statement stmt;
		ResultSet res;
		String query;
		List<String> lst = new ArrayList<String>();
		PGetsSets set = new PGetsSets();
		PrintWriter out = response.getWriter(); 
		String userSSN	=	request.getParameter("txtSSN");
		
		try {
			cm = new ConnectionManager();
			conn = (Connection) cm.openConnection();
			stmt = (Statement) conn.createStatement();
			query = "select * from patientregister";
			res = cm.getResult(query, conn);
			
			ps = (PreparedStatement) conn.prepareStatement("");
			ps.setString(1, set.getSsn());
			rs = (ResultSet) ps.executeQuery();
				
			while(res.next()){
				res.next();
				lst.add(res.getString("fname"));
				lst.add(res.getString("lname"));
				lst.add(res.getString("Ssn"));
				lst.add(res.getString("dbmonth"));
				lst.add(res.getString("dbday"));
				lst.add(res.getString("dbyear"));
				lst.add(res.getString("age"));
				lst.add(res.getString("gender"));
				lst.add(res.getString("address"));
				lst.add(res.getString("city"));
				lst.add(res.getString("state"));
				lst.add(res.getString("email"));
				lst.add(res.getString("efname"));
				lst.add(res.getString("elname"));
				lst.add(res.getString("erelation"));
				lst.add(res.getString("econtact"));
				lst.add(res.getString("anyphy"));
				lst.add(res.getString("pname"));
				lst.add(res.getString("height"));
				lst.add(res.getString("weight"));
				lst.add(res.getString("blood"));
				lst.add(res.getString("medic"));
			}
			res.close();
			
				System.out.println("User found with details="+lst);
				HttpSession session = request.getSession();
				session.setAttribute("Patient", lst);
				response.sendRedirect("DoctorPRetrieve.jsp");
				
			else{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin.jsp");
				PrintWriter out= response.getWriter();
				out.println("User not found with SSN="+userSSN);
				out.println("<font color=red>No user found with given SSN </font>");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database connection problem");
			throw new ServletException("DB Connection problem.");
		}finally{
			request.setAttribute("Patient", lst);
			RequestDispatcher rd = request.getRequestDispatcher("/DoctorPRetrieve");
			rd.forward(request,response);
			lst.clear();
			out.close();
			} 
			*/
	}	
}
