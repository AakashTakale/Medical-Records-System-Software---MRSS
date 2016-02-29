<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
</head>
<body>
<% request.getSession().invalidate(); %>
<div align="center">
<h3><p>You have been successfully Loged out</p></h3>
<h3>Go to Homepage </h3> <h3><a href="index.html">HomePage</a></h3>
</div>
</body>
</html>