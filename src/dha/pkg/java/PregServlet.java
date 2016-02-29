package dha.pkg.java;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PregServlet
 */
public class PregServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PregServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hdnParam	=	request.getParameter("pagename1");
		System.out.println(""+hdnParam);
		if(hdnParam.equals("register")){
			String fname	=	request.getParameter("txtFName");
			String lname	=	request.getParameter("txtLName");
			String Ssn	=	request.getParameter("SSN");
			String dbmonth =	request.getParameter("DOBMonth");
			String dbday =	request.getParameter("DOBDay");
			String dbyear =	request.getParameter("DOBYear");
			String age =	request.getParameter("Age");
			String gender =	request.getParameter("rdoGender");
			String address =	request.getParameter("txtarAddress");
			String city =	request.getParameter("city");
			String state =	request.getParameter("cboStates");
			String email =	request.getParameter("txtEmail");
			String password =	request.getParameter("txtPassword");
			String efname =	request.getParameter("EtxtFName");
			String elname =	request.getParameter("EtxtLName");
			String erelation =	request.getParameter("Erelationship");
			String econtact =	request.getParameter("Econtact");
			String anyphy =request.getParameter("Anyphy");
			String pname	=	request.getParameter("txtPhyname");
			String height	=	request.getParameter("txtHeight");
			String weight	=	request.getParameter("txtWeight");
			String blood	=	request.getParameter("BloodGroup");
			String medic	=	request.getParameter("Medication");
			

			System.out.print(fname+lname+Ssn+dbmonth+dbday+dbyear+age+gender+address+city+state+email+password+efname+elname+erelation+econtact+anyphy+pname+height+weight+blood+medic);
			
			PGetsSets sets	=	new PGetsSets();
			 
			sets.setFname(fname);
			sets.setLname(lname);
			sets.setSsn(Ssn);
			sets.setGender(gender);
			sets.setDbmonth(dbmonth);
			sets.setDbday(dbday);
			sets.setDbyear(dbyear);
			sets.setAge(age);
			sets.setGender(gender);
			sets.setAddress(address);
			sets.setCity(city);
			sets.setState(state);
			sets.setEmail(email);
			sets.setPassword(password);
			sets.setEfname(efname);
			sets.setElname(elname);
			sets.setErelation(erelation);
			sets.setEcontact(econtact);
			sets.setAnyphy(anyphy);
			sets.setPname(pname);
			sets.setHeight(height);
			sets.setWeight(weight);
			sets.setBlood(blood);
			sets.setMedic(medic);
			
			
			try {
				PdManager.Insert(sets);
				response.sendRedirect("plogin.jsp");
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
				response.sendRedirect("PWelcome.jsp");
			}else{
					PGetsSets set = new PGetsSets();
					
					set.setEmail(userName);
					set.setPassword(password);
					request.getSession().setAttribute("username", userName);
					
					try {
						int checkUser	=	PdManager.checkUser(set);
						System.out.println(checkUser);
							if(checkUser == 1){
								response.sendRedirect("PWelcome.jsp");
							}else{
								System.out.print("Errorrrr......");
								response.sendRedirect("perror.jsp");
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
