package dha.pkg.java;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class PatDisplay
 */
public class PatDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = (Connection) getServletContext().getAttribute("DBConnection");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select * from patientregister where fname=?");
			
			rs = ps.executeQuery();
			
			
			if(rs != null){
				rs.next();
				patientregister pr = new patientregister();
				pr.setFname(rs.getString("fname"));
				pr.setFname(rs.getString("lname"));
				pr.setFname(rs.getString("SSN"));
				pr.setFname(rs.getString("Email"));
				,rs.getString("middlename"),
				rs.getString("firstname"),
				rs.getString("eveningcontactno"),
				rs.getString("id"),
				rs.getString("currentaddress"),
				rs.getString("email");
				logger.info("User found with details="+patient);
				HttpSession session = request.getSession();
				session.setAttribute("Patient", patient);
				response.sendRedirect("DoctorPatientRet.jsp");;
			}else{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/Retrievepatient.html");
				PrintWriter out= response.getWriter();
				logger.error("User not found with firstname="+firstname);
				out.println("<font color=red>No user found with given firstname </font>");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Database connection problem");
			throw new ServletException("DB Connection problem.");
		}finally{
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				logger.error("SQLException in closing PreparedStatement or ResultSet");;
			}
			
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
