<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page import="java.util.*" %>
<%@ page import="com.classes.Regulation" %>
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
	<td><b>Regulation Id</b></td>
	<td><b>department Name</b></td>
	<td><b>Regulation</b></td>
	<td><b>Comments</b></td>
	<td><b>Add</b></td>
</tr>
<%
List<?> list = (ArrayList<?>)session.getAttribute("departmentRegulation");
if(list.size()>0)
for(int i=0;i<list.size();i++)
{
	Regulation e = (Regulation)list.get(i);
 %>
	
	<tr bgcolor="#DEB887">
	
	<td><%=e.getRegulationId() %></td>
	<td><%=e.getDepartmentName() %></td>
	<td><%=e.getRegulationName() %></td>
	<td><%=e.getListOfComments() %></td>
	<td><div><a href="addCommentWindow" class="link-info">addComments</a></div></td>
	
	</tr>

<% 
	}
%>
</table>
</body>
</html>