package dha.pkg.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrescServlet
 */
public class PrescServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrescServlet() {
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
		String hdnParam	=	request.getParameter("pagename2");
		System.out.println(""+hdnParam);
		PrintWriter out = response.getWriter();
		if(hdnParam.equals("presc")){
			String fname	=	request.getParameter("fname");
			String lname	=	request.getParameter("lname");
			String content	=	request.getParameter("content");
			
			System.out.print(fname+lname+content);
			
			GetsSets2 sets	=	new GetsSets2();
			
			sets.setFname(fname);
			sets.setLname(lname);
			sets.setContent(content); 
	    
		try {
			DbManager1.Insert(sets);
			
			out.print("<script type=\"text/JavaScript\">");
            out.print("alert(\"Inserted Successfully\")");             
            out.print("</script>");
			
            response.sendRedirect("Dwelcome.html");
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	  }
	}
}
