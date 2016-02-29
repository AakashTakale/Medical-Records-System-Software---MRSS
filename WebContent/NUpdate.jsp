<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@  page  import="java.sql.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
                ResultSet rs=(ResultSet)request.getAttribute("Update");
                String id="", fname="", lname="", ssn="";

                if(rs.next())
                 {
                   id=rs.getString("id");
                   fname=rs.getString("fName");
                   lname=rs.getString("lname");
                   ssn=rs.getString("SSN");
                 }
       %>

       <form action="NController" method="get">
        <input type="hidden" name="oper" value="Edit"/>
        <table bgcolor="lightblue" align="center" border="1" width='20%' id="sig" cellspacing='2' cellpadding='3' border-spacing='0' ">

        <tr>
        <td>ID:</td>
        <td><input type="text" name="id" value="<%=id %>"></td>
        </tr>

        <tr>
       <td>First Name:</td>
        <td><input type="text" name="fname"  value="<%=fname %>"></td>
        </tr>

        <tr>
        <td>Last Name:</td>
        <td><input type="text" name="lname"  value="<%=lname %>"></td>
        </tr>
        
        <tr>
        <td>SSN:</td>
        <td><input type="text" name="ssn"  value="<%=ssn %>"></td>
        </tr>


     <tr>
        <th colspan='2'><input type="submit" value="Submit"></th>
        </tr>

</table>
        

       </form>
</body>
</html>