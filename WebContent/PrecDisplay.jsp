<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Iterator" %>
    <%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div style="margin-top: 10em">
	<table align="left" border="1px" width="40%" margin-top="20em">
	<%Iterator itr; %>
	<% List data = (List)request.getAttribute("PatData");
	System.out.print(data);
	%>
	
	<%
	itr = data.iterator();
	for(int i=0;i<data.size()/18;i++)
	{
		int j=0;
		
	  %><tr><% 
	for(;itr.hasNext();){
		
          if(j==5)
          {
        	  break;
          }
		 String s = (String)itr.next();
		 j++;
		%>
		<td><%= s %></td>
		<td><input type = "submit" value = "Edit" name = "edit" onclick = "editrecord(<%=s%>);"></td>
		
		
	<%}%></tr><%}%>

	</table>
	
</div>
</body>
</html>