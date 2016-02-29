package dha.pkg.java;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class NController
 */
public class NController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NController() {
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
			NStudent s=new NStudent();
	        ResultSet rs=s.getStudList();
	        request.setAttribute("List", rs);
	        RequestDispatcher rd=request.getRequestDispatcher("NList.jsp");
	        rd.forward(request, response);
		}
		 else if(oper.equals("Update"))
	      {
	        int id=Integer.parseInt(request.getParameter("id")); 

	        NStudent s=new NStudent();
	        ResultSet rs=s.getStudInfo(id);
	        request.setAttribute("Update", rs);

	        RequestDispatcher rd=request.getRequestDispatcher("NUpdate.jsp");
	        rd.forward(request, response);
	      }
		 else if(oper.equals("Edit"))
	      {
	        System.out.print(""+oper);
			int id=Integer.parseInt(request.getParameter("id")); 
	        String fname=request.getParameter("fname"); 
	        String lname=request.getParameter("lname"); 
	        int ssn=Integer.parseInt(request.getParameter("ssn")); 

	        NStudent s=new NStudent();
	        s.updateStud(id,fname,lname,ssn);
	        
	        System.out.print(""+fname+lname+ssn+id);

	        RequestDispatcher rd=request.getRequestDispatcher("NController?oper=list");
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
