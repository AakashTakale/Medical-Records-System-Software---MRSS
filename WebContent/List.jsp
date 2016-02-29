<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@  page  import="java.sql.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details</title>
</head>
<body>
<%
          ResultSet rs=(ResultSet)request.getAttribute("List");
%>

<table border="1" border="1" width='600' id="sig" cellspacing='0' cellpadding='3' border-spacing='0' style="margin:0;padding:0;">
<tr>
<th>ID</th>
<th>First Name</th>
<th>Last Name</th>
<th>SSN</th>
</tr>

<%
        int id=0; 

         while(rs.next())
            {
               id=rs.getInt("id"); 
%>

<tr>
<td><%=id %></td>
<td><%=rs.getString("fname") %></td>
<td><%=rs.getString("lname") %></td>
<td><%=rs.getInt("SSN") %></td>
<td><a href="Controller?id=<%=id %>&oper=Update">Update</a></td>
</tr>

<%
            }
%>

</table>

</body>
</html>