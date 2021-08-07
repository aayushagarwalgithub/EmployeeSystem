<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div>
	<a href="displayAllEmployee" class="link-info">Display All Employee</a>
</div>

<div>
	<a href="viewDepartments" class="link-info">view Departments</a>
</div>

<div>
	<a href="viewRegulation" class="link-info">View Regulation</a>
</div>

<div>
	<a href="employeeLogout" class="link-info">Logout</a>
</div>



<h2>Welcome to Customer Home Page  <span class="badge bg-danger ms-2">${sessionScope.username}</span></h2>

 <span style="color:red">${sessionScope.orderMsg} </span>
</body>
</html>