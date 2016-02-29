package TestCases;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RegistrationTestCase extends TestCase {

 @Mock
 HttpServletRequest request;
 @Mock
 HttpServletResponse response;
 @Mock
 HttpSession session;

 @Mock
 RequestDispatcher rd;


    @Before
 protected void setUp() throws Exception {
  MockitoAnnotations.initMocks(this);
 }

 @Test
 public void test() throws Exception {

  /*HttpServletRequest request = mock(HttpServletRequest.class);
  HttpServletResponse response = mock(HttpServletResponse.class);
  HttpSession session = mock(HttpSession.class);
  RequestDispatcher rd=mock(RequestDispatcher.class);
  */

  when(request.getParameter("user")).thenReturn("aak");
  when(request.getParameter("password")).thenReturn("123456");
  when(request.getParameter("rememberMe")).thenReturn("Y");
  when(request.getSession()).thenReturn(session);
  when(request.getRequestDispatcher("/HelloWorld.do")).thenReturn(rd);


  StringWriter sw = new StringWriter();
  PrintWriter pw = new PrintWriter(sw);
  
  when(response.getWriter()).thenReturn(pw);
  
  new Login().doPost(request, response);
  
  //Verify the session attribute value
  verify(session).setAttribute("user", "aak");
  
  verify(rd).forward(request, response);
  
  String result = sw.getBuffer().toString().trim();

  System.out.println("Result: "+result);
  
  assertEquals("Login successfull...", result);
 }
}