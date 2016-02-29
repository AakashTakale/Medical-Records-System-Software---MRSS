package dha.pkg.java;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String oper=request.getParameter("oper");
		if(oper.equals("list")){
			Student s=new Student();
	        ResultSet rs=s.getStudList();
	        request.setAttribute("List", rs);
	        RequestDispatcher rd=request.getRequestDispatcher("List.jsp");
	        rd.forward(request, response);
		}
		 else if(oper.equals("Update"))
	      {
	        int id=Integer.parseInt(request.getParameter("id")); 

	        Student s=new Student();
	        ResultSet rs=s.getStudInfo(id);
	        request.setAttribute("Update", rs);

	        RequestDispatcher rd=request.getRequestDispatcher("Update.jsp");
	        rd.forward(request, response);
	      }
		 else if(oper.equals("Edit"))
	      {
	        System.out.print(""+oper);
			int id=Integer.parseInt(request.getParameter("id")); 
	        String fname=request.getParameter("fname"); 
	        String lname=request.getParameter("lname"); 
	        int ssn=Integer.parseInt(request.getParameter("ssn")); 

	        Student s=new Student();
	        s.updateStud(id,fname,lname,ssn);
	        
	        System.out.print(""+fname+lname+ssn+id);

	        RequestDispatcher rd=request.getRequestDispatcher("Controller?oper=list");
	        rd.forward(request, response);
	        
	        
	      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
