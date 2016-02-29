<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4><p style="color:red; margin-left:36em">Sorry, username and password do not match.</p></h4>
<%
getServletContext().getRequestDispatcher("/plogin.jsp").include(request, response);
%>
</body>
</html>