<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page import="java.util.*" %>
<%@ page import="com.classes.Department" %>
 
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
	<td><b>Department Id</b></td>
	<td><b>Dpartment name</b></td>
</tr>
<%
List<?> list = (ArrayList<?>)session.getAttribute("allDepartments");
if(list.size()>0)
for(int i=0;i<list.size();i++)
{
	Department e = (Department)list.get(i);
 %>
	
	<tr bgcolor="#DEB887">
	
	<td><%=e.getDepartmentId() %></td>
	<td><%=e.getDepartmentName() %></td>
	
	</tr>

<% 
	}
%>
</table>
</body>
</html>