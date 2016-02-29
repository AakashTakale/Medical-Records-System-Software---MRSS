package dha.pkg.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Pdisplay
 */
public class Pdisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pdisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query;
		
		ConnectionManager cm = new ConnectionManager();
    	Connection conn = (Connection) cm.openConnection();
    	
    	
    	
    	ResultSet res;
    	Statement stmt;
    	
    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();
    	List<String> lst = new ArrayList<String>();
        
        try{
        	stmt = (Statement) conn.createStatement();
        	query = "select * from patientregister";
        	
        	res = cm.getResult(query, conn);
        	
        	while(res.next()){
        		lst.add(res.getString("fname"));
        		lst.add(res.getString("lname"));
        		lst.add(res.getString("SSN"));
        		lst.add(res.getString("Age"));
        		lst.add(res.getString("Gender"));
        		
        	}
        	res.close(); 
        	
        }catch (Exception E){
        	RequestDispatcher rd = request.getRequestDispatcher("/PWelcome.jsp");
        	rd.forward(request, response);
        	
        }finally{
        	request.setAttribute("PatData", lst);
        	
        	System.out.print("debug"+ lst.size());
        	RequestDispatcher rd = request.getRequestDispatcher("/PrecDisplay.jsp");
        	rd.forward(request, response);
        	lst.clear();
        	out.close();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
