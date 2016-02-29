package dha.pkg.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.java.swing.plaf.windows.resources.windows;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
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
		PrintWriter out = response.getWriter();
		if(hdnParam.equals("register")){
			String fname	=	request.getParameter("txtFName");
			String lname	=	request.getParameter("txtLName");
			String gender	=	request.getParameter("rdoGender");
			String email	=	request.getParameter("txtEmail");
			String city	=	request.getParameter("txtCity");
			String spec	=	request.getParameter("cboSpec");
			String state	=	request.getParameter("cboStates");
			String password	=	request.getParameter("txtPassword");
			String age	=	request.getParameter("cboAge");
			String address	=	request.getParameter("txtarAddress");
			System.out.print(fname+lname+gender+email+state+password+age+address);
			
			GetsSets sets	=	new GetsSets();
			 
			sets.setFname(fname);
			sets.setLname(lname);
			sets.setGender(gender);
			sets.setEmail(email);
			sets.setPassword(password);
			sets.setSpec(spec);
			sets.setCity(city);
			sets.setState(state);
			sets.setAge(age);
			sets.setAddress(address);
			
			try {
				DbManager.Insert(sets);
				
				out.print("<script type=\"text/JavaScript\">");
                out.print("alert(\"Inserted Successfully\")");             
                out.print("</script>");
				
                response.sendRedirect("login.jsp");
			} 
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(hdnParam.equals("login")){
			String userName	=	request.getParameter("txtUserName");
			String password	=	request.getParameter("txtPassword");
			
			//HttpSession s = request.getSession();
			//s.setAttribute("user", userName);
			
			if((userName.equals("admin"))&(password.equals("admin"))){
				response.sendRedirect("Dwelcome.html");
			}else{
					GetsSets set = new GetsSets();
					
					set.setEmail(userName);
					set.setPassword(password);
					
					
					try {
						int checkUser	=	DbManager.checkUser(set);
						System.out.println(checkUser);
							if(checkUser == 1){
								response.sendRedirect("Dwelcome.html");
							}else{
								System.out.print("Errorrrr......");
								
								response.sendRedirect("error.jsp");
								
							}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			}
		}
 }
}
