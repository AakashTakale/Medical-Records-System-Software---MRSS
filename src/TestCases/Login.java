package TestCases;

 import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Login extends HttpServlet {
private static final long serialVersionUID = 38044879686270933L;

/**
* Instantiates a new login.
*/
public Login() {
super();
}

/* (non-Javadoc)
* @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
*/
public void init(ServletConfig config) throws ServletException// called once servlet loads
{
System.out.println("Login Init called...");
try {
super.init(config);
} catch (ServletException e) {
e.printStackTrace();
}
}

/* (non-Javadoc)
* @see javax.servlet.GenericServlet#destroy()
*/
public void destroy()// called just before servlet unload
{
System.out.println("Login Destroyed...");
super.destroy();
}

/* (non-Javadoc)
* @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
*/
public void doPost(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException {
System.out.println("Login doPost...");
String name = req.getParameter("user");
String pwd = req.getParameter("password");
String rememberMe = req.getParameter("rememberMe");
System.out.println("User: "+name+" | password: "+pwd);
if(name.equals("siva") && pwd.equals("123456")) {
HttpSession session=req.getSession();
session.setAttribute("user", name);
Cookie ck1 = new Cookie("user", name);
Cookie ck2 = new Cookie("pwd", pwd);
res.addCookie(ck1);
res.addCookie(ck2);
if(rememberMe!=null && rememberMe!=""){
  Cookie ck3 = new Cookie("rememberMe", rememberMe);
  res.addCookie(ck3);
}
}

PrintWriter out= res.getWriter();
out.write("Login successfull...");
//Dispatching request
RequestDispatcher rd=req.getRequestDispatcher("/HelloWorld.do");
rd.forward(req, res);
}
}