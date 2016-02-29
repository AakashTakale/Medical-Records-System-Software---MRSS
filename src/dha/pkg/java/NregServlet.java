package dha.pkg.java;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NregServlet
 */
public class NregServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NregServlet() {
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
		
		String hdnParam	=	request.getParameter("pagename");
		System.out.println(""+hdnParam);
		if(hdnParam.equals("register")){
			String fname	=	request.getParameter("txtFName");
			String lname	=	request.getParameter("txtLName");
			String Ssn	=	request.getParameter("SSN");
			String gender =	request.getParameter("rdoGender");
			String email =	request.getParameter("txtEmail");
			String password =	request.getParameter("txtPassword");
			
			NGetsSets sets	=	new NGetsSets();
			
			sets.setFname(fname);
			sets.setLname(lname);
			sets.setSsn(Ssn);
			sets.setGender(gender);
			sets.setEmail(email);
			sets.setPassword(password);
			
			try {
				NdManager.Insert(sets);
				response.sendRedirect("Dwelcome.html");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*if(hdnParam.equals("login")){
			String userName	=	request.getParameter("txtUserName");
			String password	=	request.getParameter("txtPassword");
			if((userName.equals("admin"))&(password.equals("admin"))){
				response.sendRedirect("PWelcome.jsp");
			}else{
					PGetsSets set = new PGetsSets();
					
					set.setEmail(userName);
					set.setPassword(password);
					
					
					try {
						int checkUser	=	PdManager.checkUser(set);
						System.out.println(checkUser);
							if(checkUser == 1){
								response.sendRedirect("PWelcome.jsp");
							}else{
								System.out.print("Errorrrr......");
								response.sendRedirect("plogin.jsp");
							}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			}
		}*/
	}

}
