package dha.pkg.java;

import java.io.IOException;


import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;	
/**
 * Servlet implementation class EmailSendServ
 */
public class EmailSendServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailSendServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    	
	private String host;
	private String port;
	private String username;
	private String password;

	public void init() {
		// TODO Auto-generated method stub
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		username = context.getInitParameter("username");
		password = context.getInitParameter("password");
		
		System.out.print(""+host+port);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
					
		
		// reads form fields
		String recipient = request.getParameter("email");
		String subject="Forgot password";
		String forgotPassword=request.getParameter("password");
		String resultMessage =null;

		try {
			
			EmailUtility.sendEmail(host, port, username, password, recipient, subject,
					forgotPassword);
			resultMessage = "The e-mail was sent successfully";
		} catch (Exception ex) {
			ex.printStackTrace();
			resultMessage = "There were an error: " + ex.getMessage();
		} finally {
			request.setAttribute("Message", resultMessage);
			
			getServletContext().getRequestDispatcher("/rslt.jsp").forward(
					request, response);
		}
	}

}
