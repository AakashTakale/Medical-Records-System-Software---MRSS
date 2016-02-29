package dha.pkg.java;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NurseLogin
 */
public class NurseLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NurseLogin() {
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
		String hdnParam	=	request.getParameter("pagename1");
		if(hdnParam.equals("login")){
			String userName	=	request.getParameter("txtUserName");
			String password	=	request.getParameter("txtPassword");
			if((userName.equals("admin"))&(password.equals("admin"))){
				response.sendRedirect("Nwelcome.jsp");
			}else{
					PGetsSets set = new PGetsSets();
					
					set.setEmail(userName);
					set.setPassword(password);
					
					
					try {
						int checkUser	=	NdManager.checkUser(set);
						System.out.println(checkUser);
							if(checkUser == 1){
								response.sendRedirect("Nwelcome.jsp");
							}else{
								System.out.print("Errorrrr......");
								response.sendRedirect("loginNurse.jsp");
							}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.print("Errorrrr......");
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.print("Errorrrr......");
						e.printStackTrace();
					}
					
			}
		}
	}

}
