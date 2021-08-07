<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page import="java.util.*" %>
<%@ page import="com.classes.Employee" %>
  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2 align="center"><font><strong>Retrieve data from database in jsp</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
	<tr bgcolor="#A52A2A">
	<td><b>empid</b></td>
	<td><b>firstname</b></td>
	<td><b>lastname</b></td>
	<td><b>DOB</b></td>
	<td><b>Email</b></td>
	<td><b>Department id</b></td>
	<td><b>username</b></td>
	
</tr>
<%
List<?> list = (ArrayList<?>)session.getAttribute("allEmployees");
if(list.size()>0)
for(int i=0;i<list.size();i++)
{
	Employee e = (Employee)list.get(i);
 %>
	
	<tr bgcolor="#DEB887">
	
	<td><%=e.getEmpid() %></td>
	<td><%=e.getFirstname() %></td>
	<td><%=e.getLastname() %></td>
	<td><%=e.getDob() %></td>
	<td><%=e.getEmail() %></td>
	<td><%=e.getDepartment_id() %></td>
	<td><%=e.getUsername() %></td>
	
	</tr>

<% 
	}
%>
</table>

</body>
</html>